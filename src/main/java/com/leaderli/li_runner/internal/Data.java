package com.leaderli.li_runner.internal;

public class Data {

    public final String id;
    public final String label;
    public final String name;

    public Data(String id, String label, String name) {
        this.id = id;
        this.label = label;
        this.name = name;
    }

    public static Data of(String id, String name, String label) {
        return new Data(id,name,label);
    }

    @Override
    public String toString() {
        return "("+id+","+label+","+name+")";
    }
}
