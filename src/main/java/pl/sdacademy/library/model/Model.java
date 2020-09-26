package pl.sdacademy.library.model;

import pl.sdacademy.library.model.dto.AuthorDto;
import pl.sdacademy.library.model.dto.BookDto;
import pl.sdacademy.library.model.dto.BookTurnoverDto;
import pl.sdacademy.library.model.dto.UserDto;
import pl.sdacademy.library.model.entity.Author;

import java.util.List;

public interface Model {

  List<UserDto> getAllUsersDto ();
  UserDto getUserDto (Long userId);
  void addNewUserDto (UserDto userDto);
  UserDto getUserDtoByNick (String nick);
  void deleteUserDto (UserDto userDto);
  boolean checkIfUserHasHistory(UserDto user); //TODO: Potrzebne do usuwania uzytkownika

  List<AuthorDto> getAllAuthorsDto ();
  AuthorDto getAuthorDto(Long authorId);
  Author getAuthor(Long authorId);
  List<AuthorDto> getAuthorDtoByName (String name);
  void addNewAuthorDto(AuthorDto authorDto);
  void addNewAuthor(Author author);
  void deleteAuthorDto (AuthorDto authorDto);
  boolean checkIfAuthorDtoHasBook (AuthorDto authorDto);
  boolean checkIfAuthorHasBook (Author author);

  List<BookDto> getAllBooksDto ();
  BookDto getBookDto (Long bookId);
  void addNewBookDto (BookDto bookDto);
  void deleteBookDto (BookDto bookDto);

  List<BookTurnoverDto> getAllTurnOvers();
  List<BookTurnoverDto> getAllBorrowedBooks();
  List<BookTurnoverDto> getAllNotBorrowedBooks();
}
