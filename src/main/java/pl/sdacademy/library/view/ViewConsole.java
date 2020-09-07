package pl.sdacademy.library.view;

import pl.sdacademy.library.model.entity.User;
import pl.sdacademy.library.utils.Console;

import java.util.Scanner;

public class ViewConsole implements View{
    @Override
  public String showWelcomeMenuAndReturnSelectedPosition () {
	  System.out.println(" --------------- LibrarY Welcome Menu  --------------- ");
	  System.out.println(" ----------------------------------------------------- ");
	  System.out.println(" ----------- [L] Log In | [C] Create User ------------ ");
	  System.out.println(" ------------------- Make a choice ------------------- ");
	  System.out.println(" -------------------- Or [X] eXit -------------------- ");
	  System.out.print(" -->:");
	  Scanner scanner = new Scanner(System.in);
	  return scanner.nextLine();

  }

  @Override
  public User showLogInMenuAndReturnResult () {
	Console.clearScreen();
	System.out.println(" -------------------- Log In Menu  ------------------- ");
	System.out.println(" ----------------------------------------------------- ");

	User user = new User();

	Scanner scanner = new Scanner(System.in);
	System.out.print("Nick: ");
	user.setNick(scanner.nextLine());
	System.out.print("Password: ");
	user.setPassword(scanner.nextLine());

	return user;
  }

  @Override
  public User showCreateUserMenuAndReturnUser () {
	Console.clearScreen();
	System.out.println(" ----------------- Create User Menu  ----------------- ");
	System.out.println(" ----------------------------------------------------- ");

	User user = new User();

	Scanner scanner = new Scanner(System.in);
	System.out.print("Nick: ");
	user.setNick(scanner.nextLine());
	System.out.print("Password: ");
	user.setPassword(scanner.nextLine());
	System.out.print("Name: ");
	user.setName(scanner.nextLine());
	System.out.print("2nd name: ");
	user.setSecondName(scanner.nextLine());

	return user;
  }

  @Override
  public String showMainMenuAndReturnSelectedPositions () {
	System.out.println(" ----------------- LibrarY Main Menu  ---------------- ");
	System.out.println(" ----------------------------------------------------- ");
	System.out.println(" ------------- [A] Actions | [R] Reports ------------- ");
	System.out.println(" ------------------- Make a choice ------------------- ");
	System.out.println(" -------------------- Or [X] eXit -------------------- ");
	System.out.print(" -->:");

	Scanner scanner = new Scanner(System.in);

	return scanner.nextLine();
  }

  @Override
  public void displayLoginErrorMsg (int errorCode) {
	switch (errorCode){
	  case 1:
		System.out.println("User does not exist");
		break;
	  case 2:
		System.out.println("Incorrect password");
		break;
	  default:
		System.out.println("Unknown error");
	}
  }

  @Override
  public void displayCreateUserErrorMsg (int errorCode) {
	switch (errorCode){
	  case 1:
		System.out.println("Incorrect nick");
		break;
	  case 2:
		System.out.println("Incorrect password");
		break;
	  default:
		System.out.println("Unknown error");
	}
  }
}
