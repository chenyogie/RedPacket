package com.yogie.mapper;

import com.yogie.domain.UserRedPacket;
import org.springframework.stereotype.Repository;

/**
 * @Description: dao
 * @Author: Chenyogie
 * @Date: 2020/3/30 23:24
 */
@Repository
public interface UserRedPacketMapper {

    /**
     * 查询红包具体信息
     * @param userRedPacket
     */
    void save(UserRedPacket userRedPacket);
}
