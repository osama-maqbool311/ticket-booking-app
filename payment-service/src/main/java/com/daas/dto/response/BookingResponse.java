package com.daas.dto.response;

import com.daas.enums.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponse {
    private Long id;
    private String email;
    private String mobile;
    private Long showId;
    private Integer seatCount;
    private BookingStatus status;
    private LocalDateTime bookingTime;
    private List<Long> seatIds;
}