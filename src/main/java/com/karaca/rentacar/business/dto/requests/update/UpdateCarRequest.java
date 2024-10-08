package com.karaca.rentacar.business.dto.requests.update;

import com.karaca.rentacar.entities.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateCarRequest
{
    private int modelId;
    private double dailyPrice;
    private int modelYear;
    private String plate;
    private State state;
}