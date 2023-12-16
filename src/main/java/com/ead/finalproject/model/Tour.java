package com.ead.finalproject.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tour")
public class Tour{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
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

}

