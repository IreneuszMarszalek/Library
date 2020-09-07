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

  public void start(){
    String option;
    do{
      option = view.showWelcomeMenuAndReturnSelectedPosition();
      switch(option){
        case "L":
          handleLogInOption(); break;
        case "l":
          handleLogInOption(); break;
        case "C":
          handleCreateUserOption();break;
        case "c":
          handleCreateUserOption();break;
      }

    }while((!("X".equalsIgnoreCase(option)))&&(!("L".equalsIgnoreCase(option)))&&(!("C".equalsIgnoreCase(option))));
  }

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
          handleMainMenuOption();
        }
      }
    }


  }

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

  private void handleMainMenuOption(){
    String option;
    do{
      option = view.showMainMenuAndReturnSelectedPositions();
      switch(option){
        case "A":
          handleActionsOption(); break;
        case "a":
          handleActionsOption(); break;
        case "R":
          handleReportsOption();break;
        case "r":
          handleReportsOption();break;
      }

    }while((!("X".equalsIgnoreCase(option)))&&(!("A".equalsIgnoreCase(option)))&&(!("R".equalsIgnoreCase(option))));
  }

  private void handleReportsOption () {
  }

  private void handleActionsOption () {
  }
}
