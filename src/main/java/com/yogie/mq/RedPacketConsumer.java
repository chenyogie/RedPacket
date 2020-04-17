package com.yogie.mq;

import com.yogie.constant.RabbitMqConst;
import com.yogie.domain.UserRedPacket;
import com.yogie.service.UserRedPacketService;
import com.yogie.util.JsonUtil;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description: 消息消费
 * @Author: Chenyogie
 * @Date: 2020/4/6 18:07
 */
@Component
@RabbitListener(queues = RabbitMqConst.QUEUE_REDPACKET)//监听的队列名称 DirectQueue
public class RedPacketConsumer {

    @Autowired
    private UserRedPacketService userRedPacketService;

    //消费者接收消息
    @RabbitHandler
    public void receiveMsg(Map map){
        System.out.println("接收到消息："+map.toString());
        String messageId = (String) map.get("messageId");
        UserRedPacket userRedPacket = JsonUtil.toClass((String) map.get("messageDate"), UserRedPacket.class);
        userRedPacketService.saveUserRedPacket(userRedPacket);
    }
}
