package com.yogie.constant;

/**
 * @Description: redis相关的常量
 * @Author: Chenyogie
 * @Date: 2020/4/6 18:27
 */
public class RedisConst {

    /**
     * 用户抢红包的lua脚本:
     * （1）声明本地变量redPacket,redPacket的值就是red_packet_这里拼接红包id；
     * （2）去redis中查询库存，并存放到stock变量中；
     * （3）如果库存小于等于0，就返回0；
     * （4）否则，库存减1；
     * （5）将修改后的库存重新保存到redis中，并返回1
     */
    public static final String luaScript = "local redPacket = 'red_packet_'..KEYS[1] \n" +
            "local stock = tonumber(redis.call('hget',redPacket,'stock')) \n" +
            "if stock <= 0 then return 0 end \n" +
            "stock = stock - 1 \n" +
            "redis.call('hset',redPacket,'stock',tostring(stock)) \n" +
            "return 1 \n";
}
