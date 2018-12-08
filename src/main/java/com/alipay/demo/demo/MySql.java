package com.alipay.demo.demo;

public class MySql {
    /**
     *
     *
     * 对比项	MyISAM	InnoDB
     * 外键	    不支持	支持
     * 事务	    不支持	支持
     *	MyISAM表锁，即使操作一条记录也会锁住整个表，不适合高并发的操作
     *	InnoDB 行锁,操作时只锁某一行，不对其它行有影响，适合高并发的操作
     *
     * MyISAM缓存	只缓存索引，不缓存真实数据
     * InnoDB不仅缓存索引还要缓存真实数据，对内存要求较高，而且内存大小对性能有决定性的影响
     * MyISAM关注点	节省资源、消耗少、简单业务
     * InnoDB并发写、事务、更大资源
     * 默认安装	 Y	Y
     * 默认使用	MyISAM N 	InnoDB Y
     * 自带系统表使用	Y	N
     *
     *
     * 索引优化 最佳左匹配法则
     * 不在索引列上做任何操作（计算、函数、(自动or手动)类型转换），会导致索引失效而转向全表扫描
     * 存储引擎不能使用索引中范围条件右边的列
     * mysql 在使用不等于(!= 或者<>)的时候无法使用索引会导致全表扫描
     * is not null 也无法使用索引,但是is null是可以使用索引的
     * like以通配符开头('%abc...')mysql索引失效会变成全表扫描的操作
     * 字符串不加单引号索引失效
     *
     */
}
