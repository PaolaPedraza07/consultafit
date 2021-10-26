package com.api.consultafit.controller;

import com.api.consultafit.models.Product;
import com.api.consultafit.services.ProductServiceImpl;
import com.api.consultafit.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Definir algo que será un controlador
@RequestMapping("/productos") //Definir el nombre del recurso para alcanzarlo por HTTP
public class ProductController {
    //Manejar nombres en plural
    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> getAll(){
        return productService.getAll();
    }

    @PostMapping
    public Product create(@RequestBody /* Tomar los datos del body (Deserializacion //cambiarlo de estructura) */
                                  Product product){
        return productService.create(product);
    }

//    @PutMapping("/{id}")
//    public Product update(@PathVariable /*Tomar valores de ruta y guardarlos para procesarlos*/
//                                      Integer id, @RequestBody Product product){
//    return productService.update(id,product);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Integer id){
//        productService.delete(id);
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); //Builder Pattern
//    }

}
