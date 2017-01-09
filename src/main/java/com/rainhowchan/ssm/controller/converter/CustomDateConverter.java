package com.rainhowchan.ssm.controller.converter;


import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by RainhowChan on 2017/1/9.
 */
public class CustomDateConverter implements Converter<String,Date> {


    public Date convert(String dateStr) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
