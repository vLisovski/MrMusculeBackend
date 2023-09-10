package com.lisovski.mrmuscule.controllers;

import com.lisovski.mrmuscule.aspect.LogExecuteTimeAnnotation;
import com.lisovski.mrmuscule.enums.ProductType;
import com.lisovski.mrmuscule.models.Product;
import com.lisovski.mrmuscule.services.ProductService;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("free/products")
@AllArgsConstructor
@Validated
@Slf4j
public class ProductController {

    private ProductService productService;
    @GetMapping("getAll/inventory")
    @LogExecuteTimeAnnotation
    public List<Product> getInventoryProducts(@Min(1) @Max(16) @RequestParam @NotNull int limit,
                                              @Min(0) @Max(2147483630) @RequestParam @NotNull int offset) {
        log.info("GET ALL INVENTORY WITH limit="+limit+" AND offset="+offset);
        return productService.getProductsByCategory(ProductType.inventory,limit,offset);
    }

    @GetMapping("getAll/food")
    @LogExecuteTimeAnnotation
    public List<Product> getFoodProducts(@Min(1) @Max(16) @NotNull @RequestParam int limit,
                                         @Min(0) @Max(2147483630) @RequestParam @NotNull int offset) {
        log.info("GET ALL FOOD WITH limit="+limit+" AND offset="+offset);
        return productService.getProductsByCategory(ProductType.food,limit,offset);
    }

    @GetMapping("getAll/clothes")
    @LogExecuteTimeAnnotation
    public List<Product> getClothesProducts(@Min(1) @Max(16) @NotNull @RequestParam int limit,
                                            @Min(0) @Max(2147483630) @NotNull @RequestParam int offset) {
        log.info("GET ALL CLOTHES WITH limit="+limit+" AND offset="+offset);
        return productService.getProductsByCategory(ProductType.clothes,limit,offset);
    }

    @PostMapping("getAllByIdList")
    @LogExecuteTimeAnnotation
    public List<Product> getProductsByIds(@RequestBody String json){

        System.out.println("PRODUCTS IDS" + json);

        String request1 = json.replace("{"," ");
        String request2 = request1.replace("}"," ");
        String request3 = request2.replace("\""," ");
        String request4 = request3.replace("ids"," ");
        String request5 = request4.replace(":"," ");
        String request = request5.trim();

        System.out.println(request);

        String[] strings = request.split(",");

        int[] ints = new int[strings.length];

        for (int i = 0; i < strings.length; i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }

        List<Integer> integers = new ArrayList<>();

        for (int i = 0; i < ints.length; i++) {
            integers.add(ints[i]);
        }
        log.info("GET PRODUCTS BY ID list: "+integers);
        return productService.getProductsByIds(integers);
    }

    @GetMapping("getTotal/inventory")
    @LogExecuteTimeAnnotation
    public int getTotalInventory(){
        log.info("GET TOTAL NUMBER OF INVENTORY");
        return productService.getTotalInventory();
    }

    @GetMapping("getTotal/clothes")
    @LogExecuteTimeAnnotation
    public int getTotalClothes(){
        log.info("GET TOTAL NUMBER OF CLOTHES");
        return productService.getTotalClothes();
    }

    @GetMapping("getTotal/food")
    @LogExecuteTimeAnnotation
    public int getTotalFood(){
        log.info("GET TOTAL NUMBER OF FOOD");
        return productService.getTotalFood();}

    @GetMapping("getTotal/target")
    @LogExecuteTimeAnnotation
    public int getTotalByTag(@NotNull @RequestParam String tag1,
                             @NotNull @RequestParam String tag2){
        log.info("GET TOTAL NUMBER OF PRODUCTS BY tag1="+tag1+" AND tag2="+tag2);
        System.out.println("TAG1 "+tag1);
        System.out.println("TAG2 "+tag2);
        System.out.println("TOTAL BY TAGS "+ productService.getTotalByTags(tag1, tag2));
        return productService.getTotalByTags(tag1, tag2);
    }

    @GetMapping("getAll/target")
    @LogExecuteTimeAnnotation
    public List<Product> getAllByTag(@NotNull @RequestParam String tag1,
                                     @NotNull @RequestParam String tag2,
                                     @NotNull @Min(1) @Max(16) @RequestParam int limit,
                                     @NotNull @Min(0) @Max(2147483630) @RequestParam int offset){
        log.info("GET ALL PRODUCTS BY tag1="+tag1+" AND tag2="+tag2+" WITH limit="+limit+" AND offset="+offset);
        return productService.getProductsByTag(tag1,tag2,limit,offset);
    }
}
