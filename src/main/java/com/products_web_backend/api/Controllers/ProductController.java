package com.products_web_backend.api.Controllers;

import com.products_web_backend.api.Models.Product;
import com.products_web_backend.api.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public ArrayList<Product> getProducts() {
        return service.allProducts();
    }

    @GetMapping("/products/{prodId}")
    public Product fetchSingleProduct(@PathVariable int prodId) {
        return service.getProduct(prodId);
    }

    @DeleteMapping("/products/{prodId}")
    public void deleteProduct(@PathVariable int prodId) {
        service.deleteProduct(prodId);
    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody Product prod ) {
        System.out.println("In here");
        service.updateProduct(prod);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product prod) {
        service.addProduct(prod);
    }

}
