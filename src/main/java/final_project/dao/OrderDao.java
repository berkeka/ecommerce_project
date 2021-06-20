package final_project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import final_project.model.Order;
import final_project.model.Product;
import final_project.utl.HibernateUtil;

public class OrderDao {
	
    public void saveOrder(Order order) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(order);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
	
    public Order getOrder(int id) {

        Transaction transaction = null;
        Order order = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();

            order = session.get(Order.class, id);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return order;
    }

    @SuppressWarnings("unchecked")
    public List < Order > getAllOrders() {

        Transaction transaction = null;
        List < Order > listOfOrder = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            listOfOrder = session.createQuery("from Order").list();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfOrder;
    }
    
    @SuppressWarnings("unchecked")
	public List < Order > getUserOrders(int userId) {

        Transaction transaction = null;
        List < Order > listOfOrder = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            listOfOrder = session.createQuery("from Order O WHERE O.user_id = :uid").setParameter("uid", userId).list();
            
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfOrder;
    }
}
