package com.yogie.service.impl;

import com.yogie.constant.RedisConst;
import com.yogie.domain.UserRedPacket;
import com.yogie.mapper.UserRedPacketMapper;
import com.yogie.mq.RedPacktProvider;
import com.yogie.service.UserRedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * @Description: @TODO
 * @Author: Chenyogie
 * @Date: 2020/4/6 18:51
 */
@Service
public class UserRedPacketServiceImpl implements UserRedPacketService {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedPacktProvider redPacktProvider;
    @Autowired
    private UserRedPacketMapper userRedPacketMapper;
    private String sha1 = null;

    /**
     * 用户抢红包
     *
     * @param redPacketId 红包的id
     * @param userId      用户id
     * @return
     */
    @Override
    public Long grabRedPacket(Long redPacketId, Long userId) {
        String args = userId + "-" + System.currentTimeMillis();
        Long result = null;
        Jedis jedis = (Jedis) redisTemplate.getConnectionFactory().getConnection().getNativeConnection();
        try {
            //如果脚本没有加载过，那么进行加载，这样就会返回一个sha1编码
            if (sha1 == null) sha1 = jedis.scriptLoad(RedisConst.luaScript);
            //执行脚本，返回结果
            result = (Long) jedis.evalsha(sha1, 1, redPacketId + "", args);
            if (result == 1) {//抢红包成功
                UserRedPacket userRedPacket = new UserRedPacket();
                userRedPacket.setUserId(userId);
                userRedPacket.setRedPacketId(redPacketId);
                //MQ异步保存数据
                redPacktProvider.sendMsg(userRedPacket);
            }
        } finally {
            if (jedis != null || jedis.isConnected()) jedis.close();
        }
        return result;
    }

    /**
     * @param userRedPacket
     */
    @Override
    public void saveUserRedPacket(UserRedPacket userRedPacket) {
        userRedPacketMapper.save(userRedPacket);
    }
}
