package com.karaca.rentacar.api.controllers;


import com.karaca.rentacar.business.abstracts.RentalService;
import com.karaca.rentacar.business.dto.requests.create.CreateRentalRequest;
import com.karaca.rentacar.business.dto.requests.update.UpdateRentalRequest;
import com.karaca.rentacar.business.dto.responses.create.CreateRentalResponse;
import com.karaca.rentacar.business.dto.responses.get.Rental.GetAllRentalsResponse;
import com.karaca.rentacar.business.dto.responses.get.Rental.GetRentalResponse;
import com.karaca.rentacar.business.dto.responses.get.Rental.RentalsResponse;
import com.karaca.rentacar.business.dto.responses.update.UpdateRentalResponse;
import com.karaca.rentacar.core.utils.results.AppConstants;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/rentals")
public class RentalsController {
    private final RentalService service;

    @GetMapping
    public List<GetAllRentalsResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetRentalResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateRentalResponse add(@RequestBody CreateRentalRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateRentalResponse update(@PathVariable int id, @RequestBody UpdateRentalRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @GetMapping("/findByTotalPrice")
    public GetRentalResponse findByTotalPrice(@RequestParam("totalPrice") Float totalPrice) {
        return service.findByTotalPrice(totalPrice);
    }

    @GetMapping("/findAllOrderByDailyPriceDesc")
    public List<GetAllRentalsResponse> findAllOrderByDailyPriceDesc() {
        return service.findAllOrderByDailyPriceDesc();
    }

    @GetMapping("/findByDailyPrice")
    public GetRentalResponse findByDailyPrice(@RequestParam("dailyPrice") Float dailyPrice) {
        return service.findByDailyPrice(dailyPrice);
    }

    @GetMapping("/findAllThanDailyPrice")
    public List<GetAllRentalsResponse> findAllThanDailyPrice(@RequestParam("dailyPrice") Float dailyPrice) {
        return service.findAllThanDailyPrice(dailyPrice);
    }

    @GetMapping("/findAllOrderByTotalPriceASC")
    public List<GetAllRentalsResponse> findAllOrderByTotalPriceASC() {
        return service.findAllOrderByTotalPriceASC();
    }

    @GetMapping("/getAllRentals")
    public RentalsResponse getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ){
        return service.getAllPosts(pageNo, pageSize, sortBy, sortDir);
    }
}