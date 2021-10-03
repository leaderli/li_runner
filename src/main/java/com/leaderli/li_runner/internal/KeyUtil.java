package com.leaderli.li_runner.internal;

import com.leaderli.liutil.dom.LiDomUtil;
import com.leaderli.liutil.util.LiListUtil;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import org.dom4j.dom.DOMElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KeyUtil {

    public static void findDuplicateKey(List<Tuple2<String, Data>> errorTuples, String tag, DataArray<Data> keys) {

        List<String> duplicateElement = LiListUtil.getDuplicateElement(Arrays.stream(keys.toArray())
                .map(key -> key.name)
                .collect(Collectors.toList()));

        if (duplicateElement.size() > 0) {

            Arrays.stream(keys.toArray())
                    .filter(tup -> duplicateElement.contains(tup.name))
                    .forEach(key -> errorTuples.add(Tuple.of(tag + " name must be unique", key)));
        }
    }

    public static void findNotPrimary(List<Tuple2<String, Data>> errorTuples, String tag, DataArray<Data> requestKey) {
        requestKey.forEach(tup -> {
            ExprType type = ExprType.getExprTypeByInitial(tup.name);
            if (type != ExprType.PRIMARY) {
                errorTuples.add(Tuple.of(tag + " name must be primary", tup));
            }
        });
    }

    public static DataArray<Data> getKeys(List<Tuple2<String, Data>> errorTuples, String tag, DOMElement root) {

        final List<DOMElement> children = LiDomUtil.getChildren(root, tag + "/entry");

        DataArray<Data> requestKey = new DataArray<>(children.size());
        for (int i = 0; i < children.size(); i++) {

            DOMElement request = children.get(i);

            String id = request.attributeValue("id", i + "");
            String name = request.getTextTrim();
            String label = request.attributeValue("label", "");


            requestKey.add(Data.of(id, label, name));

            request.setAttribute("id", id);
        }
        KeyUtil.findNotPrimary(errorTuples, tag, requestKey);

        KeyUtil.findDuplicateKey(errorTuples, tag, requestKey);

        return requestKey;
    }
}
