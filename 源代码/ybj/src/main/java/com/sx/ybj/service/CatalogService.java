package com.sx.ybj.service;

import com.sx.ybj.mapper.UserMapper;
import com.sx.ybj.mapper.UserMapper_1;
import com.sx.ybj.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: ybj
 * @description: Catalog
 * @author: lwx
 * @create: 2019-05-12 17:15
 */
@RestController
public class CatalogService {
    @Autowired
    UserMapper mapper;
    @Autowired
    UserMapper_1 userMapper_1;
    @GetMapping("/get")
    public List<User> list(){
      return  mapper.selectByExample(null);
    }

    @GetMapping("/get1")
    public  User list2(){
        System.out.println(userMapper_1.loadUserByUsername("sang").toString());
        return  userMapper_1.loadUserByUsername("sang");
    }


}