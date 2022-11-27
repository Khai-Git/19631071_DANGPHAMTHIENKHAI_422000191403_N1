package com.MentorService.MentorServicee.controllers;

import com.MentorService.MentorService.entities.Mentor;
import com.MentorService.MentorService.services.mentorservice;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/mentors")
public class mentorController {
    @Autowired
    private MentorService mentorservice;

    @GetMapping(value = {"/{id}"})
    @Cacheable(value = "mentor", key = "#id")
    @Retry(name = "mentor", fallbackMethod = "getMentorFallback")
    @CircuitBreaker(name = "mentor", fallbackMethod = "getMentorFallback")
    @RateLimiter(name = "mentor")
    public Mentor getmentorById(@PathVariable Long id) {
        return mentorservice.getmentorById(id);
    }

    @GetMapping(value = {"", "/"})
    public List<Mentor> getAllmentors() {
        return mentorservice.getAllmentors();
    }

    @GetMapping(value = {"/weight/{weight}", "/weight/{weight}/"})
    @Cacheable(value = "mentor", key = "#weight")
    public List<Mentor> getmentorsByWeight(@PathVariable String weight) {
        return mentorservice.getAllmentorsByWeight(mentorweight.valueOf(weight.toUpperCase()));
    }

    @GetMapping(value = {"/name/{name}", "/name/{name}/"})
    @Cacheable(value = "mentor", key = "#name")
    public List<Mentor> getmentorsByName(@PathVariable String name) {
        return mentorservice.getAllmentorsByName(name);
    }

    @GetMapping(value = {"/address/{address}", "/address/{address}/"})
    @Cacheable(value = "mentor", key = "#address")
    public List<Mentor> getmentorByAddress(@PathVariable String address) {
        return mentorservice.getAllmentorsByAddress(mentorAddress.valueOf(address.toUpperCase()));
    }

    @PostMapping(value = {"", "/"})
    @Retry(name = "mentor-service", fallbackMethod = "addmentorFallback")
    public void addmentor(@RequestBody mentor mentor) {
        mentorservice.creatementor(mentor);
    }

    public Mentor addmentorFallback(Exception e) {
        System.out.println("addmentorFallback called");
        return null;
    }

    public Mentor getmentorFallback(Exception e) {
        System.out.println("getmentorFallback called");
        return null;
    }
}
