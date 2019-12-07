package com.sx.ybj.service.user.Impl;

import com.sx.ybj.mapper.UserMapper;
import com.sx.ybj.pojo.User;
import com.sx.ybj.pojo.UserExample;
import com.sx.ybj.service.user.UserInfoService;
import com.sx.ybj.utils.YbjResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: ybj
 * @description: 用户信息
 * @author: lwx
 * @create: 2019-06-04 14:54
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    StringRedisTemplate stringRedisTemplate;


    @Override
    public YbjResult checkInfo(String value, String type) throws  Exception {
        // TODO Auto-generated method stub
        boolean result = false;
        //type为类型，可选参数1、2、3分别代表username、phone、email
        if ("1".equals(type)) {
           result= checkUserName(value);
        } else if ("2".equals(type)) {
            result = checkEmil(value);
        }
        //返回结果
        if (result) {
            return YbjResult.build(1,"不存在该数值",result);
        }
        return  YbjResult.build(0, "此数值已经存在",result);
    }
//ture 为不存在
    private boolean checkUserName(String username) throws Exception {
        //创建查询条件
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User> list = userMapper.selectByExample(example);
        //判断结果中是否存在
        if (list == null || list.isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean checkEmil(String eamil) throws Exception {
        //创建查询条件
       UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserEmailEqualTo(eamil);
        List<User> list = userMapper.selectByExample(example);
        //判断结果中是否存在
        if (list == null || list.isEmpty()) {
            return true;
        }
        return false;
    }







}