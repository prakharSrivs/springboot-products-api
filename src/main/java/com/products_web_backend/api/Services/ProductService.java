package com.products_web_backend.api.Services;

import com.products_web_backend.api.Models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class ProductService {

    ArrayList<Product> products;

    public ProductService(){
        products = new ArrayList<>(Arrays.asList(
                new Product(101,"Buddha Statue",1000),
                new Product(102,"Milton Bottle",750),
                new Product(103,"Sticky Notes",100)
        ));
    }


    public ArrayList<Product> allProducts() {
        return products;
    }

    public Product getProduct(int prodId) {
        int index = -1;

        for(int i=0; i<products.size(); i++)
            if( products.get(i).getProdId() == prodId ) return products.get(i);

        return new Product(0,"Product Not Found",0);
    }

    public void deleteProduct(int prodId) {
        int index = -1;

        for(int i=0; i<products.size(); i++)
            if( products.get(i).getProdId() == prodId ) {
                products.remove(i);
                break;
            }
    }

    public void updateProduct(Product prod) {
        int index = -1;

        for(int i=0; i<products.size(); i++)
            if( products.get(i).getProdId() == prod.getProdId() ) {
                index = i;
                break;
            }

        if( index == -1 ) return;

        products.set(index, prod);
    }

    public void addProduct(Product prod) {
        products.add(prod);
    }
}
