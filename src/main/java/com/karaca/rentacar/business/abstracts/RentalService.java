package com.karaca.rentacar.business.abstracts;

import com.karaca.rentacar.business.dto.requests.create.CreateRentalRequest;
import com.karaca.rentacar.business.dto.requests.update.UpdateRentalRequest;
import com.karaca.rentacar.business.dto.responses.create.CreateRentalResponse;
import com.karaca.rentacar.business.dto.responses.get.Rental.GetAllRentalsResponse;
import com.karaca.rentacar.business.dto.responses.get.Rental.GetRentalResponse;
import com.karaca.rentacar.business.dto.responses.get.Rental.RentalsResponse;
import com.karaca.rentacar.business.dto.responses.update.UpdateRentalResponse;

import java.util.List;

public interface RentalService
{
    List<GetAllRentalsResponse> getAll();
    GetRentalResponse getById(int id);
    CreateRentalResponse add(CreateRentalRequest request);
    UpdateRentalResponse update(int id, UpdateRentalRequest request);
    void delete(int id);
    GetRentalResponse findByTotalPrice(Float totalPrice);
    List<GetAllRentalsResponse> findAllOrderByDailyPriceDesc();
    GetRentalResponse findByDailyPrice(Float dailyPrice);
    List<GetAllRentalsResponse> findAllThanDailyPrice(Float dailyPrice);
    List<GetAllRentalsResponse> findAllOrderByTotalPriceASC();
    RentalsResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
}
