package by.pvt.fooddelivery.repository.impl.hibernate;

import by.pvt.fooddelivery.config.HibernateJavaConfig;
import by.pvt.fooddelivery.repository.PaymentRepository;
import by.pvt.fooddelivery.domain.payment.Payment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class PaymentRepositoryHibernate implements PaymentRepository {
    private final SessionFactory sessionFactory;
    private final String GET_ALL_PAYMENTS = "select u from Payment u";
    private final String DELETE_PAYMENT_BY_ID = "delete from Payment u where u.id =:id";

    public PaymentRepositoryHibernate() {
        this.sessionFactory = HibernateJavaConfig.getSessionFactory();
    }

    @Override
    public void addPayment(Payment payment) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(payment);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Payment getPaymentById(Long paymentId) {
        Session session = sessionFactory.openSession();
        Payment payment = session.get(Payment.class, paymentId);
        if (payment == null) {
            throw new RuntimeException("Payment does not exist");
        }
        session.close();
        return payment;
    }

    @Override
    public List<Payment> getAllPayments() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(GET_ALL_PAYMENTS);
        List<Payment> payments = query.getResultList();
        session.close();
        return payments;
    }

    @Override
    public void deletePaymentById(Long paymentId) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session.createQuery(DELETE_PAYMENT_BY_ID);
        query.setParameter("id", paymentId);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
