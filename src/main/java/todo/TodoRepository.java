package todo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class TodoRepository {

    public void add(String description) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(new TodoItem(description));
            tx.commit();
        }
    }

    public List<TodoItem> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from TodoItem", TodoItem.class).getResultList();
        }
    }

    public void deleteById(long id) {
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = s.beginTransaction();
            TodoItem item = s.get(TodoItem.class, id);
            if (item != null) s.remove(item);
            tx.commit();
        }
    }

    public void setCompleted(long id, boolean completed) {
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = s.beginTransaction();
            TodoItem item = s.get(TodoItem.class, id);
            if (item != null) item.setCompleted(completed);
            tx.commit();
        }
    }
}
