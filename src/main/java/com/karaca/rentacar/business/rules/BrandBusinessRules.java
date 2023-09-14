package com.karaca.rentacar.business.rules;

import com.karaca.rentacar.repository.abstracts.BrandRepository;
import com.karaca.rentacar.common.constants.Messages;
import com.karaca.rentacar.core.exceptions.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandBusinessRules {
    private final BrandRepository repository;

    // Business rules
    public void checkIfBrandExists(int id) {
        if (!repository.existsById(id)) throw new BusinessException(Messages.Brand.NotExists);
    }

    public void checkIfBrandExistsByName(String name) {
        if (repository.existsByNameIgnoreCase(name)) throw new BusinessException(Messages.Brand.Exists);
    }
}
