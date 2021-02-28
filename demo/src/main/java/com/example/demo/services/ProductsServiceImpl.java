package com.example.demo.services;


import com.example.demo.models.Product;
import com.example.demo.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImpl implements ProductsService{


    @Autowired
    ProductsRepository productsRepository;

    @Override
    public List<Product> getAllProducts() {
        return productsRepository.findAll();
    }

    @Override
    public Product createProducts(Product product) {
        return productsRepository.save(product);
    }

    @Override
    public Product updateProducts(Product product) {
        Optional<Product> optional = productsRepository.findById(product.getId());
        if(optional.isPresent())
        {
            Product product1 = optional.get();
            product1.setCategory(product.getCategory());
            product1.setDescription((product.getDescription()));
            product1.setName(product.getName());
            return productsRepository.save(product1);
        }
        else {
            return null;
        }
    }
}
