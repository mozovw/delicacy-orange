mybatis细节探究

1、什么是mybatis

> MyBatis是一款优秀的持久层框架，它支持定制化 SQL、存储过程以及高级映射。
> MyBatis 避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集。
> MyBatis 可以使用简单的 XML 或注解来配置和映射原生信息，将接口和 Java 
> 的 POJOs(Plain Old Java Objects,普通的 Java对象)映射成数据库中的记录。

2、为什么选择mybatis

* 上手快
* 灵活
 

3、mybatis如何工作

> 我们所写的mapper里面的interface都会被MapperProxy代理
> 而配置文件和mapper下面的mapper的xml都会被加载到sqlsession中

