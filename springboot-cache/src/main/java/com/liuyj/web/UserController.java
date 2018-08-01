package com.liuyj.web;

import com.liuyj.bean.User;
import com.liuyj.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author liuyuanju1
 * @date 2018/8/1
 * @description:
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("/add")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @PostMapping("/addAdmin")
    public void addAdmin(@RequestBody User user){
        userService.addAdmin(user);
    }

    @GetMapping("/{id}")
    public User findUser(@PathVariable String id){
        return userService.findUser(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return "删除成功";
    }

    @DeleteMapping("/all")
    public String deleteAllUser(){
        userService.deleteAllUser();
        return "删除所有user";
    }
}
