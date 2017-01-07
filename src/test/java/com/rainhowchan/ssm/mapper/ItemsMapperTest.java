package com.rainhowchan.ssm.mapper;

import com.rainhowchan.ssm.po.Items;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/1/7.
 */
public class ItemsMapperTest {
    private ItemsMapper itemsMapper;

    @Before
    public void init() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
        itemsMapper= (ItemsMapper) context.getBean("itemsMapper");
    }
    @Test
    public void updateByPrimaryKeySelective() throws Exception {

    }

    @Test
    public void updateByPrimaryKeyWithBLOBs() throws Exception {
        Items items = new Items();
        items.setId(4);
        items.setName("shoushouji");
        items.setPrice(30.8f);
        items.setDetail("手机的质量还是很不错的!");
        items.setCreatetime(new Date());
        itemsMapper.updateByPrimaryKeyWithBLOBs(items);
    }

    @Test
    public void updateByPrimaryKey() throws Exception {

    }

}