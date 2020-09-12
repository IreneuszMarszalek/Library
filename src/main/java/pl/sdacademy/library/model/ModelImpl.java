package pl.sdacademy.library.model;

import org.mapstruct.factory.Mappers;
import pl.sdacademy.library.model.Model;
import pl.sdacademy.library.model.dao.UserDao;
import pl.sdacademy.library.model.daoimpl.UserDaoImpl;
import pl.sdacademy.library.model.dto.UserDto;
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
  public void addNewUser (UserDto userDto) {

  }
}
