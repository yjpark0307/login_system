package com.example.login_system.service;

import com.example.login_system.entity.*;
import com.example.login_system.mapper.*;
import org.springframework.stereotype.Service;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;
    private final SaltMapper saltMapper;

    public UserService(UserMapper userMapper,SaltMapper saltMapper) {
        this.userMapper = userMapper;
        this.saltMapper = saltMapper;
    }

    public String addUser(String id, String password) {
        if(userMapper.getUserById(id).isEmpty()==false)
        {
            return "duplicated id";
        }
        userMapper.addUser(id,password);
        return "success";
    }

    public String login(String id, String password,HttpServletRequest request) {
        List<User> user = userMapper.getUserById(id);
        if(user.isEmpty())
        {
            return "invalid id";
        }
        if(user.get(0).getPassword().equals(password)==false)
        {
            return "invalid password";
        }
        request.getSession().setAttribute("myValue",id);
        return "success";
    }

    public String getUserEmail(HttpServletRequest request) {
        String value = (String) request.getSession().getAttribute("myValue");
        if(value==null)
        {
            return "invalid session";
        }
        List<User> user = userMapper.getEmailById(value);
        return user.get(0).getEmail();
    }

    public String setUserEmail(String email,HttpServletRequest request) {
        String value = (String) request.getSession().getAttribute("myValue");
        if(value==null)
        {
            return "invalid session";
        }
        userMapper.setEmailById(value,email);
        return "success";
    }


    public List<User> getAllUsers() {
        List<User> user= userMapper.getAllUsers();
        return user;
    }



}
