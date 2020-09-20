package pl.sdacademy.library.view;

import pl.sdacademy.library.model.dto.AuthorDto;
import pl.sdacademy.library.model.dto.BookDto;
import pl.sdacademy.library.model.dto.UserDto;
import pl.sdacademy.library.model.entity.Author;
import pl.sdacademy.library.model.entity.Book;
import pl.sdacademy.library.view.ScreenOptions.ContinueScreenOption;
import pl.sdacademy.library.view.ScreenOptions.MainMenuScreenOption;
import pl.sdacademy.library.view.ScreenOptions.ReportsMenuScreenOption;
import pl.sdacademy.library.view.ScreenOptions.WelcomeMenuScreenOption;

import java.util.List;

public interface View {
  WelcomeMenuScreenOption showWelcomeMenuAndReturnSelectedPosition();
  UserDto showLogInMenuAndReturnResult();
  UserDto showCreateUserMenuAndReturnUser();
  String showDeleteUserMenuAndReturnUser();
  MainMenuScreenOption showMainMenuAndReturnSelectedPositions();
  String showActionMenuAndReturnSelectedPosition();
  ReportsMenuScreenOption showReportMenuAndReturnSelectedPosition();
  AuthorDto showCreateAuthorMenuAndReturnAuthor();
  BookDto showCreateBookMenuAndReturnBook();
  String showDeleteAuthorMenuAndReturnUser();

  void printUserList(List<UserDto> userList);
  void printAuthorList(List<AuthorDto> authorList);
  void printBookList(List<BookDto> bookList);
  ContinueScreenOption printContinue();

  void displayLoginErrorMsg(int errorCode);
  void displayCreateUserErrorMsg(int errorCode);
  void displayCreateAuthorErrorMsg(int errorCode);
  void displayCreateBookErrorMsg(int errorCode);
  void displayDeleteUserErrorMsg(int errorCode);
  void displayDeleteAuthorErrorMsg(int errorCode);

  void displayCreateUserMsg(UserDto user);
  void displayDeleteUserMsg(UserDto user);
  void displayLoginMsg(UserDto user);
  void displayDeleteAuthorMsg(AuthorDto author);
  void displayCreateBookMsg(BookDto book);

  void clearScreen();
}
