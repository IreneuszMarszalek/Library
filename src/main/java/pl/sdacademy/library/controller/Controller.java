package pl.sdacademy.library.controller;

import pl.sdacademy.library.model.DataAccessor;
import pl.sdacademy.library.model.DataAccessorImpl;
import pl.sdacademy.library.model.Model;
import pl.sdacademy.library.model.ModelImpl;
import pl.sdacademy.library.model.dto.AuthorDto;
import pl.sdacademy.library.model.dto.UserDto;
import pl.sdacademy.library.model.entity.Author;
import pl.sdacademy.library.model.entity.Book;
import pl.sdacademy.library.view.ScreenOptions.ContinueScreenOption;
import pl.sdacademy.library.view.ScreenOptions.MainMenuScreenOption;
import pl.sdacademy.library.view.ScreenOptions.ReportsMenuScreenOption;
import pl.sdacademy.library.view.ScreenOptions.WelcomeMenuScreenOption;
import pl.sdacademy.library.view.View;
import pl.sdacademy.library.view.ViewConsole;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
  private final View view;
  //TODO: Przerob DataAccessora na Model.
  private final DataAccessor model;
  private final Model newModel;

  public Controller () {
	view = new ViewConsole();
	model = new DataAccessorImpl(); // stara i zła implementacja
	newModel = new ModelImpl(); // zmigruj na tą implemetację
  }

  // ------------- START -------------
  //Starting Point. Welcome menu. Corrected !
  public void start () {
	WelcomeMenuScreenOption option;
	do {
	  option = view.showWelcomeMenuAndReturnSelectedPosition();
	  if (option != null) {
		switch (option) {
		  case LOG_IN:
			handleLogInOption();
			break;
		  case CREATE_USER:
			handleCreateUserOptionFromWelcomeVIew();
			break;
		}
	  }
	} while (option == null);
  }

  // ------------- INIT -------------
  //It creates default user, Corrected !
  public void init () {
	if (newModel.getUserByNick("ADMIN") == null) {
	  UserDto user = new UserDto();

	  user.setNick("ADMIN");
	  user.setPassword("ADMIN");
	  user.setAdmin(true);
	  user.setActive(true);
	  user.setJoiningDate(LocalDate.now());

	  newModel.addNewUser(user);
	}
  }

  // ------------- VIEWS DEFINITION -------------
  // Main Menu View. Corrected!
  private void handleMainMenuOption () {
	MainMenuScreenOption option;
	do {
	  option = view.showMainMenuAndReturnSelectedPositions();
	  if (option != null) {
		switch (option) {
		  case ACTIONS:
			handleActionsOption();
			break;
		  case REPORTS:
			handleReportsOption();
			break;
		  case SETTINGS:
			handleSettingsOption();
			break;
		}
	  }
	} while (option == null);
  }

  //Reports view. Corrected!
  private void handleReportsOption () {
	ReportsMenuScreenOption option;
	do {
	  option = view.showReportMenuAndReturnSelectedPosition();
	  if (option != null) {
		switch (option) {
		  case USERS:
			handleUsersReportOption();
			break;
		  case BOOKS:
			handleBooksReportOption();
			break;
		  case BORROWED:
			handleBorrowedReportOption();
			break;
		  case AUTHORS:
			handleAuthorReportOption();
			break;
		  case BACK:
			handleMainMenuOption();
			break;
		}
	  }
	} while (option == null);
  }

  //Actions view
  private void handleActionsOption () {
	String option;
	do {
	  option = view.showActionMenuAndReturnSelectedPosition();
	  switch (option) {
		case "B":
		case "b":
		  handleAddBookOption();
		  break;
		case "U":
		case "u":
		  handleCreateUserOptionFromActionsMenu();
		  break;
		case "O":
		case "o":
		  handleBorrowBook();
		  break;
		case "G":
		case "g":
		  handleGiveBookBackOption();
		  break;
		case "C":
		case "c":
		  handleMainMenuOption();
		  break;
		case "A":
		case "a":
		  handleAddAuthorOption();
		  break;
		case "D":
		case "d":
		  handleDeleteUserOption();
		  break;
		case "E":
		case "e":
		  handleDeleteAuthorOption();
		  break;

	  }
	} while (
		(!("B".equalsIgnoreCase(option)))
			&& (!("U".equalsIgnoreCase(option)))
			&& (!("O".equalsIgnoreCase(option)))
			&& (!("G".equalsIgnoreCase(option)))
			&& (!("C".equalsIgnoreCase(option)))
			&& (!("A".equalsIgnoreCase(option)))
			&& (!("D".equalsIgnoreCase(option)))
			&& (!("E".equalsIgnoreCase(option)))
	);
  }

  private void handleSettingsOption () {
  }


  // ------------- MENU OPTIONS -------------
  //Login. Corrected !
  private void handleLogInOption () {
	UserDto user = view.showLogInMenuAndReturnResult();

	if (checkIfUserCanLogIn(user)) {
	  view.displayLoginMsg(user);
	  handleMainMenuOption();
	} else {
	  start();
	}
  }

  //It creates user from Welcome menu. Corrected !
  private void handleCreateUserOptionFromWelcomeVIew () {
	UserDto user = view.showCreateUserMenuAndReturnUser();

	if (checkIfUserCanBeCreated(user)) {
	  view.displayCreateUserMsg(user);
	  newModel.addNewUser(user);
	  handleMainMenuOption();
	} else {
	  start();
	}
  }

  //It creates user from action menu. Corrected !
  private void handleCreateUserOptionFromActionsMenu () {
	UserDto user = view.showCreateUserMenuAndReturnUser();

	if (checkIfUserCanBeCreated(user)) {
	  view.displayCreateUserMsg(user);
	  newModel.addNewUser(user);
	}
	handleActionsOption();
  }

  //It deletes user. Corrected !
  private void handleDeleteUserOption () {
	String userIdStr = view.showDeleteUserMenuAndReturnUser();
	Long userId = checkIfUserCanBeDeleted(userIdStr);

	if (userId != -1) {
	  view.displayDeleteUserMsg(newModel.getUser(userId));
	  newModel.deleteUser(newModel.getUser(userId));
	}
	handleActionsOption();

  }

  //Displays users. Corrected !
  private void handleUsersReportOption () {
	view.printUserList(newModel.getAllUsers());
	ContinueScreenOption option;

	do {
	  option = view.printContinue();
	} while (option != ContinueScreenOption.CONTINUE);

	handleReportsOption();
  }

  //It creates Author. Corrected !
  private void handleAddAuthorOption () {
	AuthorDto author = view.showCreateAuthorMenuAndReturnAuthor();

	if (checkIfAuthorCanBeCreated(author)) {
	  newModel.addNewAuthor(author);
	}
	handleActionsOption();
  }

  private void handleDeleteAuthorOption(){
	String authorIdStr = view.showDeleteAuthorMenuAndReturnUser();

	Long authorId = checkIfAuthorCanBeDeleted(authorIdStr);

	if (authorId != -1) {
	  view.displayDeleteAuthorMsg(newModel.getAuthor(authorId));
	  newModel.deleteAuthor(newModel.getAuthor(authorId));
	}
	handleActionsOption();

  }

  //It display authors. Corrected !
  private void handleAuthorReportOption () {
	view.printAuthorList(newModel.getAllAuthors());
	ContinueScreenOption option;

	do {
	  option = view.printContinue();
	} while (option != ContinueScreenOption.CONTINUE);

	handleReportsOption();
  }

  //It creates new book
  private void handleAddBookOption () {
	Book book = view.showCreateBookMenuAndReturnBook();
	if (book.getTitle() == null) {
	  view.displayCreateBookErrorMsg(1);
	} else {
	  if (book.getAuthor() == null) {
		view.displayCreateBookErrorMsg(2);
	  } else {
		List<Author> names = model
			.getAuthorDao()
			.findByName(book.getAuthor().getName());
		List<Author> secondNames = names
			.stream()
			.filter(author -> author.getSecondName().equals(book.getAuthor().getSecondName()))
			.collect(Collectors.toList());

		if (names.size() >= 1) {
		  if (secondNames.size() == 1) {
			book.setAuthor(model.getAuthorDao().findByID(names.get(0).getId()));
		  } else {
			model.getAuthorDao().save(book.getAuthor());
		  }
		} else {
		  model.getAuthorDao().save(book.getAuthor());
		}
		model.getBookDao().save(book);
	  }
	}
	handleActionsOption();
  }

  //Display users list
  private void handleBooksReportOption () {
	model.
		getBookDao()
		.findAll()
		.forEach(book -> System.out.println(book.getId() + " " + book.getTitle() + " " + book.getAuthor().getName() + " " + book.getAuthor().getSecondName()));
	handleReportsOption();
  }

  private void handleBorrowedReportOption () {

  }

  private void handleGiveBookBackOption () {
  }

  private void handleBorrowBook () {
  }

  // ------------- DATA VALIDATIONS -------------
  //Check if User can be deleted
  private long checkIfUserCanBeDeleted (String userIdStr) {

	Long userId;

	if (!(userIdStr.matches("\\d*"))) {
	  view.displayDeleteUserErrorMsg(1);
	  return -1;
	} else {
	  userId = Long.parseLong(userIdStr);
	  if (newModel.getUser(userId) == null) {
		view.displayDeleteUserErrorMsg(2);
		return -1;
	  } else {
		//TODO: Sprawdz czy uzytkownik ma historie
		return userId;
	  }
	}
  }

  //Check if User can be created
  private boolean checkIfUserCanBeCreated (UserDto user) {

	String nick = user.getNick();
	String password = user.getPassword();

	if (nick == null) {
	  view.displayCreateUserErrorMsg(1);
	  return false;
	} else {
	  if (password == null) {
		view.displayCreateUserErrorMsg(2);
		return false;
	  } else {
		if (newModel.getUserByNick(nick) != null) {
		  view.displayCreateUserErrorMsg(1);
		  return false;
		} else {
		  return true;
		}
	  }
	}
  }

  private boolean checkIfUserCanLogIn (UserDto user) {
	String nick = user.getNick();
	String password = user.getPassword();

	if (nick == null) {
	  view.displayLoginErrorMsg(1);
	  return false;
	} else {
	  if (password == null) {
		view.displayLoginErrorMsg(2);
		return false;
	  } else {
		if (newModel.getUserByNick(nick) == null) {
		  view.displayLoginErrorMsg(1);
		  return false;
		} else {
		  Long foundUserId = newModel.getUserByNick(nick).getId();
		  String foundPassword = newModel.getUser(foundUserId).getPassword();
		  if (password.equals(foundPassword)) {
			return true;
		  } else {
			view.displayLoginErrorMsg(2);
			return false;
		  }
		}
	  }
	}
  }

  private boolean checkIfAuthorCanBeCreated (AuthorDto author) {
	if (author.getName() == null) {
	  view.displayCreateAuthorErrorMsg(1);
	  return false;
	} else {
	  if (author.getSecondName() == null) {
		view.displayCreateAuthorErrorMsg(2);
		return false;
	  } else {
		return true;
	  }
	}

  }
  //Check if Author can be deleted
  private long checkIfAuthorCanBeDeleted (String authorIdStr) {

	Long authorId;

	if (!(authorIdStr.matches("\\d*"))) {
	  view.displayDeleteAuthorErrorMsg(1);
	  return -1;
	} else {
	  authorId = Long.parseLong(authorIdStr);
	  if (newModel.getAuthor(authorId) == null) {
		view.displayDeleteAuthorErrorMsg(2);
		return -1;
	  } else {
		//TODO: Sprawdz czy uzytkownik ma przypisane książki
		return authorId;
	  }
	}
  }
}


