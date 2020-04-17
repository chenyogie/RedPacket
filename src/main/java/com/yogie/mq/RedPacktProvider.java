package com.yogie.mq;

import com.yogie.constant.RabbitMqConst;
import com.yogie.domain.UserRedPacket;
import com.yogie.util.JsonUtil;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Description: 消息推送
 * @Author: Chenyogie
 * @Date: 2020/4/6 17:36
 */
@Component
public class RedPacktProvider implements Serializable {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //交换机配置
    /**
     * 交换机配置
     * ExchangeBuilder提供了fanout、direct、topic、header交换机类型的配置
     *
     * @return the exchange
     */
    @Bean(RabbitMqConst.EXCHANGE_DIRECT)
    public Exchange exchange_direct_inform() {
        //durable(true)持久化，消息队列重启后交换机仍然存在
        return ExchangeBuilder.directExchange(RabbitMqConst.EXCHANGE_DIRECT).durable(true).build();
    }

    //声明队列
    @Bean(RabbitMqConst.QUEUE_REDPACKET) //交给spring管理的bean的名字可以随便的
    public Queue pageStaticQueue() {
        Queue queue = new Queue(RabbitMqConst.QUEUE_REDPACKET); //队列名
        return queue;
    }

    //Qualifier//获取特定名称bean
    @Bean
    public Binding BINDING_QUEUE_INFORM_HRMJOBSITE(@Qualifier(RabbitMqConst.QUEUE_REDPACKET) Queue queue,
                                                   @Qualifier(RabbitMqConst.EXCHANGE_DIRECT) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(RabbitMqConst.ROUTINGKEY).noargs();
    }


    //生产者发送消息
    public void sendMsg(UserRedPacket userRedPacket){
        String messageId = String.valueOf(UUID.randomUUID());
        String json = JsonUtil.toJson(userRedPacket);
        Map<String,Object> map = new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageDate",json);
        System.out.println("发送消息："+map.toString());
        rabbitTemplate.convertAndSend(RabbitMqConst.EXCHANGE_DIRECT,RabbitMqConst.ROUTINGKEY,map);
    }

}
