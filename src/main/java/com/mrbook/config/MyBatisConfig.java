package com.mrbook.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.mrbook.mapper")
public class MyBatisConfig {
}
