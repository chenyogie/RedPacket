package com.yogie.domain;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @Description: 实体类
 * @Author: Chenyogie
 * @Date: 2020/3/30 23:15
 */
@Data
public class RedPacket {
    private Long id;//红包编号
    private Long userId;//发红包的用户
    private Double amount;//发红包的金额
    private Timestamp sendDate;//发红包的时间
    private Integer total;//小红包的总数
    private Double unitAmount;//单个小红包的金额
    private Integer stock;//剩余小红包的个数
    private Integer version;//版本
    private String note;//备注
}
