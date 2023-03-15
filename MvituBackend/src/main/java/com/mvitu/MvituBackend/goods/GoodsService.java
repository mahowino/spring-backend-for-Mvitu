package com.mvitu.MvituBackend.goods;

import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.firebase.cloud.FirestoreClient;
import com.mvitu.MvituBackend.goods.GoodsDao.GoodsCollections;
import com.mvitu.MvituBackend.goods.GoodsDao.GoodsUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class GoodsService {

    static Firestore db= FirestoreClient.getFirestore();
    public List<Good> getGoods() throws ExecutionException, InterruptedException {
        Query query=db.collection(GoodsCollections.GOODS);
        return GoodsUtil.getGoodsFromFirestore(query);
    }

    public void addGoods(){}
    public void deleteGood(){}
    public void editGoods(){}

}
