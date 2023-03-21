package com.mvitu.MvituBackend.goodVariant.goodUtil;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;
import com.mvitu.MvituBackend.goods.Good;
import com.mvitu.MvituBackend.goods.GoodUtil.GoodUtil;
import com.mvitu.MvituBackend.goods.GoodVariant;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class GoodVariantDao {
    public static List<GoodVariant> getGoodsFromFirestore(Query query) throws ExecutionException, InterruptedException {
        List<GoodVariant> goods=new ArrayList<>();
        ApiFuture<QuerySnapshot> future=query.get();
        QuerySnapshot snapshot=future.get();
        for (DocumentSnapshot snap :snapshot.getDocuments()) {
            goods.add(GoodVariantUtil.getCourseFromSnapshot(snap));
        }
        return goods;
    }


    public static void addGoodsToFirestore(DocumentReference reference, GoodVariant good) {
        reference.set(GoodVariantUtil.createMapFromGood(good));
    }

}
