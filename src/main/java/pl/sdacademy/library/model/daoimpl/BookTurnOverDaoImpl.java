package pl.sdacademy.library.model.daoimpl;

import org.hibernate.Session;
import pl.sdacademy.library.model.dao.BookTurnoverDao;
import pl.sdacademy.library.model.entity.Book;
import pl.sdacademy.library.model.entity.BookTurnover;
import pl.sdacademy.library.model.utils.HibernateUtils;

import javax.persistence.NoResultException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class BookTurnOverDaoImpl implements BookTurnoverDao {
  @Override
  public void save (BookTurnover turnover) {
	Session session = HibernateUtils
		.getInstance()
		.GetSessionFactory()
		.getCurrentSession();

	session.beginTransaction();
	session.saveOrUpdate(turnover);
	session.getTransaction().commit();
	session.close();
  }

  @Override
  public BookTurnover findByID (Long id) {
	Session session = HibernateUtils
		.getInstance()
		.GetSessionFactory()
		.getCurrentSession();

	session.beginTransaction();
	BookTurnover turnover = null;

	try{
	  turnover = session
		  .createQuery("from BookTurnover where id=:id", BookTurnover.class)
		  .setParameter("id", id)
		  .getSingleResult();

	}catch (NoResultException e){
	  e.getStackTrace();
	}
	session.getTransaction().commit();
	session.close();

	return turnover;
  }

  @Override
  public List<BookTurnover> findAll () {
	Session session = HibernateUtils
		.getInstance()
		.GetSessionFactory()
		.getCurrentSession();

	session.beginTransaction();
	List turnovers = null;

	try {
	  turnovers = session
		  .createQuery("from BookTurnover")
		  .list();
	}catch (NoResultException e){
	  e.getStackTrace();
	}

	session.getTransaction().commit();
	session.close();

	return turnovers;
  }

  @Override
  public void delete (Long id) {
	Session session = HibernateUtils
		.getInstance()
		.GetSessionFactory()
		.getCurrentSession();

	session.beginTransaction();
	session.createQuery("delete BookTurnover where id=:id")
		.setParameter("id",id)
		.executeUpdate();

	session.getTransaction().commit();
	session.close();
  }

  @Override
  public List<BookTurnover> findAllBorrowedBooks () {
	Session session = HibernateUtils
		.getInstance()
		.GetSessionFactory()
		.getCurrentSession();

	session.beginTransaction();
	List borrowedBooks = null;

	try{
	  borrowedBooks = session
		  .createQuery("from BookTurnover where returnDate is null")
		  .list();
	}catch (NoResultException e){
	  e.getStackTrace();
	}

	session.getTransaction().commit();
	session.close();

    return borrowedBooks;
  }

  @Override
  public List<BookTurnover> findAllNotBorrowedBooks () {
	Session session = HibernateUtils
		.getInstance()
		.GetSessionFactory()
		.getCurrentSession();

	session.beginTransaction();
	List notBorrowedBooks = null;

	try{
	  notBorrowedBooks = session
		  .createQuery("from BookTurnover where returnDate is not null")
		  .list();
	}catch (NoResultException e){
	  e.getStackTrace();
	}

	session.getTransaction().commit();
	session.close();

	return notBorrowedBooks;
  }

  @Override
  //TODO: Zrob testy tego
  public Boolean isBookOverDue (Book book) {
	Session session = HibernateUtils
		.getInstance()
		.GetSessionFactory()
		.getCurrentSession();

	session.beginTransaction();

	BookTurnover turnover = null;

	try{
	  turnover = session
		  .createQuery("from BookTurnover where book=:book", BookTurnover.class)
		  .setParameter("book", book)
		  .getSingleResult();

	}catch (NoResultException e){
	  e.getStackTrace();
	}
	session.getTransaction().commit();
	session.close();

	Period period = Period.between(LocalDate.now(), turnover.getReturnDate());
	int duration = period.getDays();

	if (duration < 0){
	  return true;
	}else{
	  return false;
	}
  }
}
