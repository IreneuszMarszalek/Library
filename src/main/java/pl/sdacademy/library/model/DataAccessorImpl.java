package pl.sdacademy.library.model;

import pl.sdacademy.library.model.dao.AuthorDao;
import pl.sdacademy.library.model.dao.UserDao;
import pl.sdacademy.library.model.daoimpl.AuthorDaoImpl;
import pl.sdacademy.library.model.daoimpl.UserDaoImpl;

public class DataAccessorImpl implements DataAccessor{
  @Override
  public UserDao getUserDao () {
	return new UserDaoImpl();
  }

  @Override
  public AuthorDao getAuthorDao () {
	return new AuthorDaoImpl();
  }
}
