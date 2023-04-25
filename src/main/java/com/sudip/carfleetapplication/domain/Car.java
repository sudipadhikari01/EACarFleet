package com.sudip.carfleetapplication.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Car {
    @Id
    private String licensePlate;
    private String carType;
    private String brand;
    private double price;
    private boolean isAvailable;
}
