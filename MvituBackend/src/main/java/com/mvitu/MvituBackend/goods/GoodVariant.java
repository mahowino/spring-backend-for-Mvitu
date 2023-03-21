package com.mvitu.MvituBackend.goods;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GoodVariant {
    String good_variant_name,good_description;
    double retail_price,wholesale_price;
    double wholesale_quantities;

}
