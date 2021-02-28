package com.example.demo.services;


import com.example.demo.models.Sales;
import com.example.demo.repositories.SalesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesServiceImpl implements SalesService{
    private final static Logger logger = LoggerFactory.getLogger(SalesServiceImpl.class);


    @Autowired
    SalesRepository salesRepository;
    @Override
    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }


    @Override
    public Sales createSales(Sales sales) {
        return salesRepository.save(sales);
    }


    @Override
    public List<Sales> insertAll(List<Sales> sales) {
        return salesRepository.saveAll(sales);
    }


    @Override
    public Sales updateSales(Sales sales) {
        Optional<Sales> optional = salesRepository.findById(sales.getId());
        if(optional.isPresent())
        {
            Sales sales1 = optional.get();
            sales1.setClient(sales.getClient());
            sales1.setName((sales.getName()));
            sales1.setSeller(sales.getSeller());
            sales1.setTotal(sales.getTotal());
            logger.info("Updating Sale" + sales1.getName() + " successfully...");
            return salesRepository.save(sales1);
        }
        else {
            return null;
        }
    }
}
