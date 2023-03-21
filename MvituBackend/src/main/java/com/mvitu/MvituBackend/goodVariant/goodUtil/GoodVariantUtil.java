package com.mvitu.MvituBackend.goodVariant.goodUtil;

import com.google.cloud.firestore.DocumentSnapshot;
import com.mvitu.MvituBackend.goods.Good;
import com.mvitu.MvituBackend.goods.GoodUtil.GoodFields;
import com.mvitu.MvituBackend.goods.GoodVariant;

import java.util.HashMap;
import java.util.Map;

public class GoodVariantUtil {
    protected static GoodVariant getCourseFromSnapshot(DocumentSnapshot snap) {
        return GoodVariant.builder()
                .good_variant_name(snap.getString(GoodVariantFields.good_variant_name))
                .good_description(snap.getString(GoodVariantFields.good_description))
                .wholesale_price(snap.getDouble(GoodVariantFields.wholesale_price))
                .retail_price(snap.getDouble(GoodVariantFields.retail_price))
                .wholesale_quantities(snap.getDouble(GoodVariantFields.wholesale_quantities))
                .build();

    }

    public static Map<String, Object> createMapFromGood(GoodVariant good) {
        Map<String,Object> map=new HashMap<>();
        map.put(GoodVariantFields.good_variant_name,good.getGood_variant_name());
        map.put(GoodVariantFields.good_description,good.getGood_description());
        map.put(GoodVariantFields.wholesale_price,good.getWholesale_price());
        map.put(GoodVariantFields.retail_price,good.getRetail_price());
        map.put(GoodVariantFields.wholesale_quantities,good.getWholesale_quantities());


        return map;
    }
}
