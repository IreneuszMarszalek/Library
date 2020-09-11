package pl.sdacademy.library.model.daoimpl;

import org.hibernate.Session;
import pl.sdacademy.library.model.dao.AuthorDao;
import pl.sdacademy.library.model.entity.Author;
import pl.sdacademy.library.utils.HibernateUtils;

import javax.persistence.NoResultException;
import java.util.List;

public class AuthorDaoImpl implements AuthorDao {
  @Override
  public void save (Author author) {
	Session session = HibernateUtils
		.getInstance()
		.GetSessionFactory()
		.getCurrentSession();

	session.beginTransaction();
	session.saveOrUpdate(author);
	session.getTransaction().commit();
	session.close();
  }

  @Override
  public Author findByID (Long id) {
	Session session = HibernateUtils
		.getInstance()
		.GetSessionFactory()
		.getCurrentSession();

	session.beginTransaction();
	Author author = null;

	try{
	  author = session
		  .createQuery("from Author where id=:id", Author.class)
		  .setParameter("id", id)
		  .getSingleResult();

	}catch (NoResultException e){

	}
	session.getTransaction().commit();
	session.close();

	return author;
  }

  @Override
  public List<Author> findAll () {
	Session session = HibernateUtils
		.getInstance()
		.GetSessionFactory()
		.getCurrentSession();

	session.beginTransaction();
	List authors = null;

	try {
	  authors = session
		  .createQuery("from Author")
		  .list();
	}catch (NoResultException e){

	}

	session.getTransaction().commit();
	session.close();

	return authors;
  }

  @Override
  public void delete (Long id) {
	Session session = HibernateUtils
		.getInstance()
		.GetSessionFactory()
		.getCurrentSession();

	session.beginTransaction();
	session.createQuery("delete Author where id=:id")
		.setParameter("id",id)
		.executeUpdate();

	session.getTransaction().commit();
	session.close();
  }

  @Override
  public List<Author> findByName (String name) {
	Session session = HibernateUtils
		.getInstance()
		.GetSessionFactory()
		.getCurrentSession();

	session.beginTransaction();
	List<Author> authors = null;

	try{
	  authors = session
		  .createQuery("from Author where name=:name", Author.class)
		  .setParameter("name", name)
		  .list();

	}catch (NoResultException e){

	}
	session.getTransaction().commit();
	session.close();

	return authors;
  }

  @Override
  public List<Author> findBySecondName (String secondName) {
	Session session = HibernateUtils
		.getInstance()
		.GetSessionFactory()
		.getCurrentSession();

	session.beginTransaction();
	List authors = null;

	try{
	  authors = session
		  .createQuery("from Author where secondName=:secondName", Author.class)
		  .setParameter("secondName", secondName)
		  .list();

	}catch (NoResultException e){

	}
	session.getTransaction().commit();
	session.close();

	return authors;
  }
}
