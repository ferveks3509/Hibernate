package store;

import model.Role;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class HibernateRoleRun {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            //Role admin = create(Role.of("Admin"), sf);
            //Role user = create(Role.of("User"), sf);
            //Role customer = create(Role.of("Customer"), sf);

            //create(User.of("FirstName", admin), sf);
           // create(User.of("SecondName", user), sf);
           // create(User.of("ThreeName", customer), sf);

            for (User us : findAll(User.class, sf)) {
                System.out.println(us.getName() + " " + us.getRole().getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
    public static <T> T create(T model, SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(model);
        session.getTransaction().commit();
        session.close();
        return model;
    }
    public static <T> List<T> findAll(Class<T> cl, SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        List<T> rsl = session.createQuery("from " + cl.getName(), cl).list();
        session.getTransaction().commit();
        return rsl;
    }
}
