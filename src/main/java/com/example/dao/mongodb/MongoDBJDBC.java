package com.example.dao.mongodb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 * @Date 2018/2/8
 * @Description 最基本的mongodb连接
 * @author zhanghesheng
 * */
public class MongoDBJDBC {

    private static Logger logger = LoggerFactory.getLogger(MongoDBJDBC.class);

    private static class Inner {
        private static MongoDBJDBC instance = new MongoDBJDBC();
    }

    public static final MongoDBJDBC newInstance() {
        return Inner.instance;
    }


//    /**
//     * @author zhanghesheng
//     * @Description 需要用户名密码验证
//     */
//    public MongoDatabase connectNeedAuth(String host, String dataBaseName, String user, String passWord) {
//        MongoDatabase mongoDatabase = null;
//        try {
//            //连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址
//            //ServerAddress()两个参数分别为 服务器地址 和 端口
//            ServerAddress serverAddress = new ServerAddress(host, 27017);
//            List<ServerAddress> addrs = new ArrayList<>();
//            addrs.add(serverAddress);
//
//            //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
//            MongoCredential credential = MongoCredential.createScramSha1Credential(user, dataBaseName, passWord.toCharArray());
//            List<MongoCredential> credentials = new ArrayList<>();
//            credentials.add(credential);
//
//            //通过连接认证获取MongoDB连接
//            MongoClient mongoClient = new MongoClient(addrs, credentials);
//
//            //连接到数据库
//            mongoDatabase = mongoClient.getDatabase(dataBaseName);
//            logger.info("Connect to database successfully");
//        } catch (Exception e) {
//            logger.error(e.getClass().getName() + ": " + e.getMessage());
//        }
//        return mongoDatabase;
//    }
//
//    /**
//     * @param host         mongodb所在主机地址
//     * @param dataBaseName 数据库名
//     * @author zhanghesheng
//     * @Description 无密码
//     */
//    public MongoDatabase connectNoneAuth(String host, String dataBaseName) {
//        MongoDatabase mongoDatabase = null;
//        try {
//            // 连接到 mongodb 服务
//            MongoClient mongoClient = new MongoClient(host, 27017);
//
//            // 连接到数据库,需要指定数据库名称，如果指定的数据库不存在，mongo会自动创建数据库
//            mongoDatabase = mongoClient.getDatabase(dataBaseName);
//            logger.info("Connect to database successfully");
//
//        } catch (Exception e) {
//            logger.error(e.getClass().getName() + ": " + e.getMessage());
//        }
//        return mongoDatabase;
//    }
}
