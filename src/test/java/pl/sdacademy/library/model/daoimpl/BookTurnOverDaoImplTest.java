package pl.sdacademy.library.model.daoimpl;

import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdacademy.library.model.dao.AuthorDao;
import pl.sdacademy.library.model.dao.BookDao;
import pl.sdacademy.library.model.dao.BookTurnoverDao;
import pl.sdacademy.library.model.entity.Author;
import pl.sdacademy.library.model.entity.Book;
import pl.sdacademy.library.model.entity.BookTurnover;
import pl.sdacademy.library.utils.HibernateUtils;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookTurnOverDaoImplTest {
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
    BookTurnoverDao dao = new BookTurnOverDaoImpl();
    BookDao daoBook = new BookDaoImpl();
    AuthorDao daoAuthor = new AuthorDaoImpl();

    Author author = new Author();
    author.setName("Karol");
    author.setSecondName("May");
    daoAuthor.save(author);

    Book book = new Book();
    book.setTitle("Winnetou");
    book.setAuthor(author);
    daoBook.save(book);

    BookTurnover turnover = new BookTurnover();
    turnover.setLoanDate(LocalDate.now());
    turnover.setPeriod(30);
    turnover.setBook(book);
    turnover.setAuthor(author);
    dao.save(turnover);

    BookTurnover saved = dao.findByID(turnover.getId());

    assertNotNull(saved);
    assertEquals(turnover.getId(), saved.getId());
    assertEquals(turnover.getAuthor().getId(), saved.getAuthor().getId());
    assertEquals(turnover.getBook().getId(), saved.getBook().getId());
  }

  @Test
  void findAll () {
    BookTurnoverDao dao = new BookTurnOverDaoImpl();
    BookDao daoBook = new BookDaoImpl();
    AuthorDao daoAuthor = new AuthorDaoImpl();

    Author author = new Author();
    author.setName("Karol");
    author.setSecondName("May");
    daoAuthor.save(author);

    Book book = new Book();
    book.setTitle("Winnetou");
    book.setAuthor(author);
    daoBook.save(book);

    BookTurnover turnover = new BookTurnover();
    turnover.setLoanDate(LocalDate.now());
    turnover.setPeriod(30);
    turnover.setBook(book);
    turnover.setAuthor(author);
    dao.save(turnover);

    List<BookTurnover> turnovers = dao.findAll();

    assertNotNull(turnovers);
    assertEquals(1, turnovers.size());

    BookTurnover found = turnovers.get(0);

    assertNotNull(found);

    assertEquals(turnover.getId(), found.getId());
    assertEquals(turnover.getAuthor().getId(), found.getAuthor().getId());
    assertEquals(turnover.getBook().getId(), found.getBook().getId());
  }

  @Test
  void delete () {
    BookTurnoverDao dao = new BookTurnOverDaoImpl();
    BookDao daoBook = new BookDaoImpl();
    AuthorDao daoAuthor = new AuthorDaoImpl();

    Author author = new Author();
    author.setName("Karol");
    author.setSecondName("May");
    daoAuthor.save(author);

    Book book = new Book();
    book.setTitle("Winnetou");
    book.setAuthor(author);
    daoBook.save(book);

    BookTurnover turnover = new BookTurnover();
    turnover.setLoanDate(LocalDate.now());
    turnover.setPeriod(30);
    turnover.setBook(book);
    turnover.setAuthor(author);
    dao.save(turnover);

    dao.delete(turnover.getId());

    BookTurnover deleted = dao.findByID(turnover.getId());
    assertNull(deleted);
  }
}