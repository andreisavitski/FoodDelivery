package by.pvt.fooddelivery.repository;

import by.pvt.fooddelivery.domain.payment.Payment;

import java.util.List;

public interface PaymentRepository {
    void addPayment(Payment payment);

    Payment getPaymentById(Long paymentId);

    List<Payment> getAllPayments();

    void deletePaymentById(Long paymentId);
}
