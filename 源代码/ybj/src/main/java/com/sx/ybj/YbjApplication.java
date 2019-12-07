package com.sx.ybj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
//映射扫描Mapper
@MapperScan(value = "com.sx.ybj.mapper")
//增加缓存
@EnableCaching
public class YbjApplication {


 //   外部服务器启动
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(YbjApplication.class);
//    }

    public static void main(String[] args) {
        SpringApplication.run(YbjApplication.class, args);
    }

}
