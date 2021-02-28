package com.example.demo.controllers;


import com.example.demo.models.Sales;
import com.example.demo.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class SalesController {

	@Autowired
	SalesService salesService;

	@GetMapping("/sales")
	public ResponseEntity<List<Sales>> getAllSales() {
		try {
			List<Sales> sales = new ArrayList<Sales>();

			salesService.getAllSales().forEach(sales::add);

			if (sales.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(sales, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@PostMapping("/sales/insert")
	public ResponseEntity<Sales> createSales(@RequestBody Sales sales) {
		try {
			return new ResponseEntity<>(salesService.createSales(sales), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@PostMapping("/sales/insertAll")
	public ResponseEntity<List<Sales>> createSales(@RequestBody List<Sales> sales) {
		try {
			return new ResponseEntity<>(salesService.insertAll(sales), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/sales")
	public ResponseEntity<Sales> updateSales(@RequestBody Sales sales) {
		try {
			return new ResponseEntity<>(salesService.updateSales(sales),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
