package pl.sdacademy.library.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sdacademy.library.model.entity.Book;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AuthorDto {
  private long id;
  private String name;
  private String secondName;

  private Set<Book> books;
}
