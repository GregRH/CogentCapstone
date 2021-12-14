package com.cogent.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stripe.Stripe;
import com.stripe.model.Charge;

@Component
public class StripeClient {

    @Autowired
    StripeClient() {
        Stripe.apiKey = "pk_test_51K6guqK8hlEhdqdjNYAavtcGoFd2B36l2GzGcdFgL2iYHLy6KQDpNtYwylvlhSeu4BNuzxsbW28J8U0lKxq7Guos00oZSqpeZP";
    }

    public Charge chargeCreditCard(String token, double amount) throws Exception {
        Map<String, Object> chargeParams = new HashMap<String, Object>();
        chargeParams.put("amount", (int)(amount*100));
        chargeParams.put("currency", "USD");
        chargeParams.put("source", token);
        Charge charge = Charge.create(chargeParams);
        return charge;
    }
}