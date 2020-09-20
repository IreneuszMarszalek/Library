package pl.sdacademy.library.model.mapper;

import org.mapstruct.Mapper;
import pl.sdacademy.library.model.dto.AuthorDto;
import pl.sdacademy.library.model.dto.BookDto;
import pl.sdacademy.library.model.entity.Author;
import pl.sdacademy.library.model.entity.Book;

import java.util.List;

@Mapper
public interface BookMapper {
  Book map(BookDto bookDto);
  BookDto map(Book book);
  List<BookDto> map(List<Book> bookList);
}
