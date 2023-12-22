package com.example.sc.controllers;


import com.example.sc.dao.UserDao;
import com.example.sc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class RegController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/reg")
    public String registration(){
        return "reg";
    }
    @PostMapping("/reg")
    public String addUser(User user, Map<String, Object> model){
//        User userDB = userRepo.findByName(user.getName());
//
//        if (userDB != null){
//            return "reg";
//        }
        System.out.println(user.getName() + user.getPassword()+" ");

        user.setActive(true);
        user.setRoles("USER");
        userDao.save(user);
        return "redirect:/login";
    }
}
