package pl.sdacademy.library.model.mapper;

import org.mapstruct.Mapper;
import pl.sdacademy.library.model.dto.AuthorDto;
import pl.sdacademy.library.model.entity.Author;

import java.util.List;

@Mapper
public interface AuthorMapper {
  Author map(AuthorDto authorDto);
  AuthorDto map(Author author);
  List<AuthorDto> map(List<Author> authorList);
}
