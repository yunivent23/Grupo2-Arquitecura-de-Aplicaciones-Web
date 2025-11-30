package upc.edu.pe.apileadyourway.dtos;

public class PaymentRequestDTO {
    private Long amount; // en centavos (1000 = 10.00 USD)

    public Long getAmount() { return amount; }
    public void setAmount(Long amount) { this.amount = amount; }
}
