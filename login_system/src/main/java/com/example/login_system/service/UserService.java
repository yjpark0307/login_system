package com.example.login_system.service;

import java.security.SecureRandom;
import com.example.login_system.entity.*;
import com.example.login_system.mapper.*;
import org.springframework.stereotype.Service;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import com.example.login_system.util.*;

@Service
public class UserService {
    private final UserMapper userMapper;
    private final SaltMapper saltMapper;

    public UserService(UserMapper userMapper,SaltMapper saltMapper) {
        this.userMapper = userMapper;
        this.saltMapper = saltMapper;
    }

    public String addUser(String id, String password,String email) {
        if(userMapper.getUserById(id).isEmpty()==false)
        {
            return "duplicated id";
        }
        Hash hash = new Hash();
        SaltGenerator g = new SaltGenerator();
        String salt = hash.getSHA256Hash(g.generateSalt());
        String hashPassword = hash.getSHA256Hash(password+salt);
        userMapper.addUser(id,hashPassword,email);
        saltMapper.addSalt(id,salt);
        return "success";
    }

    public String login(String id, String password,HttpServletRequest request) {
        Hash hash = new Hash();
        String salt = saltMapper.getSaltById(id).get(0).getSalt();
        String hashPassword = hash.getSHA256Hash(password+salt);
        List<User> user = userMapper.getUserById(id);
        if(user.isEmpty())
        {
            return "invalid id";
        }
        if(user.get(0).getPassword().equals(hashPassword)==false)
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

    public String setUserEmail(String email,String hashedEmail,HttpServletRequest request) {
        String value = (String) request.getSession().getAttribute("myValue");
        if(value==null)
        {
            return "invalid session";
        }
        Hash hash = new Hash();
        String compHashedEmail = hash.getSHA256Hash(email);
        if(compHashedEmail==hashedEmail)
        {
            userMapper.setEmailById(value,email);
            return "success";
        }
        return "message auth fail";
    }


    public List<User> getAllUsers() {
        List<User> user= userMapper.getAllUsers();
        return user;
    }



}
