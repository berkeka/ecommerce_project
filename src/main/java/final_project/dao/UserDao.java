package final_project.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import final_project.model.Product;
import final_project.model.User;
import final_project.utl.HibernateUtil;

public class UserDao {

    public void saveUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(user);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public User getUser(int id) {

        Transaction transaction = null;
        User user = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            user = session.get(User.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return user;
    }

    public User validate(String userName, String password) {

        Transaction transaction = null;
        User user = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            user = (User) session.createQuery("FROM User U WHERE U.username = :userName").setParameter("userName", userName)
                .uniqueResult();

            if (user != null && user.getPassword().equals(password)) {
                return user;
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

}