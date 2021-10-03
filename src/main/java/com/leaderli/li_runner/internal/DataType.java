package com.leaderli.li_runner.internal;

public enum DataType {

    INT("int"),
    STR("str"),
    DOUBLE("double"),
    BOOL("boolean");

    public final String alias;

    DataType(String alias) {
        this.alias = alias;
    }
}
