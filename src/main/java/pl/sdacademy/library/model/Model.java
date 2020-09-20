package pl.sdacademy.library.model;

import pl.sdacademy.library.model.dto.AuthorDto;
import pl.sdacademy.library.model.dto.BookDto;
import pl.sdacademy.library.model.dto.UserDto;
import pl.sdacademy.library.model.entity.Author;

import java.util.List;

public interface Model {

  List<UserDto> getAllUsers();
  UserDto getUser(Long userId);
  void addNewUser(UserDto userDto);
  UserDto getUserByNick(String nick);
  void deleteUser(UserDto userDto);
  boolean checkIfUserHasHistory(UserDto user); //TODO: Potrzebne do usuwania uzytkownika

  List<AuthorDto> getAllAuthors();
  AuthorDto getAuthorDto(Long authorID);
  Author getAuthor(Long authorID);
  List<AuthorDto> getAuthorByName(String name);
  void addNewAuthorDto(AuthorDto authorDto);
  void addNewAuthor(Author author);
  void deleteAuthor(AuthorDto authorDto);
  boolean checkIfAuthorHasBook(AuthorDto author); // TODO: Potrzbne do usuwania authora

  List<BookDto> getAllBooks();
  BookDto getBook(Long bookId);
  void addNewBook(BookDto bookDto);
  void deleteBook(BookDto bookDto);
}
