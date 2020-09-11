package pl.sdacademy.library.view;

import pl.sdacademy.library.model.entity.Author;
import pl.sdacademy.library.model.entity.Book;
import pl.sdacademy.library.model.entity.User;

public interface View {
  String showWelcomeMenuAndReturnSelectedPosition();
  User showLogInMenuAndReturnResult();
  User showCreateUserMenuAndReturnUser();
  String showMainMenuAndReturnSelectedPositions();
  String showActionMenuAndReturnSelectedPosition();
  String showReportMenuAndReturnSelectedPosition();
  Author showCreateAuthorMenuAndReturnAuthor();
  Book showCreateBookMenuAndReturnBook();

  void displayLoginErrorMsg(int errorCode);
  void displayCreateUserErrorMsg(int errorCode);
  void displayCreateAuthorErrorMsg(int errorCode);
  void displayCreateBookErrorMsg(int errorCode);
}
