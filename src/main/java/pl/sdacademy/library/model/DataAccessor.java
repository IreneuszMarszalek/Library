package pl.sdacademy.library.model;

import pl.sdacademy.library.model.dao.UserDao;

public interface DataAccessor {
  UserDao getUserDao();
}
