package ru.geekbrains.boot.Hometask4.Repository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.geekbrains.boot.Hometask4.Exception.ProductAlreadyAdded;
import ru.geekbrains.boot.Hometask4.Exception.ProductNotFound;
import ru.geekbrains.boot.Hometask4.Model.Product;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepository {
    private List<Product> productList;

    @PostConstruct
    public void init() {
        productList = new ArrayList<>();
        productList.add(new Product(1234L, "IPhone 8", 70000));
        productList.add(new Product(5678L, "IPhone 9", 80000));
        productList.add(new Product(8765L, "IPhone 10", 90000));
        productList.add(new Product(4321L, "IPhone 11", 100000));
        productList.add(new Product(1111L, "IPhone 12", 110000));
    }

    public List<Product> findAll() {
        return Collections.unmodifiableList(productList);
    }

    public Product save(Product product) {
        if (product.getId() != null) {
            for (Product value : productList) {
                if (value.getId().equals(product.getId())) {
                    throw new ProductAlreadyAdded("Продукт с ID: " + product.getId() + "уже существует");
                }
            }
        }
        productList.add(product);
        return product;
    }

    public Product update(Product product) {
        if(product.getId() != null) {
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getId().equals(product.getId())) {
                    productList.set(i, product);
                    return product;

                }
            }
        }
        throw new ProductNotFound("Продукт с ID: " + product.getId() + " не найден");
    }

    public void deleteByID(Long id) {
        productList.removeIf(product -> product.getId().equals(id));
    }
}




