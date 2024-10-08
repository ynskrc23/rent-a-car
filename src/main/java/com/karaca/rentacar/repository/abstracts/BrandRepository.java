package com.karaca.rentacar.repository.abstracts;

import com.karaca.rentacar.entities.concretes.Brand;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//CRUD operations, manages the database
public interface BrandRepository extends JpaRepository<Brand, Integer>
{
    List<Brand> findAll(Sort sort);
    //custom queries
    boolean existsByNameIgnoreCase(String name);
    Brand findByName(String name);
    List<Brand> findByNameContaining(String name);
}
