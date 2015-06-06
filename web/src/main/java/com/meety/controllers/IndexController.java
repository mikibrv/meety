package com.meety.controllers;

import com.meety.User;
import com.meety.repository.UserRepository;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by miki on 04.06.2015.
 */
@Controller
public class IndexController {

    @Resource
    private SimpMessagingTemplate template;

    @Resource
    UserRepository userRepository;


    @RequestMapping("/")
    public ModelAndView handleResponse() {
        ModelAndView model = new ModelAndView("index");
        model.addObject("user", userRepository.findAll().get(0));
        return model;
    }

    @RequestMapping("/test")
    @SendTo("/topic/notifications")
    public
    @ResponseBody
    User triggerWebSocketNotif() {
        User user = new User();
        user.setName("testi");
        template.convertAndSend("/topic/notifications", user);
        return user;
    }

    @MessageMapping("/hello")
    @SendTo("/topic/notifications")
    public User notifyClients(String message) {
        User user = new User();
        user.setName(message);
        return user;
    }

}

