package com.karaca.rentacar.repository.abstracts;

import com.karaca.rentacar.entities.concretes.Model;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ModelRepository extends JpaRepository<Model, Integer>
{
    List<Model> findAll(Sort sort);
    boolean existsByNameIgnoreCase(String name);
}
