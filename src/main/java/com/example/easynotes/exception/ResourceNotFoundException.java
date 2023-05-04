package com.example.easynotes.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// The APIs will throw a ResourceNotFoundException whenever a Note with a given id is not found in the database.

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)  // This will cause Spring boot to respond with the specified HTTP status code whenever this exception is thrown from your controller.
public class ResourceNotFoundException extends RuntimeException{

    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public ResourceNotFoundException( String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
