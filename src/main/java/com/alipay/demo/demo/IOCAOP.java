package com.alipay.demo.demo;

public class IOCAOP {
    /**
     * AOP的好处就是你只需要干你的正事，其它事情别人帮你干。
     * 把公有的部分提取出来，横向抽取，纵向代理
     * 每个人各司其职，灵活组合，达到一种可配置的、可插拔的程序结构。
     * 从Spring的角度看，AOP最大的用途就在于提供了事务管理的能力。
     */

    /**
     * IOC控制反转   依赖注入
     *
     * 控制反转
     * 传统Java SE程序设计，我们直接在对象内部通过new进行创建对象，是程序主动去创建依赖对象；
     * 而IoC是有专门一个容器来创建这些对象，即由Ioc容器来控制对 象的创建；谁控制谁？
     * 当然是IoC 容器控制了对象；控制什么？那就是主要控制了外部资源获取（不只是对象包括比如文件等）
     * 有反转就有正转，传统应用程序是由我们自己在对象中主动控制去直接获取依赖对象，也就是正转；
     * 而反转则是由容器来帮忙创建及注入依赖对象；为何是反转？因为由容器帮我们查找及注入依赖对象，对象只是被动的接受依赖对象，所以是反转；
     * 哪些方面反转了？依赖对象的获取被反转了。
     *
     *
     * 步骤1、BeanFactory（继承的是DefaultListableBeanFactory），提供基本的IoC容器功能，可以从classpath或文件系统等获取资源；
     *
     *  步骤2、利用ClassPathResource可以从classpath中读取XML文件
     *
     *  ApplicationContext实现: ClassPathXmlApplicationContext(继承了抽象类)：，从classpath获取配置文件。
     *
     * 依赖注入
     * 构造器注入   Setter方法注入  接口注入  注解注入  静态工厂注入
     *
     * ClassPathXmlApplicationContext：从classpath的XML配置文件中读取上下文，并生成上下文定义。
     * 应用程序上下文从程序环境变量中取得。
     *
     *Spring有几种配置方式：
     * 基于XML的配置
     * 基于注解的配置
     * 基于Java的配置
     *
     * 依赖注入”明确描述了“被注入对象依赖IoC容器配置依赖对象
     * IoC 不是一种技术，只是一种思想，一个重要的面向对象编程的法则，
     * BeanFactory是提供了OC容器最基本的形式 
     * 它能指导我们如何设计出松耦合、更优良的程序
     *
     * threadpool  yes
     */
}
