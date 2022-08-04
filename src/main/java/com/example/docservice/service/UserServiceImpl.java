package com.example.docservice.service;

import com.example.docservice.entity.User;
import com.example.docservice.exception.UserIncorrectDataEntryException;
import com.example.docservice.exception.UserNotFoundException;
import com.example.docservice.repository.UserCrudRepository;
import com.example.docservice.webClient.service.UserServiceIntegrationImpl;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserCrudRepository userRepo;
    private final UserServiceIntegrationImpl serviceIntegration;

    @Override
    public void registrationUser(User user) throws UserIncorrectDataEntryException {
        if (user == null) {
            throw new UserIncorrectDataEntryException("Введенны некоректные данные");
        }
        userRepo.save(user);
    }

    @Override
    public User getUserById(Long userId) throws UserNotFoundException {
        User user;
        Optional<User> optional = userRepo.findById(userId);
        if (optional.isPresent()) {
            user = optional.get();
        } else {
            user = serviceIntegration.getUserByIdSync(userId.toString());
            userRepo.save(user);
        }
        return user;
    }

    @Override
    public Page<User> getUserAll(Pageable pageable) {
        return userRepo.findAll(pageable);
    }

    @Override
    public Page<User> findAllUsersSortedByFirstName(@SortDefault(sort = "firstName", direction = Sort.Direction.ASC)
                                                    @PageableDefault(value = 2, page = 0, size = 10) Pageable pageable) {
        return userRepo.findAll(pageable);
    }

    @Override
    public List<User> getUserByLastName(String lastName) {
        List<User> users = userRepo.findAllByLastName(lastName);
        return users;
    }

    @Override
    public void deleteUser(Long userId) throws UserNotFoundException {
        if (userRepo.findById(userId).isPresent()) {
            userRepo.deleteById(userId);
        } else throw new UserNotFoundException("Такого пользователя не существет");
    }

    //Вынести в отдельный класс разделить на интрефейс. В пекейдж отдельный. Логика в юзер сервисе. Вызывается.


}
