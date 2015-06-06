package com.meety.repository;

import com.meety.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by miki on 06.06.2015.
 */
public interface UserRepository extends MongoRepository<User, String> {

    User findByDeviceId(String deviceId);

    User findByName(String name);

}
