package pl.sdacademy.library.controller;

import pl.sdacademy.library.model.DataAccessor;
import pl.sdacademy.library.model.DataAccessorImpl;
import pl.sdacademy.library.model.entity.User;
import pl.sdacademy.library.view.View;
import pl.sdacademy.library.view.ViewConsole;
import java.time.LocalDate;

public class Controller {
  private View view;
  private DataAccessor model;

  public Controller(){
    view = new ViewConsole();
    model = new DataAccessorImpl();
  }

  //Starting Point
  public void start(){
    String option;
    do{
      option = view.showWelcomeMenuAndReturnSelectedPosition();
      switch(option){
        case "L":
        case "l":
          handleLogInOption();
          break;
        case "C":
        case "c":
          handleCreateUserOption();
          handleMainMenuOption();
          break;
      }
    }while(
        (!("X".equalsIgnoreCase(option)))
        &&(!("L".equalsIgnoreCase(option)))
        &&(!("C".equalsIgnoreCase(option)))
    );
  }

  //It creates default user
  public void init(){
    if(model.getUserDao().findByNick("ADMIN") == null){
      User user = new User();
      user.setNick("ADMIN");
      user.setPassword("ADMIN");
      user.setAdmin(true);
      user.setActive(true);
      user.setJoiningDate(LocalDate.now());

      model.getUserDao().save(user);
    }
  }

  // Main Menu View
  private void handleMainMenuOption(){
    String option;
    do{
      option = view.showMainMenuAndReturnSelectedPositions();
      switch(option){
        case "A":
        case "a":
          handleActionsOption(); break;
        case "R":
        case "r":
          handleReportsOption();break;
      }
    }while(
        (!("X".equalsIgnoreCase(option)))
            &&(!("A".equalsIgnoreCase(option)))
            &&(!("R".equalsIgnoreCase(option)))
    );
  }

  //Reports view
  private void handleReportsOption () {
    String option;
    do{
      option = view.showReportMenuAndReturnSelectedPosition();
      switch(option){
        case "U":
        case "u":
          handleUsersReportOption(); break;
        case "B":
        case "b":
          handleBooksReportOption();break;
        case "O":
        case "o":
          handleBorrowedReportOption();break;
        case "C":
        case "c":
          handleMainMenuOption();break;
      }
    }while(
        (!("U".equalsIgnoreCase(option)))
            &&(!("B".equalsIgnoreCase(option)))
            &&(!("O".equalsIgnoreCase(option)))
            &&(!("C".equalsIgnoreCase(option)))
    );
  }

  //Actions view
  private void handleActionsOption () {
    String option;
    do{
      option = view.showActionMenuAndReturnSelectedPosition();
      switch(option){
        case "B":
        case "b":
          handleAddBookOption(); break;
        case "U":
        case "u":
          handleAddUserOption();break;
        case "O":
        case "o":
          handleBorrowBook();break;
        case "G":
        case "g":
          handleGiveBookBackOption();break;
        case "C":
        case "c":
          handleMainMenuOption();break;

      }
    }while(
        (!("B".equalsIgnoreCase(option)))
            &&(!("U".equalsIgnoreCase(option)))
            &&(!("O".equalsIgnoreCase(option)))
            &&(!("G".equalsIgnoreCase(option)))
            &&(!("C".equalsIgnoreCase(option)))
    );
  }

  //Login
  private void handleLogInOption () {
    User user = view.showLogInMenuAndReturnResult();

    String nick = user.getNick();
    String password = user.getPassword();

    if(user == null){
      view.displayLoginErrorMsg(1);
      start();
    }else{
      if(nick == null ){
        view.displayLoginErrorMsg(1);
        start();
      }else{
        if(password == null){
          view.displayLoginErrorMsg(2);
          start();
        }else {
          if (model.getUserDao().findByNick(nick) == null) {
            view.displayLoginErrorMsg(1);
            start();
          } else {
            Long foundUserId = model.getUserDao().findByNick(nick).getId();
            String foundPassword = model.getUserDao().findByID(foundUserId).getPassword();
            if(password.equals(foundPassword)){
              handleMainMenuOption();
            }else{
              view.displayLoginErrorMsg(2);
              start();
            }
          }
        }
      }
    }
  }

  //It creates user
  private void handleCreateUserOption () {
    User user = view.showCreateUserMenuAndReturnUser();
    if(user.getNick() == null){
      view.displayCreateUserErrorMsg(1);
      start();
    }else{
      if(user.getPassword() == null){
        view.displayCreateUserErrorMsg(2);
        start();
      }
      else {
        if(model.getUserDao().findByNick(user.getNick()) != null){
          view.displayCreateUserErrorMsg(1);
          start();
        }else {
          user.setAdmin(false);
          user.setActive(true);
          user.setJoiningDate(LocalDate.now());
          model.getUserDao().save(user);
        }
      }
    }
  }

  //Displays users
  private void handleUsersReportOption () {
    model.
        getUserDao()
        .findAll()
        .forEach(user -> System.out.println(user.getId()+" "+user.getNick()+" "+user.getName()+" "+user.getSecondName()));
    handleReportsOption();
  }

  //It creates user from action menu
  private void handleAddUserOption () {
    handleCreateUserOption();
    handleActionsOption();

  }

  private void handleBorrowedReportOption () {

  }

  private void handleBooksReportOption () {
  }

  private void handleGiveBookBackOption () {
  }

  private void handleBorrowBook () {
  }

  private void handleAddBookOption () {
  }
}
