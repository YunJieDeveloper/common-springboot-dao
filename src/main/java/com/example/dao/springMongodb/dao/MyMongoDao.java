package com.example.dao.springMongodb.dao;

import org.springframework.stereotype.Repository;
/***
 * @Date 2018/2/8
 * @Description  第二种方式：自定义Dao  使用模板类MongoTemplate进行操作
 * @author zhanghesheng
 * */
@Repository
public class MyMongoDao {
//    @Autowired
//    MongoTemplate mongoTemplate;
//
//    public void save(User user) {
//        mongoTemplate.save(user);
//    }
//
//    public  User getUserByName(String name){
//        Criteria criteria = Criteria.where("name").is(name);
//        Query query = new Query(criteria);
//        List<User> users = mongoTemplate.find(query, User.class);
//        if(users!=null&&users.size()>0)return users.get(0);
//        return null;
//    }
}
