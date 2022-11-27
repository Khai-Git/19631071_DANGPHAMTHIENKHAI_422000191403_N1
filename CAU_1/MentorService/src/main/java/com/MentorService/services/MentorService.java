package com.example.productservice.services;

import com.example.productservice.entities.Mentor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MentorService {
    void createProduct(Product product);

    List<Mentor> getAllProducts();

    Mentor getProductById(Long id);

    List<Mentor> getAllProductsByStrength(String strength);

    List<Mentor> getAllProductsByName(String name);

    List<Mentor> getAllProductsByAddress(String address);
}
