package pl.sdacademy.library.view;

import pl.sdacademy.library.model.entity.User;

public interface View {
  String showWelcomeMenuAndReturnSelectedPosition();
  User showLogInMenuAndReturnResult();
  User showCreateUserMenuAndReturnUser();
  String showMainMenuAndReturnSelectedPositions();
  String showActionMenuAndReturnSelectedPosition();
  String showReportMenuAndReturnSelectedPosition();

  void displayLoginErrorMsg(int errorCode);
  void displayCreateUserErrorMsg(int errorCode);
}
