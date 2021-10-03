package com.leaderli.li_runner.internal;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class MyDataArrayTest {

    @Rule
    public ExpectedException thrown= ExpectedException.none();
    @Test
    public void test1() {

        DataArray<Integer> dataArray = new DataArray<>(5);

        for (int i = 0; i <5 ; i++) {
            dataArray.add(i);
        }
        assert  "[0, 1, 2, 3, 4]".equals(dataArray.toString());
        assert  4 == dataArray.get(4);
        thrown.expect(ArrayIndexOutOfBoundsException.class);
        System.out.println(dataArray.get(5));
    }




}