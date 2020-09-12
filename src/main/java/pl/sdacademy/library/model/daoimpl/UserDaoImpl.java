package pl.sdacademy.library.model.daoimpl;

import org.hibernate.Session;
import pl.sdacademy.library.model.dao.UserDao;
import pl.sdacademy.library.model.entity.User;
import pl.sdacademy.library.model.utils.HibernateUtils;

import javax.persistence.NoResultException;
import java.util.List;

public class UserDaoImpl implements UserDao {
  @Override
  public void save (User user) {
	Session session = HibernateUtils
		.getInstance()
		.GetSessionFactory()
		.getCurrentSession();

	session.beginTransaction();
	session.saveOrUpdate(user);
	session.getTransaction().commit();
	session.close();
  }

  @Override
  public User findByID (Long id) {
	Session session = HibernateUtils
		.getInstance()
		.GetSessionFactory()
		.getCurrentSession();

	session.beginTransaction();
	User user = null;

	try{
	  user = session
		  .createQuery("from User where id=:id", User.class)
		  .setParameter("id", id)
		  .getSingleResult();

	}catch (NoResultException e){
	  e.getStackTrace();
	}
	session.getTransaction().commit();
	session.close();

	return user;
  }

  @Override
  public List<User> findAll () {
	Session session = HibernateUtils
		.getInstance()
		.GetSessionFactory()
		.getCurrentSession();

	session.beginTransaction();
	List users = null;

	try {
	  users = session
		  .createQuery("from User")
		  .list();
	}catch (NoResultException e){
	  e.getStackTrace();
	}

	session.getTransaction().commit();
	session.close();

	return users;
  }

  @Override
  public void delete (Long id) {
    Session session = HibernateUtils
		.getInstance()
		.GetSessionFactory()
		.getCurrentSession();

    session.beginTransaction();
    session.createQuery("delete User where id=:id")
		.setParameter("id",id)
		.executeUpdate();

    session.getTransaction().commit();
    session.close();
  }

  @Override
  public User findByNick (String nick) {
	Session session = HibernateUtils
		.getInstance()
		.GetSessionFactory()
		.getCurrentSession();

	session.beginTransaction();
	User user = null;

	try{
	  user = session.createQuery("from User where nick =:nick", User.class)
		  .setParameter("nick", nick)
		  .getSingleResult();

	}catch(NoResultException e){
		e.getStackTrace();
	}

	session.getTransaction().commit();
	session.close();

    return user;
  }
}
