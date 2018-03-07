# vc-chat
---

![架构图](https://spring.io/img/homepage/diagram-distributed-systems.svg "在这里输入图片标题")


## 模块
---
|模块名 | 说明 | 启动类| 端口| 启动顺序
|---|---|---|---|---|
| [vc-chat-api](./vc-chat-api) | Api接口层|  无 | 无 |
| [vc-chat-configserver](./vc-chat-configserver) |  配置文件服务器,用于存放线上配置文件|无 |  8888 | 1
| [vc-chat-discovery](./vc-chat-discovery) |服务注册中心,用于构建集群使用| com.vcg.chat.discovery.DiscoveryApplication|  8761 | 2
| [vc-chat-oauth2](./vc-chat-oauth2) | Oauth2安全验证,用于建立socketio连接的时候进行验证|无 |   9999 | 3 
| [vc-chat-server](./vc-chat-server) |  使用socketio 用于接受连接和消息路由。不做逻辑处理。|com.vcg.chat.server.VcChatServerApplication |  web端口 8081,socketio 1337 | 4
| [vc-chat-logic](./vc-chat-logic) |  逻辑处理层,用于消息存储与发送|com.vcg.chat.logic.VcChatLogicApplication|  8082 |  5
| [vc-chat-sample](./vc-chat-sample) |  演示项目,依赖上层服务所有都启动|com.vcg.chat.sample.VcChatSampleApplication|  8080 |  6


### vc-chat-server
---

#### 架构图
![架构图](./docs/png/chat.svg)

#### socketio example
1. [SocketIOExample](./docs/api/SocketIOExample.md)


### vc-chat-logic
---

#### 表结构

1. [user_dialogue 好友列表](./docs/model/UserDialogue.md)
2. [pri_message 消息存储表](./docs/model/PriMessage.md)


### api

1. [LogicApi](./docs/api/LogicApi.md)
2. [ServerApi.md](./docs/api/ServerApi.md)



### 开发环境

名称 | 说明
----|------
[Java](http://www.oracle.com/technetwork/java/javase/downloads/index.html) |Java开发环境 
[Intellij IDEA](https://www.navicat.com/en/products) | Java 开发工具 
[WorkBench](https://dev.mysql.com/downloads/workbench/) | 数据库连接工具 


## 依赖docker 环境
```
docker-compose -f ./docker/docker-compose.yml up -d
```



## 本项目已使用框架
|技术 | 名称 | 官网|
|---|---|---|
|Maven | 项目构建管理  | [http://maven.apache.org/](http://maven.apache.org/)|
|SpringMVC | MVC框架  | [http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc)|
|SpringBoot | spring快速开发框架 | [https://projects.spring.io/spring-boot/](https://projects.spring.io/spring-boot/)|
|SpringCloud | Spring Cloud是一系列框架的有序集合 | [https://projects.spring.io/spring-cloud/](https://projects.spring.io/spring-cloud/)|
|Spring Session | 分布式Session管理  | [http://projects.spring.io/spring-session/](http://projects.spring.io/spring-session/)|
|Spring OAuth2 | SSO  | [https://projects.spring.io/spring-security-oauth/](https://projects.spring.io/spring-security-oauth/)|
|Swagger2 | 接口测试框架  | [http://swagger.io/](http://swagger.io/)|
|MyBatis | ORM框架  | [http://www.mybatis.org/mybatis-3/zh/index.html](http://www.mybatis.org/mybatis-3/zh/index.html)|
|Spring Data | Orm 封装  | [https://projects.spring.io/spring-data/](https://projects.spring.io/spring-data/)|
|RabbitMq | 消息队列  | [http://www.rabbitmq.com/](http://www.rabbitmq.com/)|
|SocketIO Java版实现 | 消息队列  | [https://github.com/mrniko/netty-socketio](https://github.com/mrniko/netty-socketio)|
|SocketIO 其他语言客户端 | 消息队列  | [https://socket.io/](https://socket.io/)|
|Docker | 容器框架  | [https://www.docker.com/](https://www.docker.com/)|

## 后端可选框架框架:
|技术 | 名称 | 官网|
|---|---|---|
|Spring Framework | 容器  | [http://projects.spring.io/spring-framework/](http://projects.spring.io/spring-framework/)|
|SpringMVC | MVC框架  | [http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc)|
|SpringBoot | spring快速开发框架 | [https://projects.spring.io/spring-boot/](https://projects.spring.io/spring-boot/)|
|SpringCloud | Spring Cloud是一系列框架的有序集合 | [https://projects.spring.io/spring-cloud/](https://projects.spring.io/spring-cloud/)|
|Spring Session | 分布式Session管理  | [http://projects.spring.io/spring-session/](http://projects.spring.io/spring-session/)|
|Spring Security | 安全验证框架  | [https://projects.spring.io/spring-security/](https://projects.spring.io/spring-security/)|
|Spring OAuth2 | SSO  | [https://projects.spring.io/spring-security-oauth/](https://projects.spring.io/spring-security-oauth/)|
|Spring Data | Orm 封装  | [https://projects.spring.io/spring-data/](https://projects.spring.io/spring-data/)|
|MyBatis | ORM框架  | [http://www.mybatis.org/mybatis-3/zh/index.html](http://www.mybatis.org/mybatis-3/zh/index.html)|
|MyBatis Generator | 代码生成  | [http://www.mybatis.org/generator/index.html](http://www.mybatis.org/generator/index.html)|
|Thymeleaf | 模板引擎  | [http://www.thymeleaf.org/](http://www.thymeleaf.org/)|
|Swagger2 | 接口测试框架  | [http://swagger.io/](http://swagger.io/)|
|Jenkins | 持续集成工具  | [https://jenkins.io/index.html](https://jenkins.io/index.html)|
|Flyway | 使用Java API轻松完成数据库迁移 | [http://flywaydb.org/](http://flywaydb.org/)|
|RxJava | 使用JVM中可观察序列，创建异步、基于事件应用程序的函数库 | [https://github.com/Netflix/RxJava](https://github.com/Netflix/RxJava)|
|Disruptor | 线程间消息函数库 | [http://lmax-exchange.github.io/disruptor/](http://lmax-exchange.github.io/disruptor/)|
|Netty | 构建高性能网络应用程序开发框架 | [http://netty.io/](http://netty.io/)|
|Ff4j | 功能切换 |  [https://github.com/clun/ff4j](https://github.com/clun/ff4j)|


## Intellij Idea 开发插件
技术 | 名称 | 地址
----|------|----
Lombok | 简化Pojo |[https://projectlombok.org/](https://projectlombok.org/)

#### 开发规范
1. [阿里巴巴开发规范](https://github.com/alibaba/p3c/blob/master/阿里巴巴Java开发手册（终极版）.pdf)
2. [Google开发规范](http://google-styleguide.googlecode.com/svn/trunk/javaguide.html)[中文](https://segmentfault.com/a/1190000002761014)

#### 快速构建应用
1. [Start spring](http://start.spring.io)
2. [Jhipster](https://start.jhipster.tech/#/)

## 构建应用并启动

---
```
sh ./mvnw clean package
java -server -Xms1g -Xmx1g  -Dspring.profiles.active=prod -Dspring.cloud.config.profile=prod -jar  ./target/vc-chat-0.0.1-SNAPSHOT.jar
```
