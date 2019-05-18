package com.example.dao.springMongodb.mongo;

import com.example.dao.springMongodb.entity.BillList;
import com.example.dao.utils.CommonUtils;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * </P>
 *
 * @author chenxingxing
 * @since 2018/9/6
 */
//@Repository
public class BillMongo extends BaseMongo<BillList> {

    private static final String COLLECTION_NAME_PREFIX = "t_bill_";

    public void addBill(String mobile, BillList billList) {
        if (Objects.nonNull(billList)) {
            Criteria criteria = new Criteria("id").is(billList.getId());
            batchRemove(mobile, BillList.class, criteria);

            save(mobile, billList);
        }
    }

    public void addBills(String mobile, List<BillList> billLists) {
        if (!CollectionUtils.isEmpty(billLists)) {
            Set<String> ids = billLists.stream().map(billList -> String.format("%s%s", billList.getMobile(), billList.getBillDate())).collect(Collectors.toSet());
            Criteria criteria = new Criteria("id").in(ids);
            batchRemove(mobile, BillList.class, criteria);

            batchSave(mobile, billLists);
        }
    }

    public List<BillList> getBills(String mobile, Date from, Date to) {
        Set<String> billMonths = CommonUtils.getBillMonths(from, to);
        Set<String> ids = billMonths.stream().map(s -> String.format("%s%s", mobile, s)).collect(Collectors.toSet());

        Criteria criteria = new Criteria("id").in(ids);
        return getList(mobile, BillList.class, criteria);
    }

    @Override
    protected String getCollectionName(String mobile) {
        return COLLECTION_NAME_PREFIX + mobile.substring(mobile.length() - 1);
    }
}
