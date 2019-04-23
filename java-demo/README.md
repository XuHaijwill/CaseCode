# RabbitMQ使用指南

官网  https://www.rabbitmq.com/getstarted.html、https://www.rabbitmq.com/java-client.html
## 基本操作命令
查询所有用户 

rabbitmqctl list_users

rabbitmqctl add_user xhj xhj

rabbitmqctl set_user_tags xhj administrator

RabbitMQ中的角色分为如下五类：none、management、policymaker、monitoring、administrator

* none 
不能访问 management plugin

* management 

用户可以通过AMQP做的任何事外加： 
列出自己可以通过AMQP登入的virtual hosts 
查看自己的virtual hosts中的queues, exchanges 和 bindings 
查看和关闭自己的channels 和 connections 
查看有关自己的virtual hosts的“全局”的统计信息，包含其他用户在这些virtual hosts中的活动。

* policymaker 

management可以做的任何事外加： 
查看、创建和删除自己的virtual hosts所属的policies和parameters

* monitoring 

management可以做的任何事外加： 
列出所有virtual hosts，包括他们不能登录的virtual hosts 
查看其他用户的connections和channels 
查看节点级别的数据如clustering和memory使用情况 
查看真正的关于所有virtual hosts的全局的统计信息

* administrator 

policymaker和monitoring可以做的任何事外加: 
创建和删除virtual hosts 
查看、创建和删除users 
查看创建和删除permissions 
关闭其他用户的connections

设置权限
rabbitmqctl set_permissions -p / xhj ".*" ".*" ".*"
