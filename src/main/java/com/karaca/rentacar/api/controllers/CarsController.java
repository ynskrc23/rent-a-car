package com.karaca.rentacar.api.controllers;

import com.karaca.rentacar.business.abstracts.CarService;
import com.karaca.rentacar.business.dto.requests.create.CreateCarRequest;
import com.karaca.rentacar.business.dto.requests.update.UpdateCarRequest;
import com.karaca.rentacar.business.dto.responses.create.CreateCarResponse;
import com.karaca.rentacar.business.dto.responses.get.Car.GetAllCarsResponse;
import com.karaca.rentacar.business.dto.responses.get.Reports.GetAllCarReportsResponse;
import com.karaca.rentacar.business.dto.responses.get.Car.GetCarResponse;
import com.karaca.rentacar.business.dto.responses.get.Maintenance.GetAllMaintenanceResponse;
import com.karaca.rentacar.business.dto.responses.update.UpdateCarResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cars")
public class CarsController
{
    private final CarService service;

    @GetMapping
    public List<GetAllCarsResponse> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetCarResponse getById(@PathVariable int id)
    {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCarResponse add(@Valid @RequestBody CreateCarRequest request)
    {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateCarResponse update(@PathVariable int id, @Valid @RequestBody UpdateCarRequest request)
    {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id)
    {
        service.delete(id);
    }

    @GetMapping("/maintenances-of-{id}")
    public List<GetAllMaintenanceResponse> getModels(@PathVariable int id)
    {
        return service.showMaintenances(id);
    }

    @GetMapping("/findByDailyPriceGreaterThanEqual/{price}")
    public List<GetAllCarsResponse> findByDailyPriceGreaterThanEqual(@PathVariable float price)
    {
        return service.findByDailyPriceGreaterThanEqual(price);
    }

    @GetMapping("/findByModelYearBetween")
    public List<GetAllCarsResponse> findByModelYearBetween(@RequestParam("my1") int my1, @RequestParam("my2") int my2)
    {
        return service.findByModelYearBetween(my1, my2);
    }

    @GetMapping("/findByPlateOrNameJPQLIndexParam")
    public GetCarResponse findByPlateOrNameJPQLIndexParam(@RequestParam("plate") String plate, @RequestParam("name") String name)
    {
        return service.findByPlateOrNameJPQLIndexParam(plate,name);
    }

    @GetMapping("/findByPlateOrModelYearSQLIndexParam")
    public GetCarResponse findByPlateOrModelYearSQLIndexParam(@RequestParam("plate") String plate, @RequestParam("modelYear") int modelYear)
    {
        return service.findByPlateOrModelYearSQLIndexParam(plate,modelYear);
    }

    @GetMapping("/carReportsModelId")
    public List<GetAllCarReportsResponse> carReportsModelId(@RequestParam("modelId") int modelId)
    {
        return service.carReportsModelId(modelId);
    }
}
