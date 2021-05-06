package com.leo.ssm.controller;

import com.leo.ssm.exception.custom.ParamsException;
import com.leo.ssm.pojo.User;
import com.leo.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    @ResponseBody
    public String saveUser(@RequestBody User user){
        userService.save(user);
        return "success";
    }



    @DeleteMapping("/user/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable("id") int userId){
        userService.delete(userId);
        return "success";
    }

    @PutMapping("/user")
    @ResponseBody
    public String updateUser(@RequestBody User user){
        userService.update(user);
        return "success";
    }

    @GetMapping("/user/{id}")
    public ModelAndView findUser(@PathVariable("id") int userId, ModelAndView mv){
        User user = userService.findById(userId);
        mv.addObject("user",user);
        mv.setViewName("hello");
        return mv;
    }

    @GetMapping("/user/findAll")
    @ResponseBody
    public List<User> findAllUser(){
        try{
            int a = 1/0;
        }catch (Exception e){
            throw new ParamsException();
//            throw new BusinessException();
        }
        return userService.findAll();
    }

}
