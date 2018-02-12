package com.example.dao.test;

import com.example.dao.mongodb.MongoDBJDBC;
import com.example.dao.mongodb.MongoDbRepository;
import com.example.dao.springMongodb.dao.MongoSpringRepository;
import com.example.dao.springMongodb.dao.MyMongoDao;
import com.example.dao.springMongodb.model.User;
import com.mongodb.client.MongoDatabase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//1.5.x版本
@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleTest {

    private MongoDBJDBC mongoDBJDBC;

    @Autowired
    MongoDbRepository mongoDbRepository;

    @Autowired
    MongoSpringRepository mongoSpringRepository;

    @Autowired
    MyMongoDao myMongoDao;

    @Before
    public void before() {
        mongoDBJDBC = MongoDBJDBC.newInstance();
    }

    @Test
    public void testConnect() {
        mongoDBJDBC.connectNoneAuth("127.0.0.1", "mycol");
    }

    @Test
    public void testGetCollect() {
        mongoDbRepository.getCollection("");
    }
    @Test
    public void testSpringRepository() {
        User user = mongoSpringRepository.save(new User("1", "zhangsan", "zs"));
        System.out.println(user.getId()+"\t"+user.getName()+"\t"+user.getNotes());
        User one = mongoSpringRepository.findOne("1");
        System.out.println(one.getId()+"\t"+one.getName()+"\t"+one.getNotes());

    }

    @Test
    public void testDao() {
       myMongoDao.save(new User("1", "zhangsan", "zs"));
        User one = myMongoDao.getUserByName("zhangsan");
        System.out.println(one.getId()+"\t"+one.getName()+"\t"+one.getNotes());

    }

}
