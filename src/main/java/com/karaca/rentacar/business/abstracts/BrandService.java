package com.karaca.rentacar.business.abstracts;

import com.karaca.rentacar.business.dto.requests.create.CreateBrandRequest;
import com.karaca.rentacar.business.dto.requests.update.UpdateBrandRequest;
import com.karaca.rentacar.business.dto.responses.create.CreateBrandResponse;
import com.karaca.rentacar.business.dto.responses.get.Brand.GetAllBrandsResponse;
import com.karaca.rentacar.business.dto.responses.get.Brand.GetBrandResponse;
import com.karaca.rentacar.business.dto.responses.get.Model.GetAllModelsResponse;
import com.karaca.rentacar.business.dto.responses.update.UpdateBrandResponse;

import java.util.List;

public interface BrandService
{
    List<GetAllBrandsResponse> getAll();
    GetBrandResponse getById(int id);
    CreateBrandResponse add(CreateBrandRequest request);
    UpdateBrandResponse update(int id, UpdateBrandRequest request);
    void delete(int id);
    List<GetAllModelsResponse> showModels(int id);
    GetBrandResponse findByName(String name);
    List<GetAllBrandsResponse> findByNameContaining(String name);
}


