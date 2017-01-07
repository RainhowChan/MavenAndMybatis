package com.rainhowchan.ssm.mapper;

import com.alibaba.fastjson.JSON;
import com.rainhowchan.ssm.po.ItemsCustom;
import com.rainhowchan.ssm.po.ItemsQueryVo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/1/7.
 */
public class ItemsMapperCustomTest {
    private ItemsMapperCustom itemsMapperCustom;

    @Before
    public void setUp() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
        itemsMapperCustom = (ItemsMapperCustom) context.getBean("itemsMapperCustom");
    }

    @Test
    public void findItemsList() throws Exception {
        ItemsQueryVo queryVo = new ItemsQueryVo();
        ItemsCustom custom = new ItemsCustom();
        custom.setName("手");
        queryVo.setItemsCustom(custom);
        List<ItemsCustom> itemsCustoms = itemsMapperCustom.findItemsList(queryVo);
        System.out.println(JSON.toJSONString(itemsCustoms));
    }

}