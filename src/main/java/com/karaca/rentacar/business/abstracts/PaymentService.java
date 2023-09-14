package com.karaca.rentacar.business.abstracts;

import com.karaca.rentacar.business.dto.requests.create.CreatePaymentRequest;
import com.karaca.rentacar.business.dto.requests.update.UpdatePaymentRequest;
import com.karaca.rentacar.business.dto.responses.create.CreatePaymentResponse;
import com.karaca.rentacar.business.dto.responses.get.Payment.GetAllPaymentsResponse;
import com.karaca.rentacar.business.dto.responses.get.Payment.GetPaymentResponse;
import com.karaca.rentacar.business.dto.responses.update.UpdatePaymentResponse;
import com.karaca.rentacar.common.dto.CreateRentalPaymentRequest;

import java.util.List;

public interface PaymentService {
    List<GetAllPaymentsResponse> getAll();

    GetPaymentResponse getById(int id);

    CreatePaymentResponse add(CreatePaymentRequest request);

    UpdatePaymentResponse update(int id, UpdatePaymentRequest request);

    void delete(int id);

    void processRentalPayment(CreateRentalPaymentRequest request);
}
