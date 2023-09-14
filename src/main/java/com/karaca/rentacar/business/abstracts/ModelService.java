package com.karaca.rentacar.business.abstracts;

import com.karaca.rentacar.business.dto.requests.create.CreateModelRequest;
import com.karaca.rentacar.business.dto.requests.update.UpdateModelRequest;
import com.karaca.rentacar.business.dto.responses.create.CreateModelResponse;
import com.karaca.rentacar.business.dto.responses.get.Car.GetAllCarsResponse;
import com.karaca.rentacar.business.dto.responses.get.Model.GetAllModelsResponse;
import com.karaca.rentacar.business.dto.responses.get.Model.GetModelResponse;
import com.karaca.rentacar.business.dto.responses.update.UpdateModelResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();

    GetModelResponse getById(int id);

    CreateModelResponse add(CreateModelRequest request);

    UpdateModelResponse update(int id, UpdateModelRequest request);

    void delete(int id);

    List<GetAllCarsResponse> showCars(int id);

    //@Configuration
    //@Service
    //@Repository
    //@Component

    // @Bean -- method
}
