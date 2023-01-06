package com.semi.oliveold.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.semi.oliveold", annotationClass = Mapper.class)
public class MybatisConfig {


}
