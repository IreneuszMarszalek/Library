package pl.sdacademy.library.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {
  private static HibernateUtils INSTANCE = new HibernateUtils();
  private SessionFactory sessionFactory;

  private HibernateUtils(){
	StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
		.configure("hibernate.xml")
		.build();
	Metadata metadata = new MetadataSources(standardRegistry)
		.getMetadataBuilder()
		.build();
	sessionFactory = metadata
		.getSessionFactoryBuilder()
		.build();
  }

  public static HibernateUtils getInstance(){
    return INSTANCE;
  }

  public SessionFactory GetSessionFactory(){
    return sessionFactory;
  }
}
