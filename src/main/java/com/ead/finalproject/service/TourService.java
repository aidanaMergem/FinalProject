package com.ead.finalproject.service;

import com.ead.finalproject.DTO.TourDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TourService {
    List<TourDTO> getAllTours();

    TourDTO getTourById(long tourId);

    TourDTO createTour(TourDTO tourDTO);

    TourDTO updateTour(long tourId, TourDTO tourDTO);

    void deleteTour(long tourId);

    Page<TourDTO> getAllTours(Pageable pageable);

    Page<TourDTO> searchTours(String keyword, Pageable pageable);
}
