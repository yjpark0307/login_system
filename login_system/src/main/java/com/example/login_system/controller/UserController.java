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
    @GetMapping("/addUser")
    public String addUser(HttpServletRequest request,@RequestParam(value="id") String id, @RequestParam(value="password") String password)
    {
        return userService.addUser(id,password);
    }

    //로그인
    @PostMapping("/login")
    public String login(HttpServletRequest request,@RequestParam(value="id") String id, @RequestParam(value="password") String password)
    {
        return userService.login(id,password,request);
    }

    //이메일 가져오기
    @GetMapping("/getEmail")
    public String getUserEmail(HttpServletRequest request)
    {
        return userService.getUserEmail(request);
    }

    //이메일 설정
    @GetMapping("/setEmail")
    public String setUserEmail(HttpServletRequest request,@RequestParam(value="email") String email)
    {
        return userService.setUserEmail(email,request);
    }

    @GetMapping("/get")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
