package com.mvitu.MvituBackend.goods.GoodUtil;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;
import com.mvitu.MvituBackend.goods.Good;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public abstract class GoodsDao {
    public static List<Good> getGoodsFromFirestore(Query query) throws ExecutionException, InterruptedException {
        List<Good> goods=new ArrayList<>();
        ApiFuture<QuerySnapshot> future=query.get();
        QuerySnapshot snapshot=future.get();
        for (DocumentSnapshot snap :snapshot.getDocuments()) {
            goods.add(GoodUtil.getCourseFromSnapshot(snap));
        }
        return goods;
    }


    public static void addGoodsToFirestore(DocumentReference reference, Good good) {
        reference.set(GoodUtil.createMapFromGood(good));
    }

    public static void deleteGoodFromFirestore(Good good) {

    }

    public static void editFoodsFromFirestore(Good good) {
    }
}
