package com.sx.ybj.mapper;

import com.sx.ybj.pojo.Roles_user;
import com.sx.ybj.pojo.Roles_userExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface Roles_userMapper {
    int countByExample(Roles_userExample example);

    int deleteByExample(Roles_userExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Roles_user record);

    int insertSelective(Roles_user record);

    List<Roles_user> selectByExample(Roles_userExample example);

    Roles_user selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Roles_user record, @Param("example") Roles_userExample example);

    int updateByExample(@Param("record") Roles_user record, @Param("example") Roles_userExample example);

    int updateByPrimaryKeySelective(Roles_user record);

    int updateByPrimaryKey(Roles_user record);
}