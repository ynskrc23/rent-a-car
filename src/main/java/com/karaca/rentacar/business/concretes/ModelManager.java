package com.karaca.rentacar.business.concretes;

import com.karaca.rentacar.entities.concretes.Brand;
import com.karaca.rentacar.entities.concretes.Model;
import com.karaca.rentacar.repository.abstracts.ModelRepository;
import com.karaca.rentacar.business.abstracts.ModelService;
import com.karaca.rentacar.business.dto.requests.create.CreateModelRequest;
import com.karaca.rentacar.business.dto.requests.update.UpdateModelRequest;
import com.karaca.rentacar.business.dto.responses.create.CreateModelResponse;
import com.karaca.rentacar.business.dto.responses.get.Car.GetAllCarsResponse;
import com.karaca.rentacar.business.dto.responses.get.Model.GetAllModelsResponse;
import com.karaca.rentacar.business.dto.responses.get.Model.GetModelResponse;
import com.karaca.rentacar.business.dto.responses.update.UpdateModelResponse;
import com.karaca.rentacar.business.rules.ModelBusinessRules;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class ModelManager implements ModelService
{
    private final ModelRepository repository;
    private final ModelMapper mapper;
    private final ModelBusinessRules rules;

    @Override
    public List<GetAllModelsResponse> getAll()
    {
        List<Model> models = repository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        return models
                .stream()
                .map(model -> mapper.map(model, GetAllModelsResponse.class))
                .toList();
    }

    @Override
    public GetModelResponse getById(int id)
    {
        rules.checkIfModelExists(id);
        Model model = repository.findById(id).orElseThrow();
        return mapper.map(model, GetModelResponse.class);
    }

    @Override
    public CreateModelResponse add(CreateModelRequest request)
    {
        rules.checkIfModelExistsByName(request.getName());
        Model model = mapper.map(request, Model.class);
        model.setId(0);
        repository.save(model);
        return mapper.map(model, CreateModelResponse.class);
    }

    @Override
    public UpdateModelResponse update(int id, UpdateModelRequest request)
    {
        rules.checkIfModelExists(id);
        Model model = mapper.map(request, Model.class);
        model.setId(id);
        repository.save(model);
        return mapper.map(model, UpdateModelResponse.class);

    }


    @Override
    public void delete(int id)
    {
        rules.checkIfModelExists(id);
        repository.deleteById(id);
    }

    @Override
    public List<GetAllCarsResponse> showCars(int id)
    {
        Model model = repository.findById(id).orElseThrow();
        return model.getCars().stream()
                .map(car -> mapper.map(car, GetAllCarsResponse.class)).toList();
    }
}
