package com.mvitu.MvituBackend.goods.GoodsDao;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;
import com.mvitu.MvituBackend.goods.Good;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public abstract class GoodsUtil {
    public static List<Good> getGoodsFromFirestore(Query query) throws ExecutionException, InterruptedException {
        List<Good> goods=new ArrayList<>();
        ApiFuture<QuerySnapshot> future=query.get();
        QuerySnapshot snapshot=future.get();
        for (DocumentSnapshot snap :snapshot.getDocuments()) {
            goods.add(GoodsUtil.getCourseFromSnapshot(snap));
        }
        return goods;
    }
    protected static Good getCourseFromSnapshot(DocumentSnapshot snap) {
        return Good.builder()
                .good_name(snap.get(GoodFields.good_name).toString())
                .good_description(snap.get(GoodFields.good_description).toString())
                .good_category(snap.get(GoodFields.good_category).toString())
                .build();

    }

}
