package pl.sdacademy.library.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.sdacademy.library.model.entity.Book;
import pl.sdacademy.library.model.entity.User;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"user", "book"})

public class BookTurnoverDto {
  private long id;

  private LocalDate loanDate;
  private LocalDate returnDate;
  private Integer period;

  private User user;

  private Book book;
}
