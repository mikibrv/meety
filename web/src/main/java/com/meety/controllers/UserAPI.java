package com.meety.controllers;

import com.meety.User;
import com.meety.UserLocation;
import com.meety.repository.UserRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by miki on 06.06.2015.
 */
@RestController
@RequestMapping("/user")
public class UserAPI {


    @Resource
    private UserRepository userRepository;


    @RequestMapping(method = RequestMethod.GET, value = "/{name}")
    public User getByName(@PathVariable("name") String name) {
        return userRepository.findByName(name);
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public List<User> submitLocation(@RequestBody User user) {
        return null;
    }

}

