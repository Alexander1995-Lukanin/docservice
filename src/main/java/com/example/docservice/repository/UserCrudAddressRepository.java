package com.example.docservice.repository;

import com.example.docservice.entity.UserAddressEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCrudAddressRepository extends CrudRepository <UserAddressEntity,Long> {
    UserAddressEntity findByCountry (String country);
    UserAddressEntity findByRegion (String region);
    UserAddressEntity findByCity (String city);
    UserAddressEntity findByStreet (String street);
    UserAddressEntity findByHouse (String house);
    UserAddressEntity findByFlat(String flat);


}
