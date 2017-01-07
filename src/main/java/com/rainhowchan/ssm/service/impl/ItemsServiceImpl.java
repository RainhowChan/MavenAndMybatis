package com.rainhowchan.ssm.service.impl;

import com.rainhowchan.ssm.mapper.ItemsMapper;
import com.rainhowchan.ssm.mapper.ItemsMapperCustom;
import com.rainhowchan.ssm.po.Items;
import com.rainhowchan.ssm.po.ItemsCustom;
import com.rainhowchan.ssm.po.ItemsQueryVo;
import com.rainhowchan.ssm.service.ItemsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/1/6.
 */
@Service
public class ItemsServiceImpl implements ItemsService {

    @Resource
    @Qualifier("itemsMapperCustom")
    private ItemsMapperCustom itemsMapperCustom;

    @Resource
    @Qualifier("itemsMapper")
    private ItemsMapper itemsMapper;

    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
//        ItemsMapperCustom itemsMapperCustom = (ItemsMapperCustom) context.getBean("itemsMapperCustom");
        return itemsMapperCustom.findItemsList(itemsQueryVo);
    }

    public ItemsCustom findItemsById(Integer id) {
        Items items = itemsMapper.selectByPrimaryKey(id);
        ItemsCustom itemsCustom = new ItemsCustom();
        BeanUtils.copyProperties(items, itemsCustom);
        return itemsCustom;
    }

    public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
        System.out.println(itemsCustom);
        if (id == null)
            throw new Exception("id 不能为空");
        itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
    }
}
