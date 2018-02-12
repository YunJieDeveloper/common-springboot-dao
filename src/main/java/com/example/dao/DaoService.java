package com.example.dao;

import com.example.dao.springMongodb.dao.MongoSpringRepository;
import com.example.dao.springMongodb.dao.MyMongoDao;
import com.example.dao.springMongodb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class DaoService {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(new Object[]{DaoService.class});
        ApplicationContext context = SpringApplication.run(DaoService.class, args);
        MongoSpringRepository mongoSpringRepository = (MongoSpringRepository)context.getBean("mongoSpringRepository");
        User user = mongoSpringRepository.save(new User("1", "zhangsan", "zs"));
        System.out.println(user.getId()+"\t"+user.getName()+"\t"+user.getNotes());
        User one = mongoSpringRepository.findOne("1");
        System.out.println(one.getId()+"\t"+one.getName()+"\t"+one.getNotes());

        MyMongoDao myMongoDao=(MyMongoDao)context.getBean("myMongoDao");
        System.out.println(myMongoDao.getUserByName("zhangsan"));
    }
}
