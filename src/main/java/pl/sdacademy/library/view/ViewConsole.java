package pl.sdacademy.library.view;
import pl.sdacademy.library.model.dto.UserDto;
import pl.sdacademy.library.model.entity.Author;
import pl.sdacademy.library.model.entity.Book;
import pl.sdacademy.library.model.utils.Console;
import pl.sdacademy.library.view.ScreenOptions.ContinueScreenOption;
import pl.sdacademy.library.view.ScreenOptions.ExitScreenOption;
import pl.sdacademy.library.view.ScreenOptions.MainMenuScreenOption;
import pl.sdacademy.library.view.ScreenOptions.WelcomeMenuScreenOption;

//TODO: enum dla menu
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ViewConsole implements View {
  // It defines Welcome Menu view
  @Override
  public WelcomeMenuScreenOption showWelcomeMenuAndReturnSelectedPosition () {

    String result;
	System.out.println(" ----------------------------------------------------------------------------------------- ");
    System.out.println(" ---------------------------------- Library Welcome Menu --------------------------------- ");
	System.out.println(" ----------------------------------------------------------------------------------------- ");
	System.out.println(" ------------------------ ["
		+ WelcomeMenuScreenOption.LOG_IN.label
		+ "] Log In | ["
		+ WelcomeMenuScreenOption.CREATE_USER.label
		+ "] Create User | ["
		+ WelcomeMenuScreenOption.EXIT.label
		+ "] Exit ------------------------ ");
	System.out.println(" ----------------------------------------------------------------------------------------- ");
	System.out.print(" : ");

	Scanner scanner = new Scanner(System.in);
	result = scanner.nextLine();
	System.out.println();

	return WelcomeMenuScreenOption.valueOfLabel(result);
  }

  // It defines Log In Menu view
  @Override
  public UserDto showLogInMenuAndReturnResult () {
	System.out.println(" ----------------------------------------------------------------------------------------- ");
	System.out.println(" --------------------------------------- Login Menu -------------------------------------- ");
	System.out.println(" ----------------------------------------------------------------------------------------- ");

	UserDto user = new UserDto();

	Scanner scanner = new Scanner(System.in);
	System.out.print(" - Nick: ");
	user.setNick(scanner.nextLine());
	System.out.print(" - Password: ");
	user.setPassword(scanner.nextLine());
	System.out.println();

	return user;
  }

  // It defines Create User Menu view
  @Override
  public UserDto showCreateUserMenuAndReturnUser () {
	System.out.println(" ----------------------------------------------------------------------------------------- ");
	System.out.println(" --------------------------------------- Add User  --------------------------------------- ");
	System.out.println(" ----------------------------------------------------------------------------------------- ");

	UserDto user = new UserDto();

	Scanner scanner = new Scanner(System.in);
	System.out.print(" - Nick: ");
	user.setNick(scanner.nextLine());
	System.out.print(" - Password: ");
	user.setPassword(scanner.nextLine());
	System.out.print(" - Name: ");
	user.setName(scanner.nextLine());
	System.out.print(" - 2nd name: ");
	user.setSecondName(scanner.nextLine());
	user.setAdmin(false);
	user.setActive(true);
	user.setJoiningDate(LocalDate.now());
	System.out.println(" ----------------------------------------------------------------------------------------- ");

	return user;
  }

  public String showDeleteUserMenuAndReturnUser(){
	System.out.println(" ----------------------------------------------------------------------------------------- ");
	System.out.println(" ------------------------------------- Delete User  -------------------------------------- ");
	System.out.println(" ----------------------------------------------------------------------------------------- ");

	String userID;

	Scanner scanner = new Scanner(System.in);
	System.out.print(" - Provide ID: ");
	userID = scanner.nextLine();
	System.out.println(" ----------------------------------------------------------------------------------------- ");

	return userID;
  }

  //It prints all users
  public void printUserList (List<UserDto> userList) {
	System.out.println(" --------------------------------------- User List  -------------------------------------- ");
	System.out.println(" ----------------------------------------------------------------------------------------- ");
	System.out.println(" - ID | Nick | Name | Second Name | Joining Date ----------------------------------------- ");
	System.out.println(" ----------------------------------------------------------------------------------------- ");
	userList
		.stream()
		.forEach(userDto -> System.out.println(
				" - "
				+ userDto.getId()
				+ " | "
				+ userDto.getNick()
				+ " | "
				+ userDto.getName()
				+ " | "
				+ userDto.getSecondName()
				+ " | "
				+ userDto.getJoiningDate()
			)
		);
	System.out.println(" ----------------------------------------------------------------------------------------- ");
  }

  // It defines Main Menu view.Corrected !
  @Override
  public MainMenuScreenOption showMainMenuAndReturnSelectedPositions () {
	System.out.println(" ----------------------------------------------------------------------------------------- ");
	System.out.println(" --------------------------------------- Main menu --------------------------------------- ");
	System.out.println(" ----------------------------------------------------------------------------------------- ");
	System.out.println(" ------------------ ["
		+ MainMenuScreenOption.ACTIONS.label
		+ "] Actions | ["
		+ MainMenuScreenOption.REPORTS.label
		+ "] Reports | ["
		+ MainMenuScreenOption.SETTINGS.label
		+ "] Settings | ["
		+ MainMenuScreenOption.EXIT.label
		+ "] eXit ------------------ ");
	System.out.println(" ----------------------------------------------------------------------------------------- ");
	System.out.print(" : ");

	Scanner scanner = new Scanner(System.in);
	MainMenuScreenOption result = MainMenuScreenOption.valueOfLabel(scanner.nextLine());
	System.out.println();

	return result;
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

  public ContinueScreenOption printContinue(){
    String option;
	System.out.print(" - Press " + ContinueScreenOption.CONTINUE.label + " to continue: ");
	Scanner scanner = new Scanner(System.in);
	option = scanner.nextLine();
	System.out.println();
	return ContinueScreenOption.valueOfLabel(option);
  }

  public ExitScreenOption printExit(){
	String option;
	System.out.print(" - Press " + ExitScreenOption.EXIT.label + " to exit: ");
	Scanner scanner = new Scanner(System.in);
	option = scanner.nextLine();
	System.out.println();
	return ExitScreenOption.valueOfLabel(option);
  }

  // Error msgs
  @Override
  public void displayLoginErrorMsg (int errorCode) {
	switch (errorCode) {
	  case 1:
		System.out.println(" -------------------------------------- !! ERROR !! -------------------------------------- ");
		System.out.println(" - User does not exist");
		System.out.println(" ----------------------------------------------------------------------------------------- ");
		System.out.println();
		break;
	  case 2:
		System.out.println(" -------------------------------------- !! ERROR !! -------------------------------------- ");
		System.out.println(" - Incorrect password");
		System.out.println(" ----------------------------------------------------------------------------------------- ");
		System.out.println();
		break;
	  default:
		System.out.println(" ----------------------------------------------------------------------------------------- ");
		System.out.println(" - Unknown error");
		System.out.println(" ----------------------------------------------------------------------------------------- ");
		System.out.println();
	}
  }

  @Override
  public void displayCreateUserErrorMsg (int errorCode) {
	switch (errorCode) {
	  case 1:
		System.out.println(" -------------------------------------- !! ERROR !! -------------------------------------- ");
		System.out.println(" - Incorrect nick");
		System.out.println(" ----------------------------------------------------------------------------------------- ");
		System.out.println();
		break;
	  case 2:
		System.out.println(" -------------------------------------- !! ERROR !! -------------------------------------- ");
		System.out.println(" - Incorrect password");
		System.out.println(" ----------------------------------------------------------------------------------------- ");
		System.out.println();
		break;
	  default:
		System.out.println(" -------------------------------------- !! ERROR !! -------------------------------------- ");
		System.out.println(" - Unknown error");
		System.out.println(" ----------------------------------------------------------------------------------------- ");
		System.out.println();
	}
  }

  public void displayDeleteUserErrorMsg(int errorCode){
	switch (errorCode) {
	  case 1:
		System.out.println(" -------------------------------------- !! ERROR !! -------------------------------------- ");
		System.out.println(" - Not numeric provided");
		System.out.println(" ----------------------------------------------------------------------------------------- ");
		System.out.println();
		break;
	  case 2:
		System.out.println(" -------------------------------------- !! ERROR !! -------------------------------------- ");
		System.out.println(" - Wrong user ID provided");
		System.out.println(" ----------------------------------------------------------------------------------------- ");
		System.out.println();
		break;
	  default:
		System.out.println(" -------------------------------------- !! ERROR !! -------------------------------------- ");
		System.out.println(" - Unknown error");
		System.out.println(" ----------------------------------------------------------------------------------------- ");
		System.out.println();
	}

  }

  public void displayCreateUserMsg (UserDto user) {
	System.out.println(" ------------------------------------- !! SUCCESS !! ------------------------------------- ");
	System.out.println(" - User: " + user.getNick() + " | " + user.getName() + " | " + user.getSecondName() + " created");
	System.out.println(" ----------------------------------------------------------------------------------------- ");
	System.out.println();
  }

  public void displayDeleteUserMsg (UserDto user) {
	System.out.println(" ------------------------------------- !! SUCCESS !! ------------------------------------- ");
	System.out.println(" - User: " + user.getNick() + " | " + user.getName() + " | " + user.getSecondName() + " deleted");
	System.out.println(" ----------------------------------------------------------------------------------------- ");
	System.out.println();
  }

  @Override
  public void displayLoginMsg (UserDto user) {
	System.out.println(" ------------------------------------- !! SUCCESS !! ------------------------------------- ");
	System.out.println(" - Welcome: " + user.getNick() + " | " + user.getName() + " | " + user.getSecondName());
	System.out.println(" ----------------------------------------------------------------------------------------- ");
	System.out.println();
  }

  @Override
  public void displayCreateAuthorErrorMsg (int errorCode) {
	switch (errorCode) {
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
	switch (errorCode) {
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

  public void clearScreen(){
    Console.clearScreen();
  }
}
