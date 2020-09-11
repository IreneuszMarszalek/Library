package pl.sdacademy.library.model.dao;

import pl.sdacademy.library.model.entity.Book;

import java.util.List;

public interface BookDao {
  void save (Book book);
  Book findByID(Long id);
  List<Book> findAll();
  void delete(Long id);
}
