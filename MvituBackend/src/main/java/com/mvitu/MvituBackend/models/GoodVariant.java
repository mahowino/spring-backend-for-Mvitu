package com.mvitu.MvituBackend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodVariant {
    String good_variant_name,good_description;
    double retail_price,wholesale_price;
    int wholesale_quantities;

}
