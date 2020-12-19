package ru.geekbrains.boot.Hometask4.Repository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.geekbrains.boot.Hometask4.Model.Product;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepository {
    private List<Product> productList;

    @PostConstruct
    public void init() {
        productList = new ArrayList<>();
        productList.add(new Product(1234L, "IPhone 8", 70000));
        productList.add(new Product(1234L, "IPhone 9", 80000));
        productList.add(new Product(1234L, "IPhone 10", 90000));
        productList.add(new Product(1234L, "IPhone 11", 100000));
        productList.add(new Product(1234L, "IPhone 12", 110000));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("get request");
        request.setAttribute("product", list);
        request.getRequestDispatcher("product.jsp").forward(request, response);
    }
}


