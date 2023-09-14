package com.karaca.rentacar.business.rules;

import com.karaca.rentacar.repository.abstracts.InvoiceRepository;
import com.karaca.rentacar.common.constants.Messages;
import com.karaca.rentacar.core.exceptions.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InvoiceBusinessRules {
    private final InvoiceRepository repository;

    // Business rules
    public void checkIfInvoiceExist(int id) {
        if (!repository.existsById(id)) throw new BusinessException(Messages.Invoice.NotFound);
    }
}
