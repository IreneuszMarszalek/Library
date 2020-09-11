package pl.sdacademy.library.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="BookTurnover")

public class BookTurnover {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private LocalDate loanDate;
  private LocalDate returnDate;
  private Integer period;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "book_id")
  private Book book;
}
