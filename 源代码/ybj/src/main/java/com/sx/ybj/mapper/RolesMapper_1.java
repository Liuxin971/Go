package com.sx.ybj.mapper;

import com.sx.ybj.pojo.Roles;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by sang on 2017/12/17.
 */
@Mapper
public interface RolesMapper_1 {
    int addRoles(@Param("roles") String[] roles, @Param("uid") Long uid);

    List<Roles> getRolesByUid(int uid);
}
