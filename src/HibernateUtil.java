import entity.Book;
import entity.Laptop;
import entity.Program;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.IOException;
import java.util.Properties;

public class HibernateUtil {
    private final static SessionFactory
            SESSION_FACTORY=
            buildSessionFactory();
    private HibernateUtil(){}

    private static SessionFactory buildSessionFactory(){
        Properties prop = new Properties();
        try {
            prop.load(AppInitializer.class.getClassLoader()
                    .getResourceAsStream("hibernate.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        prop.setProperty("hibernate.connection.username", "root");
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .applySettings(prop)
                .build();

        Metadata metadata = new MetadataSources(standardRegistry)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Laptop.class)
                .addAnnotatedClass(Program.class)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(MainFormController.class)
                .getMetadataBuilder()
                .build();
        return metadata.getSessionFactoryBuilder()
                .build();
    }
    public static Session openSession(){
        return SESSION_FACTORY.openSession();
    }
}
