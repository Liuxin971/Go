package com.sx.ybj.mapper;

import com.sx.ybj.pojo.Roles;
import com.sx.ybj.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by sang on 2017/12/17.
 */
@Mapper
public interface UserMapper_1 {

    User loadUserByUsername(@Param("username") String username);
    List<Roles> getAllRole();


}
