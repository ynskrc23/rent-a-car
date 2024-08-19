package com.karaca.rentacar.business.dto.responses.get.Rental;

import com.karaca.rentacar.business.dto.responses.get.Car.GetAllCarsResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllRentalsResponse
{
    private int id;
    private int carId;
    private int rentedForDays;
    private double dailyPrice;
    private double totalPrice;
    private LocalDateTime startDate;
    private GetAllCarsResponse car;
    private Date createdAt;
    private Date updatedAt;
}
