package pl.sdacademy.library.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.sdacademy.library.model.entity.Author;
import pl.sdacademy.library.model.entity.BookTurnover;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"author", "turnovers"})

public class BookDto {
  private long id;
  private String title;
  private Author author;
  private Set<BookTurnover> turnovers;
}
