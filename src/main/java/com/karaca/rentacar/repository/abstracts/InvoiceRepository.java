package com.karaca.rentacar.repository.abstracts;

import com.karaca.rentacar.entities.concretes.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer>
{

}
