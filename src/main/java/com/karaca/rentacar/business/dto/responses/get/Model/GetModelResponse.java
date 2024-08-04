package com.karaca.rentacar.business.dto.responses.get.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetModelResponse {
    private int id;
    private int brandId;
    private String name;
    private Date createdAt;
    private Date updatedAt;
}

