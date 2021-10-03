package com.leaderli.li_runner.internal;

import com.leaderli.liutil.dom.LiDomUtil;
import io.vavr.Tuple2;
import org.dom4j.DocumentException;
import org.dom4j.dom.DOMElement;

import java.util.ArrayList;
import java.util.List;

public class CoreTest {

    @org.junit.Test
    public void test() throws DocumentException {

        List<Tuple2<String, Data>> errorTuples = new ArrayList<>();

        DOMElement root = LiDomUtil.getDOMRootByPath("/main.xml");

        final DataArray<Data> requestKey = KeyUtil.getKeys(errorTuples,"request",root);

        final DataArray<Data> responseKey= KeyUtil.getKeys(errorTuples,"response",root);

        ParserUtil.throwWhenErrorOccur(errorTuples);

        MainXml mainXml = new MainXml(requestKey, responseKey);
        System.out.println(mainXml);
    }

}
