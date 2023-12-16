package com.ead.finalproject.controller;

import com.ead.finalproject.DTO.TourDTO;
import com.ead.finalproject.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tour")
public class TourController {

    @Autowired
    private TourService tourService;

    @GetMapping("/{id}")
    public ResponseEntity<TourDTO> getTour(@PathVariable("id") long tourId) {
        return ResponseEntity.ok(tourService.getTourById(tourId));
    }

    @GetMapping
    public ResponseEntity<List<TourDTO>> getAllTours() {
        List<TourDTO> tourDTOList = tourService.getAllTours();
        return ResponseEntity.ok(tourDTOList);
    }

    @PostMapping("/create")
    public ResponseEntity<TourDTO> createTour(@RequestBody TourDTO tourDTO) {
        TourDTO createdTourDTO = tourService.createTour(tourDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTourDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TourDTO> updateTour(@PathVariable("id") long tourId, @RequestBody TourDTO tourDTO) {
        TourDTO updatedTourDTO = tourService.updateTour(tourId, tourDTO);
        return ResponseEntity.ok(updatedTourDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTour(@PathVariable("id") long tourId) {
        tourService.deleteTour(tourId);
        return ResponseEntity.noContent().build();
    }
}
