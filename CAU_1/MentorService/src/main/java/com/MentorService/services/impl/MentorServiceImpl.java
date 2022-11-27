package com.example.productservice.services.impl;

import com.example.productservice.entities.Mentor;
import com.example.productservice.repositories.mentorRepository;
import com.example.productservice.services.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MentorServiceImpl implements MentorService {
    @Autowired
    private MentorRepository mentorRepository;

    @Override
    public void createProduct(Mentor mentor) {
        mentorRepository.save(product);
    }

    @Override
    public List<Mentor> getAllMentors() {
        return mentorRepository.findAll();
    }

    @Override
    public Mentor getProductById(Long id) {
        return mentorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Mentor> getAllProductsByWeight(String weight) {
        return mentorRepository.findAllByWeight(weight);
    }

    @Override
    public List<Mentor> getAllProductsByVName(String name) {
        return mentorRepository.findAllByname(name);
    }

    @Override
    public List<Mentor> getAllProductsByAddress(String address) {
        return mentorRepository.findAllByAddress(address);
    }

}
