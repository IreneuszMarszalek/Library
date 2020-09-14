package pl.sdacademy.library.model;

import pl.sdacademy.library.model.dto.UserDto;

import java.util.List;

public interface Model {

  List<UserDto> getAllUsers();
  UserDto getUser(Long userId);
  void addNewUser(UserDto userDto);
  UserDto getUserByNick(String nick);
  void deleteUser(UserDto userDto);
  boolean checkIfUserHasHistory(UserDto user);
}
