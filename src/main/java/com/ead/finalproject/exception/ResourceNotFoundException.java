package com.ead.finalproject.exception;

public class ResourceNotFoundException extends RuntimeException{
    private String resourceName;
    private String fieldName; //id

    private Long fieldValue; //id

    public ResourceNotFoundException(String resourceName, String fieldName, Long fieldValue){
        super(String.format("%s not found with %s: %s", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue=fieldValue;
    }
}
