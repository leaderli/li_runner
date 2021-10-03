package com.leaderli.li_runner.internal;

import io.vavr.Tuple;
import org.junit.Test;

import java.util.ArrayList;

public class TupleTest {

    @Test
    public void test() {

        Tuple a = Tuple.of("1", new ArrayList<>());
        Tuple b = Tuple.of("1", new ArrayList<>());

        assert a.equals(b);

        a = Tuple.of("1", DataArray.of("1", "2", "3"));
        b = Tuple.of("1", DataArray.of("1","2","3"));

        assert a.equals(b);

    }

}
