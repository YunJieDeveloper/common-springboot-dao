package com.example.dao.springMongodb.mongo;

/**
 * <p>
 * MongoDB基类 数据访问层
 * </P>
 *
 */
public abstract class BaseMongo<T> {

   // @Autowired
   // private MongoTemplate mongoTemplate;

    /**
     * 获取集合
     *
     * @param collectionKey 用于分表的key,可以为空
     * @return String
     */
    protected abstract String getCollectionName(String collectionKey);

//    public void save(String collectionKey, T entity) {
//        mongoTemplate.save(entity, getCollectionName(collectionKey));
//    }
//
//    public void batchSave(String collectionKey, List<T> entities) {
//        mongoTemplate.insert(entities, getCollectionName(collectionKey));
//    }
//
//    public T get(String collectionKey, Class<T> entityClass, Criteria criteria) {
//        Query query = new Query(criteria);
//        return mongoTemplate.findOne(query, entityClass, getCollectionName(collectionKey));
//    }
//
//    public List<T> getList(String collectionKey, Class<T> entityClass, Criteria criteria) {
//        Query query = new Query(criteria);
//        return mongoTemplate.find(query, entityClass, getCollectionName(collectionKey));
//    }
//
//
//    public void batchRemove(String collectionKey, Class<T> entityClass, Criteria criteria) {
//        Query query = new Query(criteria);
//        mongoTemplate.remove(query, entityClass, getCollectionName(collectionKey));
//    }

}
