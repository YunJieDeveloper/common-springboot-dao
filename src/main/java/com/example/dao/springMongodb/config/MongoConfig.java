package com.example.dao.springMongodb.config;


import com.mongodb.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * @Date 2018/2/8
 * @Description  todo 该类未用到，直接使用了springboot自带的模版
 * @author zhanghesheng
 * */
public class MongoConfig extends AbstractMongoConfiguration {
    private  Logger logger = LoggerFactory.getLogger(MongoConfig.class);

    @Value("${mongodb.host}")
    private String mongodbHost;

    @Value("${mongodb.port}")
    private int mongodbPort;

    @Value("${mongodb.name}")
    private String mongodbName;

    @Value("${mongodb.user}")
    private String mongodbUser;

    @Value("${mongodb.password}")
    private String mongodbpwd;

    @Value("${mongodb.authentification}")
    private boolean authentification;

    @Override
    protected String getDatabaseName() {
        return mongodbName;
    }

    @Override
    public Mongo mongo() throws Exception {

        MongoClient mongoClient;
        MongoClientOptions options = MongoClientOptions.builder()
                .connectionsPerHost(3000)
                .threadsAllowedToBlockForConnectionMultiplier(10)
                .readPreference(ReadPreference.nearest())
                .build();
        List<ServerAddress> addresses = new ArrayList<ServerAddress>();
        String[] str = this.mongodbHost.split(",");
        for (String strHost : str) {
            ServerAddress address = new ServerAddress(strHost, mongodbPort);
            addresses.add(address);
        }
        if(authentification){
            MongoCredential credential = MongoCredential.createMongoCRCredential(mongodbUser,mongodbName,mongodbpwd.toCharArray());
            mongoClient = new MongoClient(addresses, Arrays.asList(credential), options);
        }else{
            mongoClient = new MongoClient(addresses, options);
        }

        return mongoClient;
    }
}
