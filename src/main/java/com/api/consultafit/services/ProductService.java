package com.api.consultafit.services;


import com.api.consultafit.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    List<Product> getAll();

    Product findById(Integer id);

    Product create(Product product);

    Product update(Integer id, Product product);

    void delete(Integer id);

}
