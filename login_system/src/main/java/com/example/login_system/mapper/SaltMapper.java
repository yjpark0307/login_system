package com.example.login_system.mapper;
import com.example.login_system.entity.Salt;
import com.example.login_system.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;
@Mapper
public interface SaltMapper {
    @Select("SELECT * FROM salt")
    List<User> getAllSalts();
}
