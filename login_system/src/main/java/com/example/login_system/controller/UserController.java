package com.example.login_system.controller;

import com.example.login_system.entity.*;
import com.example.login_system.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //회원가입
    @RequestMapping("/addUser")
    public String addUser(HttpServletRequest request,@RequestParam(value="id") String id, @RequestParam(value="password") String password, @RequestParam(value="email") String email)
    {
        return userService.addUser(id,password,email);
    }

    //로그인
    @RequestMapping("/login")
    public String login(HttpServletRequest request,@RequestParam(value="id") String id, @RequestParam(value="password") String password)
    {
        return userService.login(id,password,request);
    }

    //이메일 가져오기
    @RequestMapping("/getEmail")
    public String getUserEmail(HttpServletRequest request)
    {
        return userService.getUserEmail(request);
    }

    //이메일 설정
    @RequestMapping("/setEmail")
    public String setUserEmail(HttpServletRequest request,@RequestParam(value="email") String email)
    {
        return userService.setUserEmail(email,request);
    }

    @RequestMapping("/get")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
