package com.example.dao.springMongodb.config;

import com.example.dao.jasypt.CustomResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: common-springboot-dao
 * @description:
 * @author: Hession
 * @create: 2019-05-12 15:02
 **/
@Configuration
public class MongoConfig {


    /**
     * @author hession
     * @description //注入自定义的jasypt解密类
     *
     * 若不注入此自定义类，默认执行DefaultPropertyResolver.
     * <p>
     * 必须定义bean名称为"encryptablePropertyResolver",
     * 否则jasypt框架找不到自定义的Resolver
     * </p>
     */
    @Bean("encryptablePropertyResolver")
    public CustomResolver customResolver() {
        return new CustomResolver();
    }
}
