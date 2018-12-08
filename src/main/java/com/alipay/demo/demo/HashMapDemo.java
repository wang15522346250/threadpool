package com.alipay.demo.demo;


public  abstract  class HashMapDemo {
    /**
     * map put方法
     *
     * threshold  阀值
     * 判断当前桶是否为空，空的就需要初始化（resize 中会判断是否进行初始化）。
     * 根据当前 key 的 hashcode 定位到具体的阀值中并判断是否为空，为空表明没有 Hash 冲突就直接在当前位置创建一个新桶即可。
     * 如果当前桶有值（ Hash 冲突），那么就要比较当前桶中的 key、key 的 hashcode 与写入的 key 是否相等，
     * 相等就赋值给 e,在第 8 步的时候会统一进行赋值及返回。
     * 如果当前桶为红黑树，那就要按照红黑树的方式写入数据。
     * 如果是个链表，就需要将当前的 key、value 封装成一个新节点写入到当前桶的后面（形成链表）。
     * 接着判断当前链表的大小是否大于预设的阈值，大于时就要转换为红黑树。
     * 如果在遍历过程中找到 key 相同时直接退出遍历。
     * 如果 e != null 就相当于存在相同的 key,那就需要将值覆盖。
     * 最后判断是否需要进行扩容
     */
    public static  void add(){

    }
    /**
     *  map get方法
     *
     *  首先将 key hash 之后取得所定位的桶。
     * 如果桶为空则直接返回 null 。
     * 否则判断桶的第一个位置(有可能是链表、红黑树)的 key 是否为查询的 key，是就直接返回 value。
     * 如果第一个不匹配，则判断它的下一个是红黑树还是链表。
     * 红黑树就按照树的查找方式返回值。
     * 不然就按照链表的方式遍历匹配返回值
     *
     * 但是 HashMap 原有的问题也都存在，比如在并发场景下使用时容易出现死循环。
     *
     * for (int i = 0; i < 1000; i++) {
     *     new Thread(new Runnable() {
     *         @Override
     *         public void run() {
     *             map.put(UUID.randomUUID().toString(), "");
     *         }
     *     }).start();
     * }
     * HashMap 扩容的时候会调用 resize() 方法，就是这里的并发操作容易在一个桶上形成环形链表；
     * 这样当获取一个不存在的 key 时，计算出的 index 正好是环形链表的下标就会出现死循环。
     */

}
