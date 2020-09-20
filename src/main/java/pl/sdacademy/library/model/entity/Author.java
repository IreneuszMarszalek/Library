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
@EqualsAndHashCode(exclude = {"books"})

@Entity
@Table(name="Author")

//TODO: dodaj DTO.
//TODO: korzystamy z dao ale zwracamy dto.
public class Author {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String name;
  private String secondName;

  @OneToMany(mappedBy = "author")
  private Set<Book> books;
}
