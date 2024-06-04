package com.example.login_system.mapper;
import com.example.login_system.entity.Salt;
import com.example.login_system.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;
@Mapper
public interface SaltMapper {
    List<Salt> getSaltById(String ID);
    void addSalt(String ID,String Salt);
}
