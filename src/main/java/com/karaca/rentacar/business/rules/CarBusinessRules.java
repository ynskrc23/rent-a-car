package com.karaca.rentacar.business.rules;

import com.karaca.rentacar.repository.abstracts.CarRepository;
import com.karaca.rentacar.common.constants.Messages;
import com.karaca.rentacar.core.exceptions.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarBusinessRules {
    private final CarRepository repository;

    // Business rules
    public void checkIfCarExists(int id) {
        if (!repository.existsById(id)) throw new BusinessException(Messages.Car.NotExists);
    }
}
