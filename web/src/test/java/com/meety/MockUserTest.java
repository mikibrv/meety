package com.meety;

import com.meety.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * Created by miki on 06.06.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MeetyBootStrap.class)
public class MockUserTest {

    @Resource
    private UserRepository userRepository;

    @Test
    public void addMiki() {
        User user = new User();
        user.setName("Miki");
        user.setDeviceId(getRandomId());
        user.setPicture("https://scontent-lhr3-1.xx.fbcdn.net/hphotos-xfa1/v/t1.0-9/319807_403835986311826_1699578907_n.jpg?oh=6a816b23ce29a1649b327188bf5066bd&oe=55E958FF");
        user.addJob(new Occupation().setAt("PentalogRomania")
                .setTitle("Java Developer")
                .setYearStarted(2012));

        user.addEducation(new Occupation().setAt("Unitbv")
                .setTitle("Student")
                .setYearFinished(2013)
                .setYearStarted(2010));

        user.setLocation(new UserLocation().setLocationName("Cluj Napoca")
                        .setLatitude(46.78)
                        .setLongitude(23.61)
        );

        user.setHomeTown(new UserLocation().setLocationName("Brasov")
                .setLatitude(45.65)
                .setLongitude(25.59));

        user.addHistoricLocation(new UserLocation().setLocationName("Brasov")
                .setLatitude(45.65)
                .setLongitude(25.59));

        user.addHistoricLocation(new UserLocation().setLocationName("Cluj Napoca")
                        .setLatitude(46.78)
                        .setLongitude(23.61)
        );

        user.addInterest("Football");
        user.addInterest("AngularJS");
        user.addInterest("Javascript");

        userRepository.save(user);
    }


    private String getRandomId() {
        return UUID.randomUUID().toString();
    }
}
