package com.example.docservice.service;

import com.example.docservice.entity.User;
import com.example.docservice.exception.UserIncorrectDataEntryException;
import com.example.docservice.exception.UserNotFaundException;
import com.example.docservice.repository.UserCrudRepository;
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

    @Override
    public void registrationUser(User user) throws UserIncorrectDataEntryException {
        if (user == null) {
            throw new UserIncorrectDataEntryException("Введенны некоректные данные");
        }
        userRepo.save(user);
    }

    @Override
    public User getUserById(Long userId) throws UserNotFaundException {
        User user;
        Optional<User> optional = userRepo.findById(userId);
        if (optional.isPresent()) {
            user = optional.get();
        } else throw new UserNotFaundException("Такого пользователя не существет");
        return user;
    }

    @Override
    public Page<User> getUserAll(Pageable pageable) throws UserIncorrectDataEntryException {
        return userRepo.findAll(pageable);
    }

    @Override
    public Page<User> findAllUsersSortedByName(@SortDefault(sort = "firstName",
            direction = Sort.Direction.ASC) @PageableDefault(value = 2, page = 0, size = 10) Pageable pageable) throws UserIncorrectDataEntryException {
        return userRepo.findAll(pageable);
    }

    @Override
    public List<User> getUserByLastName(String lastName) throws UserIncorrectDataEntryException {
        List<User> users = userRepo.findAllByLastName(lastName);
        return users;
    }

    @Override
    public void deleteUser(Long userId) throws UserIncorrectDataEntryException {
        userRepo.deleteById(userId);
    }

}
