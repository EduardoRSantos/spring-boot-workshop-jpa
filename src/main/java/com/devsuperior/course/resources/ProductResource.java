package com.devsuperior.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.course.entities.Product;
import com.devsuperior.course.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductResource {

    @Autowired
    private ProductService services;

    @GetMapping
    public ResponseEntity<List<Product>> getfindAll() {

        List<Product> list = services.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Product> findById(@PathVariable Long Id){
        Product obj = services.findById(Id);
        return ResponseEntity.ok().body(obj);
    }

}
