package com.devsuperior.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.course.entities.Order;
import com.devsuperior.course.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderResource {

    @Autowired
    private OrderService services;

    @GetMapping
    public ResponseEntity<List<Order>> getfindAll() {

        List<Order> list = services.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Order> findById(@PathVariable Long Id){
        Order obj = services.findById(Id);
        return ResponseEntity.ok().body(obj);
    }

}
