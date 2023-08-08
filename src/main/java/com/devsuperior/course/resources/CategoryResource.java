package com.devsuperior.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.course.entities.Category;
import com.devsuperior.course.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryResource {

    @Autowired
    private CategoryService services;

    @GetMapping
    public ResponseEntity<List<Category>> getfindAll() {

        List<Category> list = services.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Category> findById(@PathVariable Long Id){
        Category obj = services.findById(Id);
        return ResponseEntity.ok().body(obj);
    }

    public void create(){
        
    }

}
