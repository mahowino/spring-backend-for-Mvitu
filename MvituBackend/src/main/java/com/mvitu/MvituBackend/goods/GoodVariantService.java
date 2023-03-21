package com.mvitu.MvituBackend.goods;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.firebase.cloud.FirestoreClient;
import com.mvitu.MvituBackend.goods.GoodUtil.GoodsCollections;
import com.mvitu.MvituBackend.goods.GoodUtil.GoodsDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class GoodVariantService {

    static Firestore db= FirestoreClient.getFirestore();

    public List<Good> getVariantGoods() throws ExecutionException, InterruptedException {
        Query query=db.collection(GoodsCollections.GOODS);
        return GoodsDao.getGoodsFromFirestore(query);
    }

    public void addVariantGoods(Good good){
        DocumentReference reference=db.collection(GoodsCollections.GOODS).document();
        GoodsDao.addGoodsToFirestore(reference,good);
    }

    //todo: add edit and delete good variant functionality
    public void deleteGood(Good good){
        Query query=db.collection(GoodsCollections.GOODS);
        GoodsDao.deleteGoodFromFirestore(good);

    }
    public void editGoods(Good good){
        Query query=db.collection(GoodsCollections.GOODS);
        GoodsDao.editFoodsFromFirestore(good);
    }
}
