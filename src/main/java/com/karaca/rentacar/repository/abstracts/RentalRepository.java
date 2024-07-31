package com.karaca.rentacar.repository.abstracts;

import com.karaca.rentacar.entities.concretes.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
    // Define Named JPQL query
    Rental findByTotalPrice(@Param("totalPrice") Float totalPrice);
    List<Rental> findAllOrderByDailyPriceDesc();

    // Define Named native SQL query
    @Query(nativeQuery = true)
    Rental findByDailyPrice(@Param("dailyPrice") Float dailyPrice);
    List<Rental> findAllThanDailyPrice(@Param("dailyPrice") Float dailyPrice);
    List<Rental> findAllOrderByTotalPriceASC();
}
