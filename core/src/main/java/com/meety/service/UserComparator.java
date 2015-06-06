package com.meety.service;


import com.meety.User;
import com.meety.UserCompared;
import com.meety.UserLocation;

/**
 * Created by miki on 06.06.2015.
 */
public class UserComparator {
    User user;
    int total = 0;

    public UserComparator(User user) {
        this.user = user;
    }


    public UserCompared compare(User toCompare) {
        UserCompared userCompared = new UserCompared(toCompare);

        double distance = new DistanceCalculator().getDistance(user.getLocation(), toCompare.getLocation());

        return userCompared;
    }



}
