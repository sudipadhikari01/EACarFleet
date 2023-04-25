package com.sudip.carfleetapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {

    private String licensePlate;
    private String carType;
    private String brand;
    private double price;
    private boolean isAvailable;
}
