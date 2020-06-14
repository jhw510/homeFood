package com.food.web.food;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class FoodDTO {

    private String  productClsCode, productClsName,  categoryCode, categoryName, productno,
     lastestDay, productName, Name ,  unit, day1,
     dpr1, day2, dpr2, day3, dpr3, day4, dpr4, direction, value;
}
