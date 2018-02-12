package com.example.dao.springMongodb.dao;


import com.example.dao.springMongodb.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/***
 * @Date 2018/2/8
 * @Description 第一种方式：继承MongoRepository，直接使用springboot模版
 * @author zhanghesheng
 * */
public interface MongoSpringRepository extends MongoRepository<User,String> {

}
