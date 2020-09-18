package pl.sdacademy.library.model.entity;

import javax.persistence.*;
import java.util.Set;

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

  public long getId () {
    return id;
  }

  public void setId (long id) {
    this.id = id;
  }

  public String getName () {
    return name;
  }

  public void setName (String name) {
    this.name = name;
  }

  public String getSecondName () {
    return secondName;
  }

  public void setSecondName (String secondName) {
    this.secondName = secondName;
  }

  public Set<Book> getBooks () {
    return books;
  }

  public void setBooks (Set<Book> books) {
    this.books = books;
  }
}
