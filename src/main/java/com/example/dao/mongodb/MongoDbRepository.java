package com.example.dao.mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/***
 * @Date 2018/2/8
 * @Description 最基本的mongodb CRUD操作
 * @author zhanghesheng
 * */
@Repository
public class MongoDbRepository {

    private static Logger logger = LoggerFactory.getLogger(MongoDbRepository.class);

    /**
     * @param tableName 集合名／表名
     * @return
     * @author zhanghesheng
     * @date 2018/2/8
     * @Description 获取集合
     * 这里的集合相当于传统数据库的表
     */
    public MongoCollection<Document> getCollection(String tableName) {
        MongoCollection<Document> collection = null;
        try {
            // 获取mongodb连接
            MongoDatabase mongoDatabase = MongoDBJDBC.newInstance().connectNoneAuth("localhost", "myloc");
            collection = mongoDatabase.getCollection(tableName);
            logger.info("集合 test 选择成功");
        } catch (Exception e) {
            logger.error(e.getClass().getName() + ": " + e.getMessage());
        }
        return collection;
    }

    /**
     * @param tableName 集合名／表名
     * @param condition 查询条件
     * @return
     * @author zhanghesheng
     * @date 2018/2/8
     * @Description 从集合中获取符合条件的文档
     */
    public List<Document> searchFromDb(String tableName, String condition) {
        List<Document> resultList = new ArrayList<>() ;
        try {
            MongoCollection<Document> collection = getCollection(tableName);

            //检索所有文档
            /**
             * 1. 获取迭代器FindIterable<Document>
             * 2. 获取游标MongoCursor<Document>
             * 3. 通过游标遍历检索出的文档集合
             * */
            FindIterable<Document> findIterable;
            if (StringUtils.isNotBlank(condition)) {
                BasicDBObject searchCond = new BasicDBObject();
                //根据条件类型
                searchCond.put("",condition);
                findIterable=collection.find(searchCond);
            } else {
                findIterable = collection.find();
            }

            MongoCursor<Document> mongoCursor = findIterable.iterator();
            while (mongoCursor.hasNext()) {
                resultList.add(mongoCursor.next());
            }
        } catch (Exception e) {
            logger.error(e.getClass().getName() + ": " + e.getMessage());

        }
        return resultList;
    }
}
