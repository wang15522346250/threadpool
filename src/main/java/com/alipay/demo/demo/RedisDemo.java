package com.alipay.demo.demo;

public class RedisDemo {

    /**
     * Redis是单线程+多路IO复用技术
     * Redis五种基本数据类型
     * string(字符串)、
     * list(链表)、单键多值
     * set(集合)、
     * zset(sorted set --有序集合)
     * hash（哈希类型）。hash 是一个键值对集合
     */

    /**
     * expire   <key>   <seconds> • 为键值设置过期时间，单位秒
     * ttl   <key> 查看还有多少秒过期
     *
     * RDB在指定的时间间隔内将内存中的数据集快照写入磁盘，
     * 也 就是行话讲的Snapshot快照，它恢复时是将快照文件直接 读到内存里
     * 那RDB方式要比AOF方式更加的高效。 RDB的缺点是最后一次持久化后的数据可能丢失。
     *
     * rdb的优点
     * • 节省磁盘空间 • 恢复速度快
     *
     * AOF以日志的形式来记录每个写操作
     */
}
