package com.leaderli.li_runner.internal;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class MyDataArrayTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test1() {

        DataArray<Integer> dataArray = new DataArray<>(5);

        for (int i = 0; i < 5; i++) {
            dataArray.add(i);
        }
        assert "[0, 1, 2, 3, 4]".equals(dataArray.toString());
        assert 4 == dataArray.get(4);
        thrown.expect(ArrayIndexOutOfBoundsException.class);
        System.out.println(dataArray.get(5));
    }

    @SuppressWarnings({"ConstantConditions", "EqualsBetweenInconvertibleTypes"})
    @Test
    public void test2() {

        DataArray<Integer> a = new DataArray<>(5);
        DataArray<Integer> b = new DataArray<>(6);

        assert !a.equals(b);
        assert !a.equals(null);
        assert !a.equals(0);


        b = new DataArray<>(5);
        assert a.equals(b);

        a.add(1);
        b.add(1);
        assert a.equals(b);

        a.add(1);
        assert !a.equals(b);
    }


}