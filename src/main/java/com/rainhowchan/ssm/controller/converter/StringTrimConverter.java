package com.rainhowchan.ssm.controller.converter;

import org.springframework.core.convert.converter.Converter;

/**
 * Created by RainhowChan on 2017/1/9.
 */
public class StringTrimConverter implements Converter<String, String> {
    public String convert(String source) {
        try {
            if (source != null) {
                source = source.trim();
                if ("".equals(source))
                    return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
