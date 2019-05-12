package com.example.dao.springMongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
//import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 账单信息聚合 实体类
 * </P>
 *
 * @author chenxingxing
 * @since 2018/9/6
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class BillList {

    /**
     * mongo主键[String.format("%s%s", mobile, billDate)]
     */
  //  @Id
    private String id;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 账单日期
     */
    private String billDate;
    /**
     * 该账单月下所有的账单信息
     */
    private List<BillEntity> data = new ArrayList();


}
