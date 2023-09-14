package com.karaca.rentacar.business.rules;

import com.karaca.rentacar.entities.enums.State;
import com.karaca.rentacar.repository.abstracts.MaintenanceRepository;
import com.karaca.rentacar.common.constants.Messages;
import com.karaca.rentacar.core.exceptions.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MaintenanceBusinessRules {
    private final MaintenanceRepository repository;
    // Business rules

    public void checkIfMaintenanceExist(int id) {
        if (!repository.existsById(id)) throw new BusinessException(Messages.Maintenance.NotExists);
    }


    public void checkIfCarUnderMaintenance(int carId) {
        if (repository.existsByCarIdAndIsCompletedFalse(carId)) {
            throw new BusinessException(Messages.Maintenance.CarExists);
        }

    }

    public void checkIfCarIsNotUnderMaintenance(int carId) {
        if (!repository.existsByCarIdAndIsCompletedFalse(carId)) {
            throw new BusinessException(Messages.Maintenance.CarNotExists);
        }
    }

    public void checkCarAvailabilityForMaintenance(State state) {
        if (state.equals(State.RENTED)) {
            throw new BusinessException(Messages.Maintenance.CarIsRented);
        }
    }
}
