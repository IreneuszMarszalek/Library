package pl.sdacademy.library.model;

import pl.sdacademy.library.model.dto.UserDto;

import java.util.List;

public interface Model {
  List<UserDto> getAllUsers();
  void addNewUser(UserDto userDto);
}
