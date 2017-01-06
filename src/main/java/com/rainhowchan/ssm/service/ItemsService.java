package com.rainhowchan.ssm.service;

import com.rainhowchan.ssm.po.ItemsCustom;

import java.util.List;

/**
 * Created by Administrator on 2017/1/6.
 */
public interface ItemsService {

    List<ItemsCustom> findItemsList(ItemsCustom itemsCustom) throws Exception;

    ItemsCustom findItemsById(int id);

}
