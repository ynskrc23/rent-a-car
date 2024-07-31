package com.karaca.rentacar.business.dto.responses.get.Reports;

import com.karaca.rentacar.entities.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllCarReportsResponse {
    private int id;
    private double dailyPrice;
    private int modelYear;
    private String plate;
    private State state;
    private GetAllModelReportsResponse model;
}
