package upc.edu.pe.apileadyourway.controllers;


import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.apileadyourway.dtos.PaymentRequestDTO;
import upc.edu.pe.apileadyourway.serviceimplements.PaymentServiceImplement;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentServiceImplement paymentService;

    @PostMapping("/create-payment-intent")
    @PreAuthorize("hasAuthority('CLIENTE')")
    public ResponseEntity<Map<String, Object>> createPaymentIntent(@RequestBody PaymentRequestDTO request) {
        try {
            Long amount = request.getAmount();
            if (amount == null || amount <= 0) {
                return ResponseEntity.badRequest().body(Map.of("error", "amount must be > 0"));
            }

            PaymentIntent intent = paymentService.createPaymentIntent(amount, "usd");

            Map<String, Object> response = new HashMap<>();
            response.put("clientSecret", intent.getClientSecret());

            return ResponseEntity.ok(response);
        } catch (StripeException e) {
            return ResponseEntity.status(500).body(Map.of("error", e.getMessage()));
        }
    }
}
