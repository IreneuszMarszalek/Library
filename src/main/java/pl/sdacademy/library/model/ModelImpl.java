package pl.sdacademy.library.model;
import org.mapstruct.factory.Mappers;
import pl.sdacademy.library.model.dao.UserDao;
import pl.sdacademy.library.model.daoimpl.UserDaoImpl;
import pl.sdacademy.library.model.dto.UserDto;
import pl.sdacademy.library.model.entity.User;
import pl.sdacademy.library.model.mapper.UserMapper;

import java.util.List;

public class ModelImpl implements Model {
  private UserDao userDao;
  private UserMapper mapper;

  public ModelImpl(){
    userDao = new UserDaoImpl();
    mapper = Mappers.getMapper(UserMapper.class);
  }

  @Override
  public List<UserDto> getAllUsers () {
	List<UserDto> result = mapper.map(userDao.findAll());
    return result;
  }

  @Override
  public UserDto getUser (Long UserId) {
    return mapper.map(userDao.findByID(UserId));
  }

  @Override
  public UserDto getUserByNick (String nick) {
    return mapper.map(userDao.findByNick(nick));
  }

  @Override
  public void addNewUser (UserDto userDto) {
    User user = mapper.map(userDto);
    userDao.save(user);
  }

  @Override
  public void deleteUser (UserDto userDto) {
    User user = mapper.map(userDto);
    userDao.delete(user.getId());
  }
}
