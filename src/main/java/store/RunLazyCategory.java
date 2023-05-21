package store;

import LazyInitializationexception.Category;
import LazyInitializationexception.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class RunLazyCategory {

    /*
    1. Поместить вызов метода, который получает доступ к ассоциированному объекту в поле действия сессии с которой он ассоциирован.
    2. Использование механизма join fetch.
     */
    public static void main(String[] args) {
        List<Category> list = new ArrayList<>();
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();
            list = session.createQuery("from Category").list();
            for (Category category : list) {
                for (Task task : category.getTasks()) {
                    System.out.println(task);
                }
            }
            session.getTransaction().commit();
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
        /*2
        list = session.createQuery(
                    "select distinct c from Category c join fetch c.tasks"
            ).list();
         */
    }
}
