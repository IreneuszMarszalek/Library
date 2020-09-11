package pl.sdacademy.library.model.daoimpl;

import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdacademy.library.model.dao.AuthorDao;
import pl.sdacademy.library.model.dao.BookDao;
import pl.sdacademy.library.model.entity.Author;
import pl.sdacademy.library.model.entity.Book;
import pl.sdacademy.library.utils.HibernateUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookDaoImplTest {
  @BeforeEach
  void clearBeforeEach(){
    Session session = HibernateUtils
        .getInstance()
        .GetSessionFactory()
        .getCurrentSession();

    session.beginTransaction();
    session.createSQLQuery("delete from BookTurnover").executeUpdate();
    session.createSQLQuery("delete from Book").executeUpdate();
    session.createSQLQuery("delete from Author").executeUpdate();
    session.getTransaction().commit();
    session.close();
  }

  @Test
  void save () {
    BookDao dao = new BookDaoImpl();
    AuthorDao daoAuthor = new AuthorDaoImpl();

    Author author = new Author();
    author.setName("Karol");
    author.setSecondName("May");
    daoAuthor.save(author);

    Book book = new Book();
    book.setTitle("Winnetou");
    book.setAuthor(author);
    dao.save(book);

    Book saved = dao.findByID(book.getId());

    assertNotNull(saved);
    assertEquals(book.getTitle(), saved.getTitle());
    assertEquals(book.getAuthor().getId(), saved.getAuthor().getId());
  }

  @Test
  void findAll () {
    BookDao dao = new BookDaoImpl();
    AuthorDao daoAuthor = new AuthorDaoImpl();

    Author author1 = new Author();
    author1.setName("Karol");
    author1.setSecondName("May");
    daoAuthor.save(author1);

    Author author2 = new Author();
    author2.setName("Adam");
    author2.setSecondName("Mickiewicz");
    daoAuthor.save(author2);

    Book book1 = new Book();
    book1.setTitle("Winnetou");
    book1.setAuthor(author1);

    Book book2 = new Book();
    book2.setTitle("Pan Tadeusz");
    book2.setAuthor(author2);

    dao.save(book1);
    dao.save(book2);

    List<Book> books = dao.findAll();

    assertNotNull(books);
    assertEquals(2, books.size());

    Book found;
    if(books.get(0).getId() == book1.getId()){
      found = books.get(0);
    }else {
      found = books.get(1);
    }

    assertNotNull(found);

    assertEquals(book1.getTitle(), found.getTitle());
    assertEquals(book1.getAuthor().getId(), found.getAuthor().getId());
  }

  @Test
  void delete () {
    BookDao dao = new BookDaoImpl();
    AuthorDao authorDao = new AuthorDaoImpl();

    Author author = new Author();
    author.setName("Jerzy");
    author.setSecondName("Urban");
    authorDao.save(author);


    Book book = new Book();
    book.setTitle("Książka telefoniczna");
    book.setAuthor(author);


    dao.save(book);
    dao.delete(book.getId());

    Book deleted = dao.findByID(author.getId());
    assertNull(deleted);
  }
}