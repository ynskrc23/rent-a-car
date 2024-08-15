package com.karaca.rentacar.repository.abstracts;

import com.karaca.rentacar.entities.concretes.Car;
import com.karaca.rentacar.entities.enums.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CarRepository extends JpaRepository<Car, Integer>
{
    List<Car> findAllByStateIsNot(State state);
    List<Car> findByDailyPriceGreaterThanEqual(float price);
    List<Car> findByModelYearBetween(int my1, int my2);
    // Define JPQL query using @Query annotation with index or position parameters
    @Query("SELECT p from Car p where p.plate = ?1 or p.model.name = ?2")
    Car findByPlateOrNameJPQLIndexParam(String plate, String name);
    // Define Native SQL query using @Query annotation with index or position parameters
    @Query(value = "select * from cars c where c.plate = ?1 or c.model_year = ?2", nativeQuery = true)
    Car findByPlateOrModelYearSQLIndexParam(String plate, int modelYear);
    @Query(value = "SELECT * FROM cars c WHERE c.model_id = :modelId", nativeQuery = true)
    List<Car> carReportsModelId(int modelId);
}
