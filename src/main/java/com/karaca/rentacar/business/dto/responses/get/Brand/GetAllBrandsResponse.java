package com.karaca.rentacar.business.dto.responses.get.Brand;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllBrandsResponse
{
    private int id;
    private String name;
    private Date createdAt;
    private Date updatedAt;
}
