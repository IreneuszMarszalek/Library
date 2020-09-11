package pl.sdacademy.library.model.daoimpl;

import org.hibernate.Session;
import pl.sdacademy.library.model.dao.BookDao;
import pl.sdacademy.library.model.entity.Book;
import pl.sdacademy.library.utils.HibernateUtils;

import javax.persistence.NoResultException;
import java.util.List;

public class BookDaoImpl implements BookDao {
  @Override
  public void save (Book book) {
	Session session = HibernateUtils
		.getInstance()
		.GetSessionFactory()
		.getCurrentSession();

	session.beginTransaction();
	session.saveOrUpdate(book);
	session.getTransaction().commit();
	session.close();
  }

  @Override
  public Book findByID (Long id) {
	Session session = HibernateUtils
		.getInstance()
		.GetSessionFactory()
		.getCurrentSession();

	session.beginTransaction();
	Book book = null;

	try{
	  book = session
		  .createQuery("from Book where id=:id", Book.class)
		  .setParameter("id", id)
		  .getSingleResult();

	}catch (NoResultException e){
	  e.getStackTrace();
	}
	session.getTransaction().commit();
	session.close();

	return book;
  }

  @Override
  public List<Book> findAll () {
	Session session = HibernateUtils
		.getInstance()
		.GetSessionFactory()
		.getCurrentSession();

	session.beginTransaction();
	List books = null;

	try {
	  books = session
		  .createQuery("from Book")
		  .list();
	}catch (NoResultException e){
	  e.getStackTrace();
	}

	session.getTransaction().commit();
	session.close();

	return books;
  }

  @Override
  public void delete (Long id) {
	Session session = HibernateUtils
		.getInstance()
		.GetSessionFactory()
		.getCurrentSession();

	session.beginTransaction();
	session.createQuery("delete Book where id=:id")
		.setParameter("id",id)
		.executeUpdate();

	session.getTransaction().commit();
	session.close();
  }
}
