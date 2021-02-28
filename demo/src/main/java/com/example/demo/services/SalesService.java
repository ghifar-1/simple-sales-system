package com.example.demo.services;

import com.example.demo.models.Sales;

import java.util.List;

public interface SalesService {
    List<Sales> getAllSales();

    Sales createSales(Sales sales);

    List<Sales> insertAll(List<Sales> sales);

    Sales updateSales(Sales sales);

}
