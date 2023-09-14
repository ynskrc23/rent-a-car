package com.karaca.rentacar.business.abstracts;

import com.karaca.rentacar.business.dto.requests.create.CreateMaintenanceRequest;
import com.karaca.rentacar.business.dto.requests.update.UpdateMaintenanceRequest;
import com.karaca.rentacar.business.dto.responses.create.CreateMaintenanceResponse;
import com.karaca.rentacar.business.dto.responses.get.Maintenance.GetAllMaintenanceResponse;
import com.karaca.rentacar.business.dto.responses.get.Maintenance.GetMaintenanceResponse;
import com.karaca.rentacar.business.dto.responses.update.UpdateMaintenanceResponse;

import java.util.List;

public interface MaintenanceService {
    List<GetAllMaintenanceResponse> getAll();

    GetMaintenanceResponse getById(int id);

    GetMaintenanceResponse returnCarFromMaintenance(int carId);

    CreateMaintenanceResponse add(CreateMaintenanceRequest request);

    UpdateMaintenanceResponse update(int id, UpdateMaintenanceRequest request);

    void delete(int id);

}