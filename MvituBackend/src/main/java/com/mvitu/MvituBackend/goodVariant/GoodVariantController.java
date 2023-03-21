package com.mvitu.MvituBackend.goodVariant;

import com.mvitu.MvituBackend.goods.GoodVariant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/good-variant")
public class GoodVariantController {

    @Autowired
    GoodVariantService service;

    @GetMapping("/good-type")
    public ResponseEntity<List<GoodVariant>> getGoods(@RequestParam String good_id) throws ExecutionException, InterruptedException {
    return ResponseEntity.ok(service.getGoods(good_id));
    }

    @PostMapping("/add")
    public ResponseEntity addGoodVariant(@RequestParam String goodId, @RequestBody GoodVariant goodVariant){
        service.addGoodVariant(goodVariant,goodId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
