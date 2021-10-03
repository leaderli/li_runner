package com.leaderli.li_runner.internal;

import java.util.HashMap;
import java.util.Map;

public enum DataType {

    INT("int"),
    STR("str"),
    DOUBLE("double"),
    BOOL("boolean");

    public final String alias;

    private interface DataTypeSupport {
        Map<Class, DataType> CLASS_DATATYPE = new HashMap<>();
    }

    DataType(String alias, Class... types) {
        this.alias = alias;
        for (Class type : types) {
            DataTypeSupport.CLASS_DATATYPE.put(type, this);
        }
    }
}

