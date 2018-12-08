package com.alipay.demo.demo;

public class ConcurrentHashMapDemo {
    /**
     *  JDK 1.7
     *  是由 Segment 数组、HashEntry 组成，和 HashMap 一样，仍然是数组加链表。
     *  和 HashMap 非常类似，唯一的区别就是其中的核心数据如 value ，
     *  以及链表都是 volatile 修饰的，保证了获取时的可见性。
     *  ：ConcurrentHashMap 采用了分段锁技术，其中 Segment 继承于 ReentrantLock。
     *  不会像 HashTable 那样不管是 put 还是 get 操作都需要做同步处理，
     *  理论上 ConcurrentHashMap 支持 CurrencyLevel (Segment 数组数量)的线程并发。
     *  每当一个线程占用锁访问一个 Segment 时，不会影响到其他的 Segment。
     *
     *  put
     *  虽然 HashEntry 中的 value 是用 volatile 关键词修饰的，但是并不能保证并发的原子性，
     *  所以 put 操作时仍然需要加锁处理。
     *
     * 首先第一步的时候会尝试获取锁，如果获取失败肯定就有其他线程存在竞争，
     * 则利用 scanAndLockForPut() 自旋获取锁。
     * 将当前 Segment 中的 table 通过 key 的 hashcode 定位到 HashEntry。
     * 遍历该 HashEntry，如果不为空则判断传入的 key 和当前遍历的 key 是否相等，相等则覆盖旧的 value。
     * 不为空则需要新建一个 HashEntry 并加入到 Segment 中，同时会先判断是否需要扩容。
     * 最后会解除在 1 中所获取当前 Segment 的锁。
     *
     *  get
     *  只需要将 Key 通过 Hash 之后定位到具体的 Segment ，再通过一次 Hash 定位到具体的元素上。
     * 由于 HashEntry 中的 value 属性是用 volatile 关键词修饰的，保证了内存可见性，所以每次获取时都是最新值。
     * ConcurrentHashMap 的 get 方法是非常高效的，因为整个过程都不需要加锁。
     */



    /**
     *  JDK1.8
     * 抛弃了原有的 Segment 分段锁，而采用了 CAS + synchronized 来保证并发安全性。
     *  put
     * 根据 key 计算出 hashcode 。
     * 判断是否需要进行初始化。
     * f 即为当前 key 定位出的 Node，如果为空表示当前位置可以写入数据，利用 CAS 尝试写入，失败则自旋保证成功。
     * 如果当前位置的 hashcode == MOVED == -1,则需要进行扩容。
     * 如果都不满足，则利用 synchronized 锁写入数据。
     * 如果数量大于 TREEIFY_THRESHOLD 则要转换为红黑树。
     */

    /**
     *  get
     *  根据计算出来的 hashcode 寻址，如果就在桶上那么直接返回值。
     * 如果是红黑树那就按照树的方式获取值。
     * 就不满足那就按照链表的方式遍历获取值。
     */
}
