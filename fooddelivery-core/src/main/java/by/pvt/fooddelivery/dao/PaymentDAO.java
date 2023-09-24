package by.pvt.fooddelivery.dao;

import by.pvt.fooddelivery.domain.payment.Payment;

import java.util.List;

public interface PaymentDAO {
    void addPayment(Payment payment);

    Payment getPaymentById(Long id);

    List<Payment> getAllPayments();

    void deletePaymentById(Long id);
}
