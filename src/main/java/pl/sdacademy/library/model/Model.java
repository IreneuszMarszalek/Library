package pl.sdacademy.library.model;

import pl.sdacademy.library.model.dao.AuthorDao;
import pl.sdacademy.library.model.dao.BookDao;
import pl.sdacademy.library.model.dao.UserDao;
import pl.sdacademy.library.model.dto.UserDto;

import java.util.List;

public interface Model {

  List<UserDto> getAllUsers();
  void addNewUser(UserDto userDto);
  UserDto getUserByNick(String nick);
}
