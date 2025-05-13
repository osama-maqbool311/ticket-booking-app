package com.daas.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequest {
       private String email;
       private String mobile;
       private Long showId;
       private List<Long> seatIds;
}
