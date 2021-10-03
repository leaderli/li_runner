package com.leaderli.li_runner.internal;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public enum ExprType {

    REQUEST('$'),
    RESPONSE('@'),
    FUNC('&'),
    PRIMARY(null);;


    ExprType(Character mark) {
        Inner.exprTypes.put(mark, this);
    }

    private static class Inner {

        public static Map<Character, ExprType> exprTypes = new HashMap<>();
    }

    public static ExprType getExprTypeByInitial(String expr) {

        if (StringUtils.isEmpty(expr)) {
            return PRIMARY;
        }

        return Inner.exprTypes.getOrDefault(expr.charAt(0), PRIMARY);

    }
}
