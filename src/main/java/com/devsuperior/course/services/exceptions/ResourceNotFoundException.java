package com.devsuperior.course.services.exceptions;

public class ResourceNotFoundException  extends RuntimeException {
    
    public ResourceNotFoundException(Object id) {
        super("Recurso não encontrado: id " + id);
    } 
}
