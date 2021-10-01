package Store;


import model.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Query;
import java.util.List;

public class HibernateRun {

    private static final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private static final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    public static void main(String[] args) {
        try {
            for (Item it : findAll(sf)) {
                System.out.println(it);
            }
            System.out.println(findByName("Update"));
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static Item create(Item item) {
            Session session = sf.openSession();
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
            session.close();
            return item;

    }

    public static void update(Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.update(item);
        session.getTransaction().commit();
        session.close();
    }

    public static void delete(Integer id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Item item = new Item(null);
        item.setId(id);
        session.delete(item);
        session.getTransaction().commit();
        session.close();
    }

    public static List<Item> findAll(SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        List result = session.createQuery("from model.Item").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public static Item findById(Integer id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Item result = session.get(Item.class, id);
        session.getTransaction().commit();
        session.close();
        return result;
    }
    public static List<Item> findByName(String name) {
        Session session = sf.openSession();
        Query query = session.createQuery("from Item i where i.name = :name");
        query.setParameter("name", name);
        List rsl = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return rsl;
    }
}
