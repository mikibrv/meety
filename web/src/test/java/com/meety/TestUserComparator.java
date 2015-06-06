package com.meety;

import com.meety.repository.UserRepository;
import com.meety.service.UserComparator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by miki on 06.06.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MeetyBootStrap.class)
public class TestUserComparator {

    @Resource
    private UserRepository userRepository;


    @Test
    public void testUserComparator() {
        User user = userRepository.findByName("Alex");
        User userM = userRepository.findByName("Miki");

        UserCompared userCompared = new UserComparator(user, userM).compare();
        assertTrue(userCompared.getCountSimilarities() > 0);
        System.out.println(userCompared.getCountSimilarities());
    }
}
