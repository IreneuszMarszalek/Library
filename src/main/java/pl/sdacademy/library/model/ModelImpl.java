package pl.sdacademy.library.model;
import org.mapstruct.factory.Mappers;
import pl.sdacademy.library.model.dao.AuthorDao;
import pl.sdacademy.library.model.dao.BookDao;
import pl.sdacademy.library.model.dao.BookTurnoverDao;
import pl.sdacademy.library.model.dao.UserDao;
import pl.sdacademy.library.model.daoimpl.AuthorDaoImpl;
import pl.sdacademy.library.model.daoimpl.BookDaoImpl;
import pl.sdacademy.library.model.daoimpl.UserDaoImpl;
import pl.sdacademy.library.model.dto.AuthorDto;
import pl.sdacademy.library.model.dto.BookDto;
import pl.sdacademy.library.model.dto.BookTurnoverDto;
import pl.sdacademy.library.model.dto.UserDto;
import pl.sdacademy.library.model.entity.Author;
import pl.sdacademy.library.model.entity.Book;
import pl.sdacademy.library.model.entity.BookTurnover;
import pl.sdacademy.library.model.entity.User;
import pl.sdacademy.library.model.mapper.AuthorMapper;
import pl.sdacademy.library.model.mapper.BookMapper;
import pl.sdacademy.library.model.mapper.BookTurnoverMapper;
import pl.sdacademy.library.model.mapper.UserMapper;

import java.util.List;

public class ModelImpl implements Model {
  private UserDao userDao;
  private AuthorDao authorDao;
  private BookDao bookDao;
  private BookTurnoverDao bookTurnoverDao;
  private UserMapper userMapper;
  private AuthorMapper authorMapper;
  private BookMapper bookMapper;
  private BookTurnoverMapper bookTurnoverMapper;

  public ModelImpl(){
    userDao = new UserDaoImpl();
    authorDao = new AuthorDaoImpl();
    bookDao = new BookDaoImpl();
    userMapper = Mappers.getMapper(UserMapper.class);
    authorMapper = Mappers.getMapper(AuthorMapper.class);
    bookMapper = Mappers.getMapper(BookMapper.class);
    bookTurnoverMapper = Mappers.getMapper(BookTurnoverMapper.class);
  }

  @Override
  public List<UserDto> getAllUsersDto () {
	List<UserDto> result = userMapper.map(userDao.findAll());
    return result;
  }

  @Override
  public UserDto getUserDto (Long UserId) {
    return userMapper.map(userDao.findByID(UserId));
  }

  @Override
  public UserDto getUserDtoByNick (String nick) {
    return userMapper.map(userDao.findByNick(nick));
  }

  @Override
  public void addNewUserDto (UserDto userDto) {
    User user = userMapper.map(userDto);
    userDao.save(user);
  }

  @Override
  public void deleteUserDto (UserDto userDto) {
    User user = userMapper.map(userDto);
    userDao.delete(user.getId());
  }

  //TODO: Po zrobieniu bookturnover dto sprawdz czy uzytkonwnik ma historie
  @Override
  public boolean checkIfUserHasHistory (UserDto user) {
    return false;
  }

  @Override
  public List<AuthorDto> getAllAuthorsDto () {
    List<AuthorDto> result = authorMapper.map(authorDao.findAll());
    return result;
  }

  @Override
  public AuthorDto getAuthorDto (Long authorID) {
    return authorMapper.map(authorDao.findByID(authorID));
  }

  public Author getAuthor (Long authorID) {
    return authorDao.findByID(authorID);
  }

  public List<AuthorDto> getAuthorDtoByName (String name){
    return authorMapper.map(authorDao.findByName(name));
  }

  @Override
  public void addNewAuthorDto (AuthorDto authorDto) {
    Author author = authorMapper.map(authorDto);
    authorDao.save(author);
  }

  @Override
  public void addNewAuthor (Author author) {
    authorDao.save(author);
  }

  @Override
  public void deleteAuthorDto (AuthorDto authorDto) {
    Author author = authorMapper.map(authorDto);
    authorDao.delete(author.getId());
  }

  @Override
  public boolean checkIfAuthorDtoHasBook (AuthorDto authorDto) {
    Author author = authorMapper.map(getAuthorDto(authorDto.getId()));
    if(author != null){
      return true;
    }else{
      return false;
    }
  }

  @Override
  public boolean checkIfAuthorHasBook (Author author) {
    if(getAuthor(author.getId()) != null){
      return true;
    }else{
      return false;
    }
  }

  @Override
  public List<BookDto> getAllBooksDto () {
    List<BookDto> result = bookMapper.map(bookDao.findAll());
    return result;
  }

  @Override
  public BookDto getBookDto (Long bookId) {
    return bookMapper.map(bookDao.findByID(bookId));
  }

  @Override
  public void addNewBookDto (BookDto bookDto) {
    Book book = bookMapper.map(bookDto);
    bookDao.save(book);
  }

  @Override
  public void deleteBookDto (BookDto bookDto) {
    Book book = bookMapper.map(bookDto);
    bookDao.delete(book.getId());
  }

  @Override
  public List<BookTurnoverDto> getAllTurnOvers () {
    List<BookTurnoverDto> result = bookTurnoverMapper.map(bookTurnoverDao.findAll());
    return result;
  }

  @Override
  public List<BookTurnoverDto> getAllBorrowedBooks () {
    List<BookTurnoverDto> result =bookTurnoverMapper.map(bookTurnoverDao.findAllBorrowedBooks());
    return result;
  }

  @Override
  public List<BookTurnoverDto> getAllNotBorrowedBooks () {
    List<BookTurnoverDto> result =bookTurnoverMapper.map(bookTurnoverDao.findAllNotBorrowedBooks());
    return result;
  }
}
