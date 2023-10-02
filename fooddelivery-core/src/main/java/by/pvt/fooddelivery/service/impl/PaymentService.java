package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.repository.PaymentRepository;
import by.pvt.fooddelivery.domain.payment.Payment;
import by.pvt.fooddelivery.service.PaymentApi;

import java.util.List;

public class PaymentService implements PaymentApi {
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void addPayment(Payment payment) {
        paymentRepository.addPayment(payment);
    }

    @Override
    public Payment getPaymentById(Long paymentId) {
        return paymentRepository.getPaymentById(paymentId);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.getAllPayments();
    }

    @Override
    public void deletePaymentById(Long paymentId) {
        paymentRepository.deletePaymentById(paymentId);
    }
}
