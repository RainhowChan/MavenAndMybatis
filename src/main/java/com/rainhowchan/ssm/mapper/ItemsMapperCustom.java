package com.rainhowchan.ssm.mapper;

import com.rainhowchan.ssm.po.ItemsCustom;
import com.rainhowchan.ssm.po.ItemsQueryVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/1/7.
 */
public interface ItemsMapperCustom {

    List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo);

}
