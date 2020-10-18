package pl.sdacademy.library.controller;

import pl.sdacademy.library.model.DataAccessor;
import pl.sdacademy.library.model.DataAccessorImpl;
import pl.sdacademy.library.model.Model;
import pl.sdacademy.library.model.ModelImpl;
import pl.sdacademy.library.model.dto.AuthorDto;
import pl.sdacademy.library.model.dto.BookDto;
import pl.sdacademy.library.model.dto.UserDto;
import pl.sdacademy.library.model.entity.Author;
import pl.sdacademy.library.view.ScreenOptions.*;
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
	if (newModel.getUserDtoByNick("ADMIN") == null) {
	  UserDto user = new UserDto();

	  user.setNick("ADMIN");
	  user.setPassword("ADMIN");
	  user.setAdmin(true);
	  user.setActive(true);
	  user.setJoiningDate(LocalDate.now());

	  newModel.addNewUserDto(user);
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

  //Actions view. Corrected !
  private void handleActionsOption () {
	ActionsScreenMenu option;
	do {
	  option = view.showActionMenuAndReturnSelectedPosition();
	  if (option != null) {
		switch (option) {
		  case ADD_USER:
			handleCreateUserOptionFromActionsMenu();
			break;
		  case DELETE_USER:
			handleDeleteUserOption();
			break;
		  case ADD_AUTHOR:
			handleAddAuthorOption();
			break;
		  case DELETE_AUTHOR:
			handleDeleteAuthorOption();
			break;
		  case ADD_BOOK:
			handleAddBookOption();
			break;
		  case DELETE_BOOK:
			handleDeleteBookOption();
			break;
		  case BORROW_BOOK:
			handleBorrowBook();
			break;
		  case GIVE_BACK_BOOK:
			handleGiveBookBackOption();
			break;
		  case BACK:
			handleMainMenuOption();
			break;
		}
	  }
	} while (option == null);
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
	  newModel.addNewUserDto(user);
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
	  newModel.addNewUserDto(user);
	}
	handleActionsOption();
  }

  //It deletes user. Corrected !
  private void handleDeleteUserOption () {
	String userIdStr = view.showDeleteUserMenuAndReturnUser();
	Long userId = checkIfUserCanBeDeleted(userIdStr);

	if (userId != -1) {
	  view.displayDeleteUserMsg(newModel.getUserDto(userId));
	  newModel.deleteUserDto(newModel.getUserDto(userId));
	}
	handleActionsOption();
  }

  //Displays users. Corrected !
  private void handleUsersReportOption () {
	view.printUserList(newModel.getAllUsersDto());
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
	  newModel.addNewAuthorDto(author);
	}
	handleActionsOption();
  }

  //It deletes Author. Corrected !
  private void handleDeleteAuthorOption () {
	String authorIdStr = view.showDeleteAuthorMenuAndReturnUser();

	Long authorId = checkIfAuthorCanBeDeleted(authorIdStr);

	if (authorId != -1) {
	  view.displayDeleteAuthorMsg(newModel.getAuthorDto(authorId));
	  newModel.deleteAuthorDto(newModel.getAuthorDto(authorId));
	}
	handleActionsOption();

  }

  //It display authors. Corrected !
  private void handleAuthorReportOption () {
	view.printAuthorList(newModel.getAllAuthorsDto());
	ContinueScreenOption option;

	do {
	  option = view.printContinue();
	} while (option != ContinueScreenOption.CONTINUE);

	handleReportsOption();
  }

  //It creates new book
  private void handleAddBookOption () {
	BookDto book = view.showCreateBookMenuAndReturnBook();

	if (checkIfBookCanBeCreated(book)) {
	  List<AuthorDto> names = newModel.getAuthorDtoByName(book.getAuthor().getName());
	  List<AuthorDto> secondNames = names
		  .stream()
		  .filter(author -> author.getSecondName().equals(book.getAuthor().getSecondName()))
		  .collect(Collectors.toList());

	  if (names.size() >= 1) {
		if (secondNames.size() == 1) {
		  book.setAuthor(newModel.getAuthor(names.get(0).getId()));
		} else {
		  newModel.addNewAuthor(book.getAuthor());
		}
	  } else {
		newModel.addNewAuthor(book.getAuthor());
	  }
	  view.displayCreateBookMsg(book);
	  newModel.addNewBookDto(book);
	}
	handleActionsOption();
  }

  //Displays books list. Corrected!
  private void handleBooksReportOption () {
	view.printBookList(newModel.getAllBooksDto());
	ContinueScreenOption option;

	do {
	  option = view.printContinue();
	} while (option != ContinueScreenOption.CONTINUE);

	handleReportsOption();
  }

  private void handleDeleteBookOption(){
  }

  private void handleBorrowedReportOption () {
    view.printBorrowedBookList(newModel.getAllBorrowedBooks());
	ContinueScreenOption option;

	do {
	  option = view.printContinue();
	} while (option != ContinueScreenOption.CONTINUE);

	handleReportsOption();
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
	  if (newModel.getUserDto(userId) == null) {
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
		if (newModel.getUserDtoByNick(nick) != null) {
		  view.displayCreateUserErrorMsg(1);
		  return false;
		} else {
		  return true;
		}
	  }
	}
  }

  //Check if User can be log in
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
		if (newModel.getUserDtoByNick(nick) == null) {
		  view.displayLoginErrorMsg(1);
		  return false;
		} else {
		  Long foundUserId = newModel.getUserDtoByNick(nick).getId();
		  String foundPassword = newModel.getUserDto(foundUserId).getPassword();
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

  //Check if author can be created
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
	  Author author = newModel.getAuthor(authorId);
	  if (author == null) {
		view.displayDeleteAuthorErrorMsg(2);
		return -1;
	  } else {
		if (newModel.checkIfAuthorHasBook(author)) {
		  view.displayDeleteAuthorErrorMsg(3);
		  return -1;
		} else {
		  return authorId;
		}
	  }
	}
  }

  private boolean checkIfBookCanBeCreated (BookDto book) {
	if (book.getTitle() == null) {
	  view.displayCreateBookErrorMsg(1);
	  return false;
	} else {
	  if (book.getAuthor() == null) {
		view.displayCreateBookErrorMsg(2);
		return false;
	  } else {
		return true;
	  }
	}
  }
}


