package com.yogie.service.impl;

import com.yogie.mapper.RedPacketMapper;
import com.yogie.service.RedPacketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Description: service
 * @Author: Chenyogie
 * @Date: 2020/3/30 23:32
 */
@Service
public class RedPacketServiceImpl implements RedPacketService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedPacketServiceImpl.class);

    @Autowired
    private RedPacketMapper redPacketMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 保存抢到红包的用户及信息：通过mq异步保存，每次最多保存1000条
     *
     * @param userId      抢到红包的用户
     * @param redPacketId 用户抢到的是哪个红包
     * @param unitAmount  抢到的红包的金额
     */
    //@Override
    //public void saveUserRedPacket(Long userId, Long redPacketId, Double unitAmount) {
        //LOGGER.info("发送异步消息到MQ，保存抢到红包的用户！");
        ////列表的key为：RED:PACKET:LIST:+红包的id
        //BoundListOperations ops = redisTemplate.boundListOps(String.format(RedisConst.LIST_PREFIX, redPacketId));
        ////列表的总数据量
        //Long size = ops.size();
        ////需要保存多少次
        //Long times = size % RedisConst.SAVE_SIZE == 0 ? size % RedisConst.SAVE_SIZE : size % RedisConst.SAVE_SIZE + 1;
        //int count = 0;
        ////构造一个容量为1000的List
        //List<UserRedPacket> userRedPacketList = new ArrayList<>(RedisConst.SAVE_SIZE);
        ////分times次保存
        //for (int i = 0; i < times; i++) {
        //    List userIdList = null;
        //    if(i==0)
        //        userIdList = ops.range(i*RedisConst.SAVE_SIZE,(i+1)*RedisConst.SAVE_SIZE);
        //    else
        //        userIdList = ops.range(i*RedisConst.SAVE_SIZE+1,(i+1)*RedisConst.SAVE_SIZE);
        //    userRedPacketList.clear();//清理列表
        //    //保存红包信息
        //    for (int j = 0; j < userIdList.size(); j++) {
        //        String args = userIdList.get(j).toString();
        //    }
        //}

    //}
}
