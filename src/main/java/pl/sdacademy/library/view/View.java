package pl.sdacademy.library.view;

import pl.sdacademy.library.model.dto.UserDto;
import pl.sdacademy.library.model.entity.Author;
import pl.sdacademy.library.model.entity.Book;
import pl.sdacademy.library.model.entity.User;
import pl.sdacademy.library.view.ScreenOptions.ContinueScreenOption;
import pl.sdacademy.library.view.ScreenOptions.MainMenuScreenOption;
import pl.sdacademy.library.view.ScreenOptions.WelcomeMenuScreenOption;

import java.util.List;

public interface View {
  WelcomeMenuScreenOption showWelcomeMenuAndReturnSelectedPosition();
  UserDto showLogInMenuAndReturnResult();
  UserDto showCreateUserMenuAndReturnUser();
  String showDeleteUserMenuAndReturnUser();
  MainMenuScreenOption showMainMenuAndReturnSelectedPositions();
  String showActionMenuAndReturnSelectedPosition();
  String showReportMenuAndReturnSelectedPosition();
  Author showCreateAuthorMenuAndReturnAuthor();
  Book showCreateBookMenuAndReturnBook();

  void printUserList(List<UserDto> userList);
  ContinueScreenOption printContinue();

  void displayLoginErrorMsg(int errorCode);
  void displayCreateUserErrorMsg(int errorCode);
  void displayCreateAuthorErrorMsg(int errorCode);
  void displayCreateBookErrorMsg(int errorCode);
  void displayDeleteUserErrorMsg(int errorCode);

  void displayCreateUserMsg(UserDto user);
  void displayDeleteUserMsg(UserDto user);
  void displayLoginMsg(UserDto user);

  void clearScreen();
}
