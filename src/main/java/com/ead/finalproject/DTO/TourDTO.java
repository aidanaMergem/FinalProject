package com.ead.finalproject.DTO;

import com.ead.finalproject.model.TourType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TourDTO {
    private long id;
    private String tourName;
    private String description;
    private TourType tourType;
    private int durationInDays;
    private Double price;
    private LocalDate startDate;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String url;

    public TourDTO(String tourName, String description, TourType tourType, int durationInDays, Double price, LocalDate startDate,  String url) {
        this.tourName = tourName;
        this.description = description;
        this.tourType = tourType;
        this.durationInDays = durationInDays;
        this.price = price;
        this.startDate = startDate;
        this.url = url;
    }
}
