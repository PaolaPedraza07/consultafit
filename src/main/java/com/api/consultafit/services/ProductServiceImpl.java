package com.api.consultafit.services;

import com.api.consultafit.models.Product;
import com.api.consultafit.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

//Esta clase implementa los servicios
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired//Para inyectar objetos sin escribir toda su estructura
    private ProductRepository productRepository;

    @Override //Sobreescribiendo el metodo de la interfaz, le decimos que haga lo que se sobreescribe
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
//        Product productoDB = productRepository.getById(id);
//        return productRepository.save(productoDB);
        return productRepository.findById(id).get();//Gracias señor!!! me has mirado a los ojos
//        return productRepository.getById(id);
//        return productoDB;
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Integer id, Product product) {
        Product productoDB = productRepository.getById(id);//Variable para guardar datos parcialmente
        // para almacenarlos despues
        productoDB.setArchivo(product.getArchivo());
        productoDB.setCategoria(product.getCategoria());
        productoDB.setColor(product.getColor());
        productoDB.setDescrip(product.getDescrip());
        productoDB.setMarca(product.getMarca());
        productoDB.setNombre(product.getNombre());
        productoDB.setPrecio(product.getPrecio());
        productoDB.setTalla(product.getTalla());
        productoDB.setCantidad(product.getCantidad());
        return productRepository.save(productoDB);
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }


}
