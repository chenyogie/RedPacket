package com.yogie.service;

import com.yogie.domain.UserRedPacket;

/**
 * @Description: 抢到红包的用户
 * @Author: Chenyogie
 * @Date: 2020/4/6 18:48
 */
public interface UserRedPacketService {

    /**
     * 用户抢红包
     * @param redPacketId 红包的id
     * @param userId 用户id
     * @return 0-没有库存，失败；1-成功，且不是最后一个红包
     */
    Long grabRedPacket(Long redPacketId, Long userId);

    /**
     * 保存抢到红包的用户及信息
     * @param userRedPacket
     */
    void saveUserRedPacket(UserRedPacket userRedPacket);
}
