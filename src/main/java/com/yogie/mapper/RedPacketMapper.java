package com.yogie.mapper;

import com.yogie.domain.RedPacket;
import org.springframework.stereotype.Repository;

/**
 * @Description: dao
 * @Author: Chenyogie
 * @Date: 2020/3/30 23:24
 */
@Repository
public interface RedPacketMapper {

    /**
     * 查询红包具体信息
     * @param id
     * @return
     */
    RedPacket queryById(Integer id);
}
