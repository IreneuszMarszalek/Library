package pl.sdacademy.library.model.mapper;

import org.mapstruct.Mapper;
import pl.sdacademy.library.model.dto.BookTurnoverDto;
import pl.sdacademy.library.model.entity.BookTurnover;

import java.util.List;

@Mapper
public interface BookTurnoverMapper {
  BookTurnover map(BookTurnoverDto bookTurnoverDto);
  BookTurnoverDto map(BookTurnover bookTurnover);
  List<BookTurnoverDto> map(List<BookTurnover> bookTurnovers);
}
