package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.dao.PaymentDAO;
import by.pvt.fooddelivery.domain.payment.Payment;
import by.pvt.fooddelivery.service.PaymentApi;

import java.util.List;

public class PaymentService implements PaymentApi {
    private final PaymentDAO paymentDAO;

    public PaymentService(PaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    @Override
    public void addPayment(Payment payment) {
        paymentDAO.addPayment(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDAO.getPaymentById(id);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentDAO.getAllPayments();
    }

    @Override
    public void deletePaymentById(Long id) {
        paymentDAO.deletePaymentById(id);
    }
}
