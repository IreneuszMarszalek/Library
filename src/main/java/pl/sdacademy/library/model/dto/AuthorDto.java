package pl.sdacademy.library.model.dto;

import pl.sdacademy.library.model.entity.Book;

import java.util.Set;

public class AuthorDto {
  private long id;
  private String name;
  private String secondName;

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

  private Set<Book> books;
}
