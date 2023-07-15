package com.devsuperior.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.course.entities.User;
import com.devsuperior.course.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService services;

    @GetMapping
    public ResponseEntity<List<User>> getfindAll() {

        List<User> list = services.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<User> findById(@PathVariable Long Id) {
        User obj = services.findById(Id);
        return ResponseEntity.ok().body(obj);
    }

    // Padrao para inserção
    @PostMapping("/insert")
    public ResponseEntity<User> insert(@RequestBody User obj) {
        obj = services.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        services.delete(id);
        return ResponseEntity.noContent().build();
    }

}
