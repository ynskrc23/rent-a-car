package com.karaca.rentacar.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "rentals")

@NamedQueries(
    {
        @NamedQuery(
                name = "Rental.findAllOrderByDailyPriceDesc",
                query = "SELECT r from Rental r ORDER By r.dailyPrice DESC"
        ),
        @NamedQuery(
                name = "Rental.findByTotalPrice",
                query = "SELECT r from Rental r where r.totalPrice = :totalPrice"
        )
    }
)

@NamedNativeQueries(
    {
        @NamedNativeQuery(
                name = "Rental.findByDailyPrice",
                query = "select * from rentals r where r.daily_price = :dailyPrice",
                resultClass = Rental.class
        ),
        @NamedNativeQuery(
                name = "Rental.findAllThanDailyPrice",
                query = "select * from rentals r where r.daily_price >= :dailyPrice order by daily_price desc",
                resultClass = Rental.class
        ),
        @NamedNativeQuery(
                name = "Rental.findAllOrderByTotalPriceASC",
                query = "select * from rentals order by total_price asc",
                resultClass = Rental.class
        )
    }
)

public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int rentedForDays;
    private double dailyPrice;
    private double totalPrice; //read-only
    private LocalDateTime startDate;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;


}
