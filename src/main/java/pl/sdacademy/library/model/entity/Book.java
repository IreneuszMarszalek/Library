package pl.sdacademy.library.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"author", "turnovers"})

@Entity
@Table(name="Book")
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String title;

  @ManyToOne
  @JoinColumn(name = "author_id")
  private Author author;

  @OneToMany(mappedBy = "book")
  private Set<BookTurnover> turnovers;
}
