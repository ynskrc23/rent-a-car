package com.karaca.rentacar.repository.abstracts;

import com.karaca.rentacar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ModelRepository extends JpaRepository<Model, Integer> {

    //custom queries
    boolean existsByNameIgnoreCase(String name);
}
