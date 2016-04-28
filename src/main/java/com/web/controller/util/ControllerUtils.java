package com.web.controller.util;


import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;


/**
 * Created by CrazyNaveen on 4/19/16.
 */
public class ControllerUtils {
    public static final String JSON_UTF8 = MediaType.APPLICATION_JSON_VALUE  + ";charset=UTF-8";
    public static final String XML_UTF8 = MediaType.TEXT_XML_VALUE  + ";charset=UTF-8";

    private ControllerUtils() {

    }

    public static boolean isPagingDisabled(Pageable pageable) {
        return pageable == null || (pageable.getPageSize() == Integer.MAX_VALUE && pageable.getSort() == null);
    }


}

