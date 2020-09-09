package pl.sdacademy.library.model.dao;

import pl.sdacademy.library.model.entity.Author;
import java.util.List;

public interface AuthorDao {
  void save (Author author);
  Author findByID(Long id);
  List<Author> findAll();
  void delete(Long id);
}
