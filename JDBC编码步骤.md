# JDBC 编码 步骤

## 1 导入所需jar包

[在这里--jar/](/jar/)

## 工具类

[jdbcUtil](utils/)

## dao层实现框架

```java
package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import utils.JdbcUtil;
import dao.UserDao;
import domain.User;
import exception.DaoException;

public class UserDaoImpl implements UserDao {

    @Override
    public void addUser(User user) {
        if(user==null){
            throw new IllegalArgumentException();
        }
        Connection conn =null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            
            
            
        }catch(Exception e){
            throw new DaoException(e);//继承自RuntimeException
        }finally{
            JdbcUtil.release(rs, stmt, conn);
        }
        
    }

    @Override
    public User findUserByUsername(String username) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User findUser(String username, String password) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delUserByUsername(String username) {
        // TODO Auto-generated method stub

    }

}


```