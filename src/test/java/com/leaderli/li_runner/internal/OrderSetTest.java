package com.leaderli.li_runner.internal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderSetTest {


    @Test
    void now() {

        assert  OrderSet.now().length() == 8;
        assert  OrderSet.now("yyyy-MM-dd").length() == 10;

    }

    @Test
    void scan(){
        OrderSet.now();
    }

}