package com.ead.finalproject.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingDTO {

    @NotNull
    private Long userId;

    @NotNull
    private Long tourId;

    @Min(1)
    private int numberOfPeople;

    // Assuming BookingStatus is a string, adjust accordingly if it's an enum
    @NotNull
    private String bookingStatus;

    @NotNull
    private LocalDateTime bookingDateTime;



}
