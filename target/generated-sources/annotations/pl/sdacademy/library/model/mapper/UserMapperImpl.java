package pl.sdacademy.library.model.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import pl.sdacademy.library.model.dto.UserDto;
import pl.sdacademy.library.model.entity.BookTurnover;
import pl.sdacademy.library.model.entity.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-18T21:09:47+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8 (JetBrains s.r.o.)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User map(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setNick( userDto.getNick() );
        user.setPassword( userDto.getPassword() );
        user.setName( userDto.getName() );
        user.setSecondName( userDto.getSecondName() );
        user.setAge( userDto.getAge() );
        user.setJoiningDate( userDto.getJoiningDate() );
        user.setLeavingDate( userDto.getLeavingDate() );
        user.setActive( userDto.getActive() );
        user.setAdmin( userDto.getAdmin() );
        Set<BookTurnover> set = userDto.getTurnovers();
        if ( set != null ) {
            user.setTurnovers( new HashSet<BookTurnover>( set ) );
        }

        return user;
    }

    @Override
    public UserDto map(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setNick( user.getNick() );
        userDto.setPassword( user.getPassword() );
        userDto.setName( user.getName() );
        userDto.setSecondName( user.getSecondName() );
        userDto.setAge( user.getAge() );
        userDto.setJoiningDate( user.getJoiningDate() );
        userDto.setLeavingDate( user.getLeavingDate() );
        userDto.setActive( user.getActive() );
        userDto.setAdmin( user.getAdmin() );
        Set<BookTurnover> set = user.getTurnovers();
        if ( set != null ) {
            userDto.setTurnovers( new HashSet<BookTurnover>( set ) );
        }

        return userDto;
    }

    @Override
    public List<UserDto> map(List<User> userList) {
        if ( userList == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( userList.size() );
        for ( User user : userList ) {
            list.add( map( user ) );
        }

        return list;
    }
}
