package com.karaca.rentacar.business.concretes;

import com.karaca.rentacar.entities.concretes.Payment;
import com.karaca.rentacar.repository.abstracts.PaymentRepository;
import com.karaca.rentacar.adapters.FakePosServiceAdapter;
import com.karaca.rentacar.business.abstracts.PaymentService;
import com.karaca.rentacar.business.dto.requests.create.CreatePaymentRequest;
import com.karaca.rentacar.business.dto.requests.update.UpdatePaymentRequest;
import com.karaca.rentacar.business.dto.responses.create.CreatePaymentResponse;
import com.karaca.rentacar.business.dto.responses.get.Payment.GetAllPaymentsResponse;
import com.karaca.rentacar.business.dto.responses.get.Payment.GetPaymentResponse;
import com.karaca.rentacar.business.dto.responses.update.UpdatePaymentResponse;
import com.karaca.rentacar.business.rules.PaymentBusinessRules;
import com.karaca.rentacar.common.dto.CreateRentalPaymentRequest;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService {
    private final PaymentRepository repository;
    private final ModelMapper mapper;
    private final FakePosServiceAdapter fakePosServiceAdapter;
    private final PaymentBusinessRules rules;

    @Override
    public List<GetAllPaymentsResponse> getAll() {
        List<Payment> payments = repository.findAll();
        return payments.stream().map(payment -> mapper.map(payment, GetAllPaymentsResponse.class)).toList();
    }

    @Override
    public GetPaymentResponse getById(int id) {
        Payment payment = repository.findById(id).orElseThrow();
        return mapper.map(payment, GetPaymentResponse.class);

    }

    @Override
    public CreatePaymentResponse add(CreatePaymentRequest request) {
        rules.checkIfCardExists(request.getCardNumber());
        Payment payment = mapper.map(request, Payment.class);
        payment.setId(0);
        repository.save(payment);
        return mapper.map(payment, CreatePaymentResponse.class);
    }

    @Override
    public UpdatePaymentResponse update(int id, UpdatePaymentRequest request) {
        Payment payment = mapper.map(request, Payment.class);
        payment.setId(id);
        repository.save(payment);
        return mapper.map(payment, UpdatePaymentResponse.class);
    }

    @Override
    public void delete(int id) {
        rules.checkIfPaymentExists(id);
        repository.deleteById(id);
    }

    @Override
    public void processRentalPayment(CreateRentalPaymentRequest request)
    {
        rules.checkIfPaymentIsValid(request);
        Payment payment = repository.findByCardNumber(request.getCardNumber());
        rules.checkIfBalanceIsEnough(request.getPrice(), payment.getBalance());
        //fake pos service
        fakePosServiceAdapter.pay();
        payment.setBalance(payment.getBalance() - request.getPrice());
        repository.save(payment);
    }


}
