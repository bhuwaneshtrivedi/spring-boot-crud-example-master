package com.javatechie.crud.example.repository;

import com.javatechie.crud.example.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;


@Repository
public class ProductRepository {
    private List<Product> list = new ArrayList<Product>();

    public void createProducts() {
        list = List.of(
                new Product(1, "product 1", 10,1000.00),
                new Product(2, "product 2", 20, 2000),
                new Product(3, "product 3", 30, 3000)
        );
    }

    public List<Product> getAllProducts() {
        return list;
    }

    public Product findById(int id){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == (id)) {
                return list.get(i);
            }
        }
        return null;
    }

    public List<Product> search(String name) {
        return list.stream().filter(x -> x.getName().startsWith(name)).collect(Collectors.toList());
    }

    public Product save(Product p) {
        Product product = new Product(0, null, 0, 0);
        product.setId(p.getId());
        product.setName(p.getName());
        product.setQuantity(p.getQuantity());
        product.setPrice(p.getPrice());
        list.add(product);
        return product;
    }

    public String delete(Integer id) {
        list.removeIf(x -> x.getId() == (id));
        return null;
    }

    public Product update(Product product) {
        int idx = 0;
        int id = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == (product.getId())) {
                id = product.getId();
                idx = i;
                break;
            }
        }

        Product product1 = new Product(id, null, id, id);
        product1.setId(id);
        product1.setName(product.getName());
        product1.setQuantity(product.getQuantity());
        product1.setPrice(product.getPrice());
        list.set(idx, product);
        return product1;
    }
}

