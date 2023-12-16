package com.ead.finalproject.config;

import com.ead.finalproject.model.Tour;
import com.ead.finalproject.model.TourType;
import com.ead.finalproject.repository.TourRepo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;


//@Component
public class DataLoader implements CommandLineRunner {

    private final TourRepo repository;
    private final ObjectMapper objectMapper;

    public DataLoader(TourRepo repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("DataLoader run method is called");
        if(repository.count() == 0) {
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/tours.json")) {
                List<Tour> tours = objectMapper.readValue(inputStream,new TypeReference<List<Tour>>(){});
                System.out.println("Загружено контента: " + tours.size());
                repository.saveAll(tours);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



}