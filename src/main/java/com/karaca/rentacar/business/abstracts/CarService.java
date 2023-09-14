package com.karaca.rentacar.business.abstracts;

import com.karaca.rentacar.entities.concretes.Car;
import com.karaca.rentacar.entities.enums.State;
import com.karaca.rentacar.business.dto.requests.create.CreateCarRequest;
import com.karaca.rentacar.business.dto.requests.update.UpdateCarRequest;
import com.karaca.rentacar.business.dto.responses.create.CreateCarResponse;
import com.karaca.rentacar.business.dto.responses.get.Car.GetAllCarsResponse;
import com.karaca.rentacar.business.dto.responses.get.Car.GetCarResponse;
import com.karaca.rentacar.business.dto.responses.get.Maintenance.GetAllMaintenanceResponse;
import com.karaca.rentacar.business.dto.responses.update.UpdateCarResponse;

import java.util.List;

public interface CarService {
    List<GetAllCarsResponse> getAll(boolean includeMaintenance);

    GetCarResponse getById(int id);

    CreateCarResponse add(CreateCarRequest request);

    UpdateCarResponse update(int id, UpdateCarRequest request);

    void delete(int id);

    public void changeState(int carId, State state);

    List<GetAllMaintenanceResponse> showMaintenances(int id);

    List<GetAllCarsResponse> findByDailyPriceGreaterThanEqual(float price);
    List<GetAllCarsResponse> findByModelYearBetween(int my1, int my2);
    GetCarResponse findByPlateOrNameJPQLIndexParam(String plate, String name);
    GetCarResponse findByPlateOrModelYearSQLIndexParam(String plate, int modelYear);

    //@Configuration
    //@Service
    //@Repository
    //@Component

    // @Bean -- method
}
