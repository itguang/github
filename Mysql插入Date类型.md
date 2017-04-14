# mysql 中如何插入Date类型呢


## 新建一个表

```sql
创建itsource表: 
 create table itsource (
 title varchar(100),
 link varchar(100) unique,
 outline text,
 author varchar(50),
 time DATE,
 category varchar(50)

 )
```

里面有个DATE类型,

## 用java代码插入当前时间

```java
new Date(System.currentTimeMillis())
```

```java
Date(long date) 
          使用给定毫秒时间值构造一个 Date 对象。
```

注意Date的包名
```java
java.sql 
类 Date
```