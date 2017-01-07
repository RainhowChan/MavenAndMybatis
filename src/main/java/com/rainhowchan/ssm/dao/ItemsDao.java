package com.rainhowchan.ssm.dao;

import com.rainhowchan.ssm.po.Items;
import com.rainhowchan.ssm.po.ItemsCustom;

import java.util.List;

/**
 * Created by Administrator on 2017/1/7.
 */
public interface ItemsDao {

    Items findItemsById(int id) throws Exception;

    List<ItemsCustom> findItemsList(ItemsCustom itemsCustom) throws Exception;
}
