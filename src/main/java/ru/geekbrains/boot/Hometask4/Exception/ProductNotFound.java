package ru.geekbrains.boot.Hometask4.Exception;

public class ProductNotFound extends RuntimeException{
    public ProductNotFound(String message) {
        super(message);
    }
}
