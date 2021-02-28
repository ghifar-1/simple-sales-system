package com.example.demo.services;


import com.example.demo.models.Product;

import java.util.List;

public interface ProductsService {

   List<Product> getAllProducts();

   Product createProducts(Product product);

   Product updateProducts(Product product);

}
