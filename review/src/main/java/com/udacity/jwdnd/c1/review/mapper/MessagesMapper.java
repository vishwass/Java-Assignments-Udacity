package com.udacity.jwdnd.c1.review.mapper;

import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessagesMapper {

    @Select("select * from MESSAGES where messageid = #{messageid} ")
    public ChatMessage findById(Integer messageid);

    @Insert("insert into MESSAGES(username,messagetext) VALUES(#{username},#{messagetext})")
    @Options(useGeneratedKeys = true, keyProperty = "messageid")
    public Integer createChatMessage(ChatMessage  chatMessage);

    @Select("select * from MESSAGES")
    public List<ChatMessage> getAllMessages();

}
