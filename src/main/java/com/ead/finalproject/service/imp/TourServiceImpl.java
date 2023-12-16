package com.ead.finalproject.service.imp;

import com.ead.finalproject.DTO.TourDTO;
import com.ead.finalproject.exception.DuplicateResourceException;
import com.ead.finalproject.exception.ResourceNotFoundException;
import com.ead.finalproject.exception.ValidationException;
import com.ead.finalproject.model.Tour;
import com.ead.finalproject.repository.TourRepo;
import com.ead.finalproject.service.TourService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TourServiceImpl implements TourService {


    private final TourRepo tourRepo;

    public TourServiceImpl(TourRepo tourRepo) {
        this.tourRepo = tourRepo;
    }
    @Override
    public List<TourDTO> getAllTours() {
        List<Tour> tours = tourRepo.findAll();
        List<TourDTO> tourDTOList = new ArrayList<>();

        for (Tour tour : tours) {
            TourDTO tourDTO = new TourDTO();
            tourDTO.setId(tour.getId());
            tourDTO.setTourName(tour.getTourName());
            tourDTO.setDescription(tour.getDescription());
            tourDTO.setTourType(tour.getTourType());
            tourDTO.setDurationInDays(tour.getDurationInDays());
            tourDTO.setPrice(tour.getPrice());
            tourDTO.setStartDate(tour.getStartDate());
            tourDTO.setCreatedAt(tour.getCreatedAt());
            tourDTO.setModifiedAt(tour.getModifiedAt());
            tourDTO.setUrl(tour.getUrl());

            tourDTOList.add(tourDTO);
        }

        return tourDTOList;
    }




    @Override
    public TourDTO getTourById(long id) {
        Tour tour = tourRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("tour", "id", id));

        TourDTO tourDTO = new TourDTO();
        tourDTO.setId(tour.getId());
        tourDTO.setTourName(tour.getTourName());
        tourDTO.setDescription(tour.getDescription());
        tourDTO.setTourType(tour.getTourType());
        tourDTO.setDurationInDays(tour.getDurationInDays());
        tourDTO.setPrice(tour.getPrice());
        tourDTO.setStartDate(tour.getStartDate());
        tourDTO.setCreatedAt(tour.getCreatedAt());
        tourDTO.setModifiedAt(tour.getModifiedAt());
        tourDTO.setUrl(tour.getUrl());

        return tourDTO;
    }


    @Override
    public TourDTO createTour(TourDTO tourDTO) {

//        if (isTourAlreadyExists(tourDTO.getTourName())) {
//            throw new DuplicateResourceException("Tour", "tourName", tourDTO.getTourName());
//        }

        Tour tour = new Tour();
        tour.setTourName(tourDTO.getTourName());
        tour.setDescription(tourDTO.getDescription());
        tour.setTourType(tourDTO.getTourType());
        tour.setDurationInDays(tourDTO.getDurationInDays());
        tour.setPrice(tourDTO.getPrice());
        tour.setStartDate(tourDTO.getStartDate());
        tour.setCreatedAt(LocalDateTime.now());
        tour.setUrl(tourDTO.getUrl());

        tourRepo.save(tour);

        tourDTO.setId(tour.getId());
        return tourDTO;
    }



    @Override
    public TourDTO updateTour(long id, TourDTO tourDTO) {
        Tour existingTour = tourRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("tour", "id", id));

        // Update the existing tour with the new data
        existingTour.setTourName(tourDTO.getTourName());
        existingTour.setDescription(tourDTO.getDescription());
        existingTour.setTourType(tourDTO.getTourType());
        existingTour.setDurationInDays(tourDTO.getDurationInDays());
        existingTour.setPrice(tourDTO.getPrice());
        existingTour.setStartDate(tourDTO.getStartDate());
        existingTour.setModifiedAt(LocalDateTime.now());
        existingTour.setUrl(tourDTO.getUrl());

        // Save the updated tour
        Tour updatedTour = tourRepo.save(existingTour);

        // Convert the updatedTour to TourDTO and return it if needed.
        TourDTO updatedTourDTO = new TourDTO();
        updatedTourDTO.setId(updatedTour.getId());
        updatedTourDTO.setTourName(updatedTour.getTourName());
        updatedTourDTO.setDescription(updatedTour.getDescription());
        updatedTourDTO.setTourType(updatedTour.getTourType());
        updatedTourDTO.setDurationInDays(updatedTour.getDurationInDays());
        updatedTourDTO.setPrice(updatedTour.getPrice());
        updatedTourDTO.setStartDate(updatedTour.getStartDate());
        updatedTourDTO.setCreatedAt(updatedTour.getCreatedAt());
        updatedTourDTO.setModifiedAt(updatedTour.getModifiedAt());
        updatedTourDTO.setUrl(updatedTour.getUrl());

        return updatedTourDTO;
    }

    @Override
    public void deleteTour(long id) {
        Tour existingTour = tourRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("tour", "id", id));

        // You can add any logic for cascading deletes if needed.

        tourRepo.delete(existingTour);
    }


    @Override
    public Page<TourDTO> getAllTours(Pageable pageable) {
        return null;
    }

    @Override
    public Page<TourDTO> searchTours(String keyword, Pageable pageable) {
        return null;
    }
}
