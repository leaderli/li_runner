package com.leaderli.li_runner.internal;

import io.vavr.Tuple2;

import java.util.List;

public class ParserUtil {

    public static <T> void  throwWhenErrorOccur( List<Tuple2<String, T>> errorTuples){
        if (errorTuples.size() > 0) {
            errorTuples.forEach(System.err::println);
            throw new IllegalArgumentException(errorTuples.size()+" parser error ");
        }
    }
}
