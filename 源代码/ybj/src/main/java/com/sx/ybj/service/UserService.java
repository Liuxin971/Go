package com.sx.ybj.service;



import com.sx.ybj.mapper.RolesMapper_1;


import com.sx.ybj.mapper.UserMapper;

import com.sx.ybj.pojo.Roles;
import com.sx.ybj.pojo.User;

import com.sx.ybj.pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


/**
*@Description: 验证用户名
*@Param: 
*@return: 
*@Author: your name
*@date: 2019/6/12
*/
@Service
@Transactional
public class UserService implements UserDetailsService {
    @Autowired
    RolesMapper_1 rolesMapper;
   @Autowired
    UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User> users=userMapper.selectByExample(userExample);
        User user=users.get(0);
        if (user == null) {
            //避免返回null，这里返回一个不含有任何值的User对象，在后期的密码比对过程中一样会验证失败
            return new User();
        }
        //查询用户的角色信息，并返回存入user中
        System.out.println(user.getUserId());
        List<Roles> roles = rolesMapper.getRolesByUid(user.getUserId());
        System.out.println(user.toString());
        user.setRoles(roles);
        return user;
    }








}
