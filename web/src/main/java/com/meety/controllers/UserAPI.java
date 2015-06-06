package com.meety.controllers;

import com.meety.User;
import com.meety.UserCompared;
import com.meety.repository.UserRepository;
import com.meety.service.UserComparator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    public List<UserCompared> submitLocation(@RequestBody User currentUser) {
        List<User> users = userRepository.findAll();

        if (currentUser.getDeviceId() == null) {
            return null;
        }
        User user = userRepository.findByDeviceId(currentUser.getDeviceId());

        user.setLocation(currentUser.getLocation());
        userRepository.save(user);

        List<UserCompared> userComparedList = new ArrayList<UserCompared>();

        for (User userToCompare : users) {
            if (!userToCompare.getDeviceId().equals(user.getDeviceId())) {
                UserComparator userComparator = new UserComparator(user, userToCompare);
                userComparedList.add(userComparator.compare());
            }
        }
        return userComparedList;
    }

}

