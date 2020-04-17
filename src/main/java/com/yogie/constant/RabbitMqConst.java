package com.yogie.constant;

/**
 * @Description: 消息队列的常量
 * @Author: Chenyogie
 * @Date: 2020/4/6 23:24
 */
public class RabbitMqConst {
    //direct类型的交换机
    public static final String EXCHANGE_DIRECT = "exchange_direct";
    //队列：这个队列用于做抢红包的业务
    public static final String QUEUE_REDPACKET = "queue_redpacket";
    //routingKey
    public static final String ROUTINGKEY = "routing_redpacket";
}
