package pl.sdacademy.library.model.dao;

import pl.sdacademy.library.model.entity.Book;
import pl.sdacademy.library.model.entity.BookTurnover;

import java.util.List;

public interface BookTurnoverDao {
  void save (BookTurnover turnover);
  BookTurnover findByID(Long id);
  List<BookTurnover> findAll();
  void delete(Long id);
}
