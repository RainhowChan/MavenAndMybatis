package com.rainhowchan.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.rainhowchan.ssm.po.ItemsCustom;
import com.rainhowchan.ssm.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/1/6.
 */
@Controller
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    private ItemsService itemsService;

    @RequestMapping(value = "/queryItems", method = RequestMethod.GET)
    public ModelAndView queryItems() {
        List<ItemsCustom> itemsList = null;
        try {
            itemsList = itemsService.findItemsList(null);
        } catch (Exception e) {
            return new ModelAndView("index");
        }
        return new ModelAndView("itemsList", "itemsList", itemsList);
    }

    @RequestMapping(value = "/editItems", method = {RequestMethod.GET})
    public String editItems(Model model, Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        ItemsCustom itemsCustom = null;
        try {
            itemsCustom = itemsService.findItemsById(id);
        } catch (Exception e) {
            return "index";
        }
        model.addAttribute("item", itemsCustom);
        return "editItem_2";
    }

    @RequestMapping(value = "/editItemSubmit", method = RequestMethod.POST)
    public String commitItem(Integer id, ItemsCustom itemsCustom) {
        System.out.println(id+"---"+itemsCustom.toString());
        try {
            itemsService.updateItems(id, itemsCustom);
        } catch (Exception e) {
            return "index";
        }
        return "redirect:queryItems.action";
    }

   /* *//**
     * 无法在多个controller中使用
     * @param binder
     * @throws Exception
     *//*
    @InitBinder
    public void initBinder(WebDataBinder binder) throws Exception {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
    }*/


}
