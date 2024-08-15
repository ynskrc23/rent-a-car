package com.karaca.rentacar.business.dto.responses.get.Car;

import com.karaca.rentacar.entities.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllCarsResponse
{
    private int id;
    private int modelId;
    private double dailyPrice;
    private int modelYear;
    private String plate;
    private State state;
    private String modelName;
    private String modelBrandName;
    private Date createdAt;
    private Date updatedAt;
}
