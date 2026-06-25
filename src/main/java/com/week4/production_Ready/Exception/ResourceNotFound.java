package com.week4.production_Ready.Exception;

public class ResourceNotFound extends  RuntimeException {
    public ResourceNotFound() {
        super("Resource Not Found");
    }

    public ResourceNotFound(String message) {
        super(message);
    }
}
