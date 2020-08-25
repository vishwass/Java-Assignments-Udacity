package com.udacity.jwdnd.c1.review.mapper;


import com.udacity.jwdnd.c1.review.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("select * from USERS where username = #{username}")
    User findUserByUsername(String username);

    @Insert("Insert into USERS(username, password, salt, firstname, lastname) VALUES(#{username},#{password},#{salt},#{firstname},#{lastname})")
    @Options(useGeneratedKeys = true, keyProperty = "userid")
    int createUser(User user);

    @Delete("delete * from USERS where id = #{userid} ")
    void deleteUser(Integer userid);

}
