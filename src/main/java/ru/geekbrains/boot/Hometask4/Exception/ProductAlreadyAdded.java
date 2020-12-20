package ru.geekbrains.boot.Hometask4.Exception;

public class ProductAlreadyAdded extends RuntimeException {
    public ProductAlreadyAdded(String message) {
        super(message);
    }
}
