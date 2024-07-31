package com.karaca.rentacar.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payments")
public class Payment extends BaseEntity{
    private int cardExpirationMonth;
    private int cardExpirationYear;
    private String cardNumber;
    private String cardHolder;
    private String cardCvv;
    private double balance;
}
