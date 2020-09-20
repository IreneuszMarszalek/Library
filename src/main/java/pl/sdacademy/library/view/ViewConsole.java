package pl.sdacademy.library.view;
import pl.sdacademy.library.model.dao.AuthorDao;
import pl.sdacademy.library.model.dto.AuthorDto;
import pl.sdacademy.library.model.dto.BookDto;
import pl.sdacademy.library.model.dto.UserDto;
import pl.sdacademy.library.model.entity.Author;
import pl.sdacademy.library.model.entity.Book;
import pl.sdacademy.library.model.utils.Console;
import pl.sdacademy.library.view.ScreenOptions.*;

//TODO: enum dla menu
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class ViewConsole implements View {
  // It defines Welcome Menu view. Corrected !
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

  // It defines Log In Menu view. Corrected !
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

  // It defines Create User Menu view. Corrected !
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

	return user;
  }
  // It defines Delete User Menu view. Corrected !
  @Override
  public String showDeleteUserMenuAndReturnUser(){
	System.out.println(" ----------------------------------------------------------------------------------------- ");
	System.out.println(" ------------------------------------- Delete User  -------------------------------------- ");
	System.out.println(" ----------------------------------------------------------------------------------------- ");

	String userID;

	Scanner scanner = new Scanner(System.in);
	System.out.print(" - Provide ID: ");
	userID = scanner.nextLine();

	return userID;
  }

  //It prints all users. Corrected !
  public void printUserList (List<UserDto> userList) {
	System.out.println(" ----------------------------------------------------------------------------------------- ");
	System.out.println(" -------------------------------------- Users List  -------------------------------------- ");
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
	System.out.println(" - [A] Author | [D] Delete User [E] dElete author ----");
	System.out.println(" ------------------- Make a choice ------------------- ");
	System.out.println(" -------------------- Or [C] baCk -------------------- ");
	System.out.print(" -->:");

	Scanner scanner = new Scanner(System.in);

	return scanner.nextLine();
  }

  // It defines Reports Menu view. Corrected!
  @Override
  public ReportsMenuScreenOption showReportMenuAndReturnSelectedPosition () {
	System.out.println(" ----------------------------------------------------------------------------------------- ");
	System.out.println(" ------------------------------------- Reports menu -------------------------------------- ");
	System.out.println(" ----------------------------------------------------------------------------------------- ");
	System.out.println(" -------------- ["
		+ ReportsMenuScreenOption.USERS.label
		+ "] Users | ["
		+ ReportsMenuScreenOption.BOOKS.label
		+ "] Books | ["
		+ ReportsMenuScreenOption.BORROWED.label
		+ "] bOrrowed | ["
		+ ReportsMenuScreenOption.AUTHORS.label
		+ "] Authors | ["
		+ ReportsMenuScreenOption.BACK.label
		+ "] baCk ------------- ");
	System.out.println(" ----------------------------------------------------------------------------------------- ");
	System.out.print(" : ");

	Scanner scanner = new Scanner(System.in);
	ReportsMenuScreenOption result = ReportsMenuScreenOption.valueOfLabel(scanner.nextLine());
	System.out.println();

	return result;
  }

  //It defines Create Author Menu view
  @Override
  public AuthorDto showCreateAuthorMenuAndReturnAuthor () {
	System.out.println(" ----------------------------------------------------------------------------------------- ");
	System.out.println(" ------------------------------------ Create Author  ------------------------------------- ");
	System.out.println(" ----------------------------------------------------------------------------------------- ");

	AuthorDto author = new AuthorDto();

	Scanner scanner = new Scanner(System.in);
	System.out.print(" - Name: ");
	author.setName(scanner.nextLine());
	System.out.print(" - 2nd name: ");
	author.setSecondName(scanner.nextLine());

	return author;
  }

  @Override
  public String showDeleteAuthorMenuAndReturnUser () {
	System.out.println(" ----------------------------------------------------------------------------------------- ");
	System.out.println(" ------------------------------------ Delete author  ------------------------------------- ");
	System.out.println(" ----------------------------------------------------------------------------------------- ");

	String authorID;

	Scanner scanner = new Scanner(System.in);
	System.out.print(" - Provide ID: ");
	authorID = scanner.nextLine();

	return authorID;
  }

  //It prints all authors. Corrected !
  public void printAuthorList (List<AuthorDto> authorList) {
	System.out.println(" ----------------------------------------------------------------------------------------- ");
	System.out.println(" ------------------------------------- Authors List  ------------------------------------- ");
	System.out.println(" ----------------------------------------------------------------------------------------- ");
	System.out.println(" - ID | Name | Second Name | ------------------------------------------------------------- ");
	System.out.println(" ----------------------------------------------------------------------------------------- ");
	authorList
		.stream()
		.forEach(authorDto -> System.out.println(
			" - "
				+ authorDto.getId()
				+ " | "
				+ authorDto.getName()
				+ " | "
				+ authorDto.getSecondName()
			)
		);
	System.out.println(" ----------------------------------------------------------------------------------------- ");
  }

  @Override
  public BookDto showCreateBookMenuAndReturnBook () {
	System.out.println(" ----------------------------------------------------------------------------------------- ");
	System.out.println(" ------------------------------------ Create  Book  -------------------------------------- ");
	System.out.println(" ----------------------------------------------------------------------------------------- ");

	BookDto book = new BookDto();
	Author author = new Author();

	Scanner scanner = new Scanner(System.in);
	System.out.print(" - Title: ");
	book.setTitle(scanner.nextLine());
	System.out.print(" - Author (Name): ");
	author.setName(scanner.nextLine());
	System.out.print(" - Author (2nd name): ");
	author.setSecondName(scanner.nextLine());
	book.setAuthor(author);

	return book;
  }

  //It prints all books. Corrected !
  public void printBookList (List<BookDto> bookList) {
	System.out.println(" ----------------------------------------------------------------------------------------- ");
	System.out.println(" -------------------------------------- Books List  -------------------------------------- ");
	System.out.println(" ----------------------------------------------------------------------------------------- ");
	System.out.println(" - ID | Title | Author | ----------------------------------------------------------------- ");
	System.out.println(" ----------------------------------------------------------------------------------------- ");
	bookList
		.stream()
		.map(bookDto -> {
		  if(bookDto.getAuthor() == null){
			bookDto.setAuthor(new Author());
		  }
		  return bookDto;
		})
		.forEach(bookDto -> System.out.println(
			" - "
				+ bookDto.getId()
				+ " | "
				+ bookDto.getTitle()
				+ " | "
				+ bookDto.getAuthor().getName() + " " + bookDto.getAuthor().getSecondName()
			)
		);
	System.out.println(" ----------------------------------------------------------------------------------------- ");
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

  @Override
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

  @Override
  public void displayDeleteAuthorErrorMsg(int errorCode){
	switch (errorCode) {
	  case 1:
		System.out.println(" -------------------------------------- !! ERROR !! -------------------------------------- ");
		System.out.println(" - Not numeric provided");
		System.out.println(" ----------------------------------------------------------------------------------------- ");
		System.out.println();
		break;
	  case 2:
		System.out.println(" -------------------------------------- !! ERROR !! -------------------------------------- ");
		System.out.println(" - Wrong author ID provided");
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

  @Override
  public void displayCreateUserMsg (UserDto user) {
	System.out.println(" ------------------------------------- !! SUCCESS !! ------------------------------------- ");
	System.out.println(" - User: " + user.getNick() + " | " + user.getName() + " | " + user.getSecondName() + " created");
	System.out.println(" ----------------------------------------------------------------------------------------- ");
	System.out.println();
  }

  @Override
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
  public void displayCreateBookMsg (BookDto book) {
	System.out.println(" ------------------------------------- !! SUCCESS !! ------------------------------------- ");
	System.out.println(" - Book: " + book.getTitle() + " | " + book.getAuthor().getName() + " | " + book.getAuthor().getSecondName() + " created");
	System.out.println(" ----------------------------------------------------------------------------------------- ");
	System.out.println();
  }

  @Override
  public void displayCreateAuthorErrorMsg (int errorCode) {
	switch (errorCode) {
	  case 1:
		System.out.println(" -------------------------------------- !! ERROR !! -------------------------------------- ");
		System.out.println(" - Incorrect name");
		System.out.println(" ----------------------------------------------------------------------------------------- ");
		System.out.println();
		break;
	  case 2:
		System.out.println(" -------------------------------------- !! ERROR !! -------------------------------------- ");
		System.out.println(" - Incorrect second name");
		System.out.println(" ----------------------------------------------------------------------------------------- ");
		break;
	  default:
		System.out.println(" -------------------------------------- !! ERROR !! -------------------------------------- ");
		System.out.println(" - Unknown error");
		System.out.println(" ----------------------------------------------------------------------------------------- ");
	}
  }

  public void displayDeleteAuthorMsg (AuthorDto author) {
	System.out.println(" ------------------------------------- !! SUCCESS !! ------------------------------------- ");
	System.out.println(" - Author: " +  " | " + author.getName() + " | " + author.getSecondName() + " deleted");
	System.out.println(" ----------------------------------------------------------------------------------------- ");
	System.out.println();
  }

  public void displayCreateBookErrorMsg (int errorCode) {
	switch (errorCode) {
	  case 1:
		System.out.println(" -------------------------------------- !! ERROR !! -------------------------------------- ");
		System.out.println(" - Incorrect title");
		System.out.println(" ----------------------------------------------------------------------------------------- ");
		System.out.println();
	  case 2:
		System.out.println(" -------------------------------------- !! ERROR !! -------------------------------------- ");
		System.out.println(" - Incorrect author");
		System.out.println(" ----------------------------------------------------------------------------------------- ");
		System.out.println();
	  default:
		System.out.println(" -------------------------------------- !! ERROR !! -------------------------------------- ");
		System.out.println(" - Unknown error");
		System.out.println(" ----------------------------------------------------------------------------------------- ");
	}
  }

  public void clearScreen(){
    Console.clearScreen();
  }
}
