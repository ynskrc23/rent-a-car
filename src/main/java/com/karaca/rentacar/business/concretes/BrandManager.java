package com.karaca.rentacar.business.concretes;

import com.karaca.rentacar.entities.concretes.Brand;
import com.karaca.rentacar.repository.abstracts.BrandRepository;
import com.karaca.rentacar.business.abstracts.BrandService;
import com.karaca.rentacar.business.dto.requests.create.CreateBrandRequest;
import com.karaca.rentacar.business.dto.requests.update.UpdateBrandRequest;
import com.karaca.rentacar.business.dto.responses.create.CreateBrandResponse;
import com.karaca.rentacar.business.dto.responses.get.Brand.GetAllBrandsResponse;
import com.karaca.rentacar.business.dto.responses.get.Brand.GetBrandResponse;
import com.karaca.rentacar.business.dto.responses.get.Model.GetAllModelsResponse;
import com.karaca.rentacar.business.dto.responses.update.UpdateBrandResponse;
import com.karaca.rentacar.business.rules.BrandBusinessRules;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private final BrandRepository repository;
    private final ModelMapper mapper;
    private final BrandBusinessRules rules;

    @Override
    @Cacheable(value = "brand_list")
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = repository.findAll();
        return brands.stream().map(brand -> mapper.map(brand, GetAllBrandsResponse.class)).toList();
    }

    @Override
    public GetBrandResponse getById(int id) {
        rules.checkIfBrandExists(id);
        Brand brand = repository.findById(id).orElseThrow();
        return mapper.map(brand, GetBrandResponse.class);
    }

    @Override
    @CacheEvict(value = "brand_list", allEntries = true)
    public CreateBrandResponse add(CreateBrandRequest request) {
        rules.checkIfBrandExistsByName(request.getName());
        Brand brand = mapper.map(request, Brand.class);
        brand.setId(0);
        repository.save(brand);
        return mapper.map(brand, CreateBrandResponse.class);
    }

    @Override
    public UpdateBrandResponse update(int id, UpdateBrandRequest request) {
        rules.checkIfBrandExists(id);
        Brand brand = mapper.map(request, Brand.class);
        brand.setId(id);
        repository.save(brand);
        return mapper.map(brand, UpdateBrandResponse.class);
    }

    @Override
    public void delete(int id) {
        rules.checkIfBrandExists(id);
        repository.deleteById(id);
    }

    @Override
    public List<GetAllModelsResponse> showModels(int id) {
        Brand brand = repository.findById(id).orElseThrow();
        return brand.getModels().stream().map(model -> mapper.map(model, GetAllModelsResponse.class)).toList();
    }

    @Override
    public GetBrandResponse findByName(String name) {
        Brand brand = repository.findByName(name);
        return mapper.map(brand, GetBrandResponse.class);
    }

    @Override
    public List<GetAllBrandsResponse> findByNameContaining(String name) {
        List<Brand> brands = repository.findByNameContaining(name);
        return brands.stream().map(brand -> mapper.map(brand, GetAllBrandsResponse.class)).toList();
    }
}