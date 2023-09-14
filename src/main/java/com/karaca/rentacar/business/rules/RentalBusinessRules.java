package com.karaca.rentacar.business.rules;

import com.karaca.rentacar.entities.enums.State;
import com.karaca.rentacar.repository.abstracts.RentalRepository;
import com.karaca.rentacar.common.constants.Messages;
import com.karaca.rentacar.core.exceptions.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RentalBusinessRules {
    private final RentalRepository repository;

    // Business rules
    public void checkIfRentalExists(int id) {
        if (!repository.existsById(id))
            throw new BusinessException(Messages.Rental.NotExists);
    }

    public void checkIfCarAvailable(State state) {
        if (!state.equals(State.AVAILABLE)) {
            throw new BusinessException(Messages.Car.NotAvailable);
        }

    }
}
