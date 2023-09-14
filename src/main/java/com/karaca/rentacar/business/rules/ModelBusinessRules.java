package com.karaca.rentacar.business.rules;

import com.karaca.rentacar.repository.abstracts.ModelRepository;
import com.karaca.rentacar.common.constants.Messages;
import com.karaca.rentacar.core.exceptions.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelBusinessRules {
    private final ModelRepository repository;

    // Business rules
    public void checkIfModelExists(int id) {
        if (!repository.existsById(id)) throw new BusinessException(Messages.Model.NotExists);
    }

    public void checkIfModelExistsByName(String name) {
        if (repository.existsByNameIgnoreCase(name)) throw new BusinessException(Messages.Model.Exists);
    }
}
