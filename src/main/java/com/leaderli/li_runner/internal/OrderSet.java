package com.leaderli.li_runner.internal;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import java.lang.reflect.Method;

public class OrderSet {

    public static final String DEFAULT_DATE_FORMAT = "yyyyMMdd";

    public static String now() {

        return now("");

    }

    public static String now(String format) {

        if (StringUtils.isEmpty(format)) {
            format = DEFAULT_DATE_FORMAT;
        }

        return DateTime.now().toString(format);
    }


    static {

        for (Method declaredMethod : OrderSet.class.getDeclaredMethods()) {
        }

    }
}
