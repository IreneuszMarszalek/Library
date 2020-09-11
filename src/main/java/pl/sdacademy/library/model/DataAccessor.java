package pl.sdacademy.library.model;

import pl.sdacademy.library.model.dao.AuthorDao;
import pl.sdacademy.library.model.dao.BookDao;
import pl.sdacademy.library.model.dao.UserDao;

public interface DataAccessor {
  UserDao getUserDao();
  AuthorDao getAuthorDao();
  BookDao getBookDao();
}
