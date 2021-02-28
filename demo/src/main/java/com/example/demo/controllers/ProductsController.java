package com.example.demo.controllers;


import com.example.demo.models.Product;
import com.example.demo.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ProductsController {

	@Autowired
	ProductsService productsService;

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		try {
			List<Product> products = new ArrayList<Product>();

			productsService.getAllProducts().forEach(products::add);

			if (products.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(products, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@PostMapping("/products")
	public ResponseEntity<Product> createProducts(@RequestBody Product product) {
		try {
			return new ResponseEntity<>( productsService.createProducts(product), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/products")
	public ResponseEntity<Product> updateProducts(@RequestBody Product product) {
		try {
			return new ResponseEntity<>(productsService.updateProducts(product),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
