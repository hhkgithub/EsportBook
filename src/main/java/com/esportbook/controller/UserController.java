package com.esportbook.controller;

import com.esportbook.entity.User;
import com.esportbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hhkmac on 2017/4/18.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUser/{userseq}")
    public User getUser(@PathVariable("userseq") int userseq){
        User u = this.userService.getUser(userseq);
        System.out.println(u);
        return this.userService.getUser(userseq);
    }
}
