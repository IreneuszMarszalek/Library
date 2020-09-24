package pl.sdacademy.library.view;

import pl.sdacademy.library.model.dto.AuthorDto;
import pl.sdacademy.library.model.dto.BookDto;
import pl.sdacademy.library.model.dto.UserDto;
import pl.sdacademy.library.model.entity.Author;
import pl.sdacademy.library.model.entity.Book;
import pl.sdacademy.library.view.ScreenOptions.*;

import java.util.List;

public interface View {
  WelcomeMenuScreenOption showWelcomeMenuAndReturnSelectedPosition();
  UserDto showLogInMenuAndReturnResult();
  UserDto showCreateUserMenuAndReturnUser();
  String showDeleteUserMenuAndReturnUser();
  MainMenuScreenOption showMainMenuAndReturnSelectedPositions();
  ActionsScreenMenu showActionMenuAndReturnSelectedPosition();
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
