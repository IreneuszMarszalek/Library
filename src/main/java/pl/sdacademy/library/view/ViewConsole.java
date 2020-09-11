package pl.sdacademy.library.view;

import pl.sdacademy.library.model.entity.Author;
import pl.sdacademy.library.model.entity.Book;
import pl.sdacademy.library.model.entity.User;
import pl.sdacademy.library.utils.Console;

import java.awt.*;
import java.util.Scanner;

public class ViewConsole implements View{
  // It defines Welcome Menu view
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

  // It defines Log In Menu view
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

// It defines Create User Menu view
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

  // It defines Main Menu view
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

  // It defines Actions Menu view
  @Override
  public String showActionMenuAndReturnSelectedPosition () {
	System.out.println(" --------------- LibrarY Actions Menu  --------------- ");
	System.out.println(" ----------------------------------------------------- ");
	System.out.println(" - [B] Book | [U] User | [O] bOrrow | [G] Give back --");
	System.out.println(" - [A] Author ----------------------------------------");
	System.out.println(" ------------------- Make a choice ------------------- ");
	System.out.println(" -------------------- Or [C] baCk -------------------- ");
	System.out.print(" -->:");

	Scanner scanner = new Scanner(System.in);

	return scanner.nextLine();
  }

  // It defines Reports Menu view
  @Override
  public String showReportMenuAndReturnSelectedPosition () {
	System.out.println(" --------------- LibrarY Reports Menu  --------------- ");
	System.out.println(" ----------------------------------------------------- ");
	System.out.println(" - [U] Users | [B] Books | [O] bOrrowed | [A] Author -");
	System.out.println(" ------------------- Make a choice ------------------- ");
	System.out.println(" -------------------- Or [C] baCk -------------------- ");
	System.out.print(" -->:");

	Scanner scanner = new Scanner(System.in);

	return scanner.nextLine();
  }

  //It defines Create Author Menu view
  @Override
  public Author showCreateAuthorMenuAndReturnAuthor () {
	Console.clearScreen();
	System.out.println(" ----------------- Create Author Menu  --------------- ");
	System.out.println(" ----------------------------------------------------- ");

	Author author = new Author();

	Scanner scanner = new Scanner(System.in);
	System.out.print("Name: ");
	author.setName(scanner.nextLine());
	System.out.print("2nd name: ");
	author.setSecondName(scanner.nextLine());

	return author;
  }

  @Override
  public Book showCreateBookMenuAndReturnBook () {
	Console.clearScreen();
	System.out.println(" ------------------ Create Book Menu  ---------------- ");
	System.out.println(" ----------------------------------------------------- ");

	Book book = new Book();
	Author author = new Author();

	Scanner scanner = new Scanner(System.in);
	System.out.print("Title: ");
	book.setTitle(scanner.nextLine());
	System.out.print("Author (Name): ");
	author.setName(scanner.nextLine());
	System.out.print("Author (2nd name): ");
	author.setSecondName(scanner.nextLine());
	book.setAuthor(author);

	return book;
  }

  // Error msgs
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

  @Override
  public void displayCreateAuthorErrorMsg (int errorCode) {
	switch (errorCode){
	  case 1:
		System.out.println("Incorrect name");
		break;
	  case 2:
		System.out.println("Incorrect 2nd name");
		break;
	  default:
		System.out.println("Unknown error");
	}
  }

  public void displayCreateBookErrorMsg (int errorCode) {
	switch (errorCode){
	  case 1:
		System.out.println("Incorrect title");
		break;
	  case 2:
		System.out.println("Incorrect author");
		break;
	  default:
		System.out.println("Unknown error");
	}
  }
}
