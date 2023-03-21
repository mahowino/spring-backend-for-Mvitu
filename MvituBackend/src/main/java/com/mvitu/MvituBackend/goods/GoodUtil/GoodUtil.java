package com.mvitu.MvituBackend.goods.GoodUtil;

import com.google.cloud.firestore.DocumentSnapshot;
import com.mvitu.MvituBackend.goods.Good;

import java.util.HashMap;
import java.util.Map;

public abstract class GoodUtil {
    protected static Good getCourseFromSnapshot(DocumentSnapshot snap) {
        return Good.builder()
                .good_name(snap.get(GoodFields.good_name).toString())
                .good_description(snap.get(GoodFields.good_description).toString())
                .good_category(snap.get(GoodFields.good_category).toString())
                .build();

    }

    public static Map<String, Object> createMapFromGood(Good good) {
        Map<String,Object> map=new HashMap<>();
        map.put(GoodFields.good_name,good.getGood_name());
        map.put(GoodFields.good_category,good.getGood_category());
        map.put(GoodFields.good_description,good.getGood_description());

        return map;
    }
}
