package com.karaca.rentacar.adapters;

import com.karaca.rentacar.business.abstracts.PosService;
import com.karaca.rentacar.common.constants.Messages;
import com.karaca.rentacar.core.exceptions.BusinessException;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class FakePosServiceAdapter implements PosService
{
    @Override
    public void pay()
    {
        boolean isPaymentSuccessful = true;
        if (!isPaymentSuccessful)
            throw new BusinessException(Messages.Payment.Failed);
    }
}
