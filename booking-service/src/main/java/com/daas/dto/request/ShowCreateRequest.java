package com.daas.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShowCreateRequest {
    private String title;
    private String location;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int numberOfSeats;
}
