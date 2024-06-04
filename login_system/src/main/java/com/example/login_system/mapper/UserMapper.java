package com.example.login_system.mapper;


import com.example.login_system.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface UserMapper {
    List<User> getAllUsers();

    void addUser(String ID, String Password, String Email);
    void setEmailById(String ID, String Email);
    List<User> getEmailById(String ID);

    List<User> getUserById(String ID);
}
