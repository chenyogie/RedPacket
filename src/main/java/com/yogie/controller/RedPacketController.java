package com.yogie.controller;

import com.yogie.service.UserRedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 抢红包的控制器
 */
@RestController
public class RedPacketController {

    @Autowired
    private UserRedPacketService userRedPacketService;

    /**
     * 用户抢红包-红包总量减一，当前抢到红包的用户保存到redis-list，每隔6个小时同步到数据库
     * @return
     */
    @PostMapping("/grab")
    public String grabRedPacket(Long redPacketId,Long userId){
        System.out.println("请求到达！！！！！！！！！！！！");
        Long result = userRedPacketService.grabRedPacket(redPacketId, userId);
        //抢红包成功
        if(result==1){
            return "抢红包成功！";
        }else{
            return "抢红包失败！";
        }
    }
}
