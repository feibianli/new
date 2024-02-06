package com.example;

import com.example.mapper.UserMapper;

import com.example.pojo.Novel;
import com.example.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class testmybatis {

    @Test
    public  void testFindAll() throws IOException {
        System.out.println("hello");
        //获取SqlSessionFactory
        String resource ="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取Mapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //执行方法
        List<User> users = userMapper.findAll();
        System.out.println(users);
        //释放资源
        sqlSession.close();
    }
    @Test
    public void testSelectByKeyword() throws IOException {
        String title ="斗破";
        //获取SqlSessionFactory
        String resource ="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取Mapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //执行方法
        List<Novel> novels = userMapper.selectByKeyword();
        System.out.println(novels);
        sqlSession.close();
    }
}
