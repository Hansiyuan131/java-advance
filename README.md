# 一、以终为始

> 靡不有初，鲜克有终  
> 仅记录个人学习历程，个人实力并不是很高。期待认识一群持续学习的小伙伴。

### 1、我的初心是什么？

- 构建Java知识体系、夯实基础
  - 通过构建知识体系，深入技术细节，提升自己个人技术能力，沉淀和完善学习方法论
- 建立自己的技术影响力
  - 通过编写原创技术文章，记录学习过程，提升自己写作能力
- 提高自己的硬实力+软实力

### 2、完善个人成长模型
> 每隔一段时间（3-5年），看看自己是不是在做重复的事儿，停留在之前的层次。如果是的话，赶紧改变自己，不断学习，跳出恶性循环（走向正反馈）。很多时候我们愿意帮助愿意伸手让我们拉一把的人

个人成长很重要，需要持续学习，任何人成为技术专家都逃脱不了“一万小时定律”。以money和成长为推动力，希望能做好自己，有所收获。

![](https://files.mdnice.com/user/32494/3e5fb4c5-456e-459a-ac50-68182c1fb475.png)


# 二、任务拆解
### 1、根据体系内容拆解

因为Java体系化构建是个持续和不断完善的课题，与源码阅读和日常踩坑的文章输出不同，这个课题的输出文章一般用的是业余时间，而且需要有技术宽度和技术深度，不对自己做特别强制的要求。但每月至少完成一个主题的文章和Code编写。

![](https://files.mdnice.com/user/32494/ec65deb7-f6f0-43c5-8eb7-a8c59dc6d907.png)

### 2、目标
准备通过代码实践和文章输出两种途径去记录自己的学习历程，每个技术点（主题）都会至少输出一篇文章。

关于性能调优：

- 性能问题、bug问题类比：病人
- 软件开发工程师：医生
- 我们需要监控设备、学会尽量多的优化手段
- QPS（查询）、TPS（订单）的区别是什么
- 数据的拆分：垂直拆分、水平拆分（单表存储不超过2000w）基于分库分表优化处理千万业务数据
- 使用JVM分析工具剖析JVM系统性能

关于多线程：

- 设计一个计数器
- 使用多线程实现高并发业务处理程序

关于造轮子：
大家都在说不要再造轮子了，我们该不该造轮子呢？个人觉得只有造轮子才能更好地了解轮子
- 使用Netty实现一个高性能的网关：性能测试、功能设计、性能分析、压测
- 设计实现一个功能完善的服务框架
- 设计实现一个简单高效的消息队列

关于代码质量：
- 如何编写高质量代码
- 代码中的坏味道

关于分布式：
- 为什么要做服务化？最开始为了解决数据库的连接数问题，现在解决问题更多了
- 优化性能：分布式缓存（QPS）、分布式消息（TPS）

实践：

- 高并发-设计一个简版双十一/618秒杀系统（秒杀活动一瞬间的并发比较大）
- 最大的并发：支付宝、淘宝在双十一12点一秒几十万的并发（tps）（一天9w秒）
- 现在平均的一线：几千万订单级别，淘宝每天3000w左右 每秒几百的并发

# 三、跟踪、复盘、总结
> 从定性到定量

希望通过输出文章的方式记录我对技术的思考和学习，更希望能得到大家的纠错。不断完善个人知识体系、代码质量、写作和画图等能力。  
针对月度、年度做复盘和总结，更要坚持跟踪自己输出文章的进度。 
持续学习.........
