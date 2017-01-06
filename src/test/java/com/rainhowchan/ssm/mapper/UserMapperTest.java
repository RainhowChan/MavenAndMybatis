package com.rainhowchan.ssm.mapper;

import com.rainhowchan.ssm.po.User;
import com.rainhowchan.ssm.po.UserExample;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by RainhowChan on 2017/1/6.
 */
/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-dao.xml")*/
public class UserMapperTest {

    private UserMapper userMapper;
    @Before
    public void init() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
        userMapper= (UserMapper) context.getBean("userMapper");
    }

    @Test
    public void selectByExample() throws Exception {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameLike("%王%");
        List<User> users = userMapper.selectByExample(userExample);
        for (User user : users) {
            System.out.println(user.getAddress());
        }
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        User user=userMapper.selectByPrimaryKey(10);
        System.out.println(user.getUsername());
    }

}