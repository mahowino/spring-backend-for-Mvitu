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
public class GoodsService {

    static Firestore db= FirestoreClient.getFirestore();

    public List<Good> getGoods() throws ExecutionException, InterruptedException {
        Query query=db.collection(GoodsCollections.GOODS);
        return GoodsDao.getGoodsFromFirestore(query);
    }

    public String addGoods(Good good){
        DocumentReference reference=db.collection(GoodsCollections.GOODS).document();
        GoodsDao.addGoodsToFirestore(reference,good);
        return reference.getId();
    }

    //later
    public void deleteGood(Good good){
        Query query=db.collection(GoodsCollections.GOODS);
        GoodsDao.deleteGoodFromFirestore(good);

    }
    public void editGoods(Good good){
        Query query=db.collection(GoodsCollections.GOODS);
        GoodsDao.editFoodsFromFirestore(good);
    }

}
