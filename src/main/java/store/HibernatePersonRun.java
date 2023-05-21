package store;

import Unidirectional.ManyToMany.Address;
import Unidirectional.ManyToMany.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernatePersonRun {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            final SessionFactory sf = new MetadataSources(registry)
                    .buildMetadata().buildSessionFactory();
          Session session = sf.openSession();

            Address address1 = Address.of("kirovskaya", "1");
            Address address2 = Address.of("kirovskaya", "2");

            Person person = Person.of("person");
            person.add(address1);
            person.add(address2);

            session.save(address1);
            session.save(address2);
            session.save(person);

            session.beginTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
