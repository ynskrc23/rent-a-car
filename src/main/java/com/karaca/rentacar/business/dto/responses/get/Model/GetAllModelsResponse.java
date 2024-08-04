package com.karaca.rentacar.business.dto.responses.get.Model;

import com.karaca.rentacar.business.dto.responses.get.Brand.GetAllBrandsResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllModelsResponse
{
    private int id;
    private int brandId;
    private String name;
    private GetAllBrandsResponse brand;
    private Date createdAt;
    private Date updatedAt;
}
