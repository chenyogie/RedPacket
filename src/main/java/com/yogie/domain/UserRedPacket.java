package com.yogie.domain;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @Description: 实体类
 * @Author: Chenyogie
 * @Date: 2020/3/30 23:15
 */
@Data
public class UserRedPacket {
    private Long id;//编号
    private Long userId;//抢红包的用户编号
    private Long redPacketId;//红包编号
    private Double amount;//抢红包的金额
    private Timestamp grabTime;//抢红包的时间
    private String note;//备注
}
