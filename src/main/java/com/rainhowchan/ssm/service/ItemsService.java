package com.rainhowchan.ssm.service;

import com.rainhowchan.ssm.po.ItemsCustom;
import com.rainhowchan.ssm.po.ItemsQueryVo;

import java.util.List;

/**
 * Created by Administrator on 2017/1/6.
 */
public interface ItemsService {

    List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;

    ItemsCustom findItemsById(Integer id) throws Exception;

    public void updateItems(Integer id,ItemsCustom itemsCustom)throws Exception;
}
