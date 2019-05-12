package com.example.dao.springMongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 账单信息 实体类
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
public class BillEntity {

    /**
     * 本机号码
     */
    private String mobile;
    /**
     * 账期起始日期
     */
    private Date billStartDate;
    /**
     * 账期结束日期
     */
    private Date billEndDate;
    /**
     * 套餐及固定费(单位分) 默认:0
     */
    private Integer baseFee = 0;
    /**
     * 增值业务费(单位分) 默认:0
     */
    private Integer vasFee = 0;
    /**
     * 语音费(单位分) 默认:0
     */
    private Integer voiceFee = 0;
    /**
     * 短彩信费(单位分) 默认:0
     */
    private Integer smsFee = 0;
    /**
     * 网络流量费(单位分) 默认:0
     */
    private Integer webFee = 0;
    /**
     * 其它费用(单位分) 默认:0
     */
    private Integer extraFee = 0;
    /**
     * 总费用(单位分) 默认:0
     */
    private Integer totalFee = 0;
    /**
     * 优惠费(单位分) 默认:0
     */
    private Integer discount = 0;
    /**
     * 其它优惠(单位分) 默认:0
     */
    private Integer extraDiscount = 0;
    /**
     * 个人实际费用(单位分) 默认:0
     */
    private Integer actualFee = 0;
    /**
     * 已支付费用(单位分) 默认:0
     */
    private Integer paidFee = 0;
    /**
     * 未付费用(单位分) 默认:0
     */
    private Integer unpaidFee = 0;
    /**
     * 当前积分
     */
    private Integer point;
    /**
     * 之前积分
     */
    private Integer lastPoint;
    /**
     * 关联手机号
     */
    private String relatedMobiles;
    /**
     * 子项目信息
     */
    private String items;
    /**
     * 创建时间
     */
    private Date createTime;


}
