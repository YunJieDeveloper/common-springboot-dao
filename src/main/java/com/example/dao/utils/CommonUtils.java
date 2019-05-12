package com.example.dao.utils;


import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 公用工具类
 * </P>
 *
 * @author chenxingxing
 * @since 2018/9/6
 */
public class CommonUtils {

    public static final String DATE_YYYYMM = "yyyyMM";

    private CommonUtils() {
        throw new AssertionError();
    }


    /**
     * 根据查询开始时间和查询结束时间生成账单月列表
     *
     * @param from 查询开始时间
     * @param to   查询结束时间
     * @return 账单月列表
     */
    public static Set<String> getBillMonths(Date from, Date to) {
        Set<String> billMonths = new HashSet<>();
        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();

        min.setTime(from);
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

        max.setTime(to);
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

        Calendar curr = min;
        while (curr.before(max)) {
            billMonths.add(DateFormatUtils.format(curr.getTime(), DATE_YYYYMM));
            curr.add(Calendar.MONTH, 1);
        }
        return billMonths;
    }
}