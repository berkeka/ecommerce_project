package final_project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import final_project.model.Item;
import final_project.utl.HibernateUtil;

public class ItemDao {
    @SuppressWarnings("unchecked")
    public List < Item > getAllItem() {

        Transaction transaction = null;
        List < Item > listOfItem = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            listOfItem = session.createQuery("from Item").list();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfItem;
    }
}