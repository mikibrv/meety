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

        user.addLanguage("English").addLanguage("Romanian").addLanguage("Hungarian");
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

    @Test
    public void addAlex() {
        User user = new User();
        user.setName("Alex");
        user.setDeviceId(getRandomId());
        user.setPicture("https://scontent-fra3-1.xx.fbcdn.net/hphotos-xpa1/v/t1.0-9/11168122_822100267874024_1600658966847055389_n.jpg?oh=cb5912b6769784dcbbe7a5a297d53723&oe=5600339F");
        user.addJob(new Occupation().setAt("Pentalog Romania")
                .setTitle("Javascript Developer")
                .setYearStarted(2012));

        user.addLanguage("Romanian").addLanguage("English").addLanguage("French");

        user.addEducation(new Occupation().setAt("Unitbv")
                .setTitle("Student")
                .setYearFinished(2009)
                .setYearStarted(2012));

        user.setLocation(new UserLocation().setLocationName("Cluj Napoca")
                        .setLatitude(46.78)
                        .setLongitude(23.61)
        );

        user.setHomeTown(new UserLocation().setLocationName("Brasov")
                .setLatitude(45.66)
                .setLongitude(25.49));

        user.addHistoricLocation(new UserLocation().setLocationName("Brasov")
                .setLatitude(45.65)
                .setLongitude(25.59));

        user.addHistoricLocation(new UserLocation().setLocationName("Cluj Napoca")
                        .setLatitude(46.78)
                        .setLongitude(23.61)
        );

        user.addInterest("Motorolla360");
        user.addInterest("BackBoneJS");
        user.addInterest("Javascript");

        userRepository.save(user);
    }


    private String getRandomId() {
        return UUID.randomUUID().toString();
    }
}
