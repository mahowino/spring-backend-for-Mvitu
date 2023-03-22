package com.mvitu.MvituBackend.goods;

import com.mvitu.MvituBackend.goodVariant.GoodVariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/goods")
public class GoodsController {
    @Autowired
    GoodsService service;

    @GetMapping("/")
    public ResponseEntity<List<Good>> getGoods() throws ExecutionException, InterruptedException {
        return ResponseEntity.ok(service.getGoods());
    }

    @PostMapping("/add")
    public ResponseEntity<String> addGoodVariant(@RequestBody Good good){
        return ResponseEntity.status(200).body(service.addGoods(good));
    }
}
