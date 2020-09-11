package pl.sdacademy.library.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="Author")

public class Author {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String name;
  private String secondName;

  @OneToMany(mappedBy = "author")
  private Set<Book> books;

  @OneToMany(mappedBy = "author")
  private Set<BookTurnover> turnovers;
}
