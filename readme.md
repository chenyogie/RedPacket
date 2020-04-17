# RedPacket 基于redis的抢红包实战。
### 技术栈
SpringBoot、redis、RabbitMQ
### 技术解析
通过redis的lua脚本来控制并发环境下，红包的量不会超发。
通过RabbitMQ来异步保存抢到红包的用户。
