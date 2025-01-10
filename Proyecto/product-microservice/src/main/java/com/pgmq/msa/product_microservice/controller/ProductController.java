package com.pgmq.msa.product_microservice.controller;

import com.pgmq.msa.product_microservice.entity.ProductEntity;
import com.pgmq.msa.product_microservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Este controlador sera de tipo rest
@RequestMapping("/api/products") //Definimos la URL general para acceder  a los endpoints de este controlador
public class ProductController {
    @Autowired //inyecta dependencias automaticamente sin necesidad de instanciar la clase
    private ProductRepository productRepository;

    @GetMapping //para que sea accesible al meodo get() de http
    @ResponseStatus(HttpStatus.OK)
    public List<ProductEntity> getAllProducts(){ //endpoint que trae todos los productos
        return productRepository.findAll();

    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createProduct(@RequestBody ProductEntity productEntity){
        productRepository.save(productEntity);
    }
}
