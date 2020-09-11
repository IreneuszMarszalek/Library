package pl.sdacademy.library.model.dao;

import pl.sdacademy.library.model.entity.User;
import java.util.List;

public interface UserDao {
  void save (User user);
  User findByID(Long id);
  List<User> findAll();
  void delete(Long id);
  User findByNick(String nick);
}
