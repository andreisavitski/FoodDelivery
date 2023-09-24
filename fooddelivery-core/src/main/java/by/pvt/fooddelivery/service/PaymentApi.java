package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.domain.payment.Payment;

import java.util.List;

public interface PaymentApi {
    void addPayment(Payment payment);

    Payment getPaymentById(Long id);

    List<Payment> getAllPayments();

    void deletePaymentById(Long id);
}
