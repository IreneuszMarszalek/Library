package pl.sdacademy.library.model;

import pl.sdacademy.library.model.dao.AuthorDao;
import pl.sdacademy.library.model.dao.BookDao;
import pl.sdacademy.library.model.dao.UserDao;

public interface DataAccessor {
  //TODO: zrob z tego model
  //TODO: dadaj metody jak" get all books, get all users
  UserDao getUserDao();
  AuthorDao getAuthorDao();
  BookDao getBookDao();
}
