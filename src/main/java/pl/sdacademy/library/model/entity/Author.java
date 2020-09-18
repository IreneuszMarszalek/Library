package pl.sdacademy.library.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Author")

@Data
@AllArgsConstructor
@NoArgsConstructor

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
