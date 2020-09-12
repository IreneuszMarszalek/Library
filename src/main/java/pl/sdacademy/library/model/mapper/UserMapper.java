package pl.sdacademy.library.model.mapper;

import org.mapstruct.Mapper;
import pl.sdacademy.library.model.dto.UserDto;
import pl.sdacademy.library.model.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {
	User map(UserDto userDto);
	UserDto map(User user);
	List<UserDto> map(List<User> userList);
}
