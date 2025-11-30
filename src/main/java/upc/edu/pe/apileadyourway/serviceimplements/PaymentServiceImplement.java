package upc.edu.pe.apileadyourway.serviceimplements;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImplement {

    public PaymentIntent createPaymentIntent(Long amount, String currency) throws StripeException {
        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                .setAmount(amount) // en centavos
                .setCurrency(currency) // ej. "usd" o "pen"
                .build();

        return PaymentIntent.create(params);
    }
}

