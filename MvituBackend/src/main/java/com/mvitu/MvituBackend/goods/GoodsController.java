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

    @GetMapping("/good")
    public ResponseEntity<List<Good>> getGoods(@RequestParam String good_id) throws ExecutionException, InterruptedException {
        return ResponseEntity.ok(service.getGoods());
    }

    @PostMapping("/add")
    public ResponseEntity addGoodVariant(@RequestParam String goodId, @RequestBody Good good){
        service.addGoods(good);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
