package com.karaca.rentacar.business.dto.responses.get.Reports;

import com.karaca.rentacar.business.dto.responses.get.Brand.GetAllBrandsResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllModelReportsResponse {
    private String name;
    private GetAllBrandReportsResponse brand;
}
