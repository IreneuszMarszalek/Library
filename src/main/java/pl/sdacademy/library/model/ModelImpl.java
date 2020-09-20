package pl.sdacademy.library.model;
import org.mapstruct.factory.Mappers;
import pl.sdacademy.library.model.dao.AuthorDao;
import pl.sdacademy.library.model.dao.UserDao;
import pl.sdacademy.library.model.daoimpl.AuthorDaoImpl;
import pl.sdacademy.library.model.daoimpl.UserDaoImpl;
import pl.sdacademy.library.model.dto.AuthorDto;
import pl.sdacademy.library.model.dto.UserDto;
import pl.sdacademy.library.model.entity.Author;
import pl.sdacademy.library.model.entity.User;
import pl.sdacademy.library.model.mapper.AuthorMapper;
import pl.sdacademy.library.model.mapper.UserMapper;

import java.util.List;

public class ModelImpl implements Model {
  private UserDao userDao;
  private AuthorDao authorDao;
  private UserMapper userMapper;
  private AuthorMapper authorMapper;

  public ModelImpl(){
    userDao = new UserDaoImpl();
    authorDao = new AuthorDaoImpl();
    userMapper = Mappers.getMapper(UserMapper.class);
    authorMapper = Mappers.getMapper(AuthorMapper.class);
  }

  @Override
  public List<UserDto> getAllUsers () {
	List<UserDto> result = userMapper.map(userDao.findAll());
    return result;
  }

  @Override
  public UserDto getUser (Long UserId) {
    return userMapper.map(userDao.findByID(UserId));
  }

  @Override
  public UserDto getUserByNick (String nick) {
    return userMapper.map(userDao.findByNick(nick));
  }

  @Override
  public void addNewUser (UserDto userDto) {
    User user = userMapper.map(userDto);
    userDao.save(user);
  }

  @Override
  public void deleteUser (UserDto userDto) {
    User user = userMapper.map(userDto);
    userDao.delete(user.getId());
  }

  //TODO: Po zrobieniu bookturnover dto sprawdz czy uzytkonwnik ma historie
  @Override
  public boolean checkIfUserHasHistory (UserDto user) {
    return false;
  }

  @Override
  public List<AuthorDto> getAllAuthors () {
    List<AuthorDto> result = authorMapper.map(authorDao.findAll());
    return result;
  }

  @Override
  public AuthorDto getAuthor (Long authorID) {
    return authorMapper.map(authorDao.findByID(authorID));
  }

  @Override
  public void addNewAuthor (AuthorDto authorDto) {
    Author author = authorMapper.map(authorDto);
    authorDao.save(author);
  }

  @Override
  public void deleteAuthor (AuthorDto authorDto) {
    Author author = authorMapper.map(authorDto);
    authorDao.delete(author.getId());
  }

  //TODO: Po zrobieniu book dto sprawdz czy author ma ksiazke
  @Override
  public boolean checkIfAuthorHasBook (AuthorDto author) {
    return false;
  }
}
