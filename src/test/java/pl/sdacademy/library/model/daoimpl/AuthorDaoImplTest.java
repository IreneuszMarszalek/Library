package pl.sdacademy.library.model.daoimpl;

import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdacademy.library.model.dao.AuthorDao;
import pl.sdacademy.library.model.entity.Author;
import pl.sdacademy.library.utils.HibernateUtils;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//TODO dodaj książki do authora
class AuthorDaoImplTest {
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
    AuthorDao dao = new AuthorDaoImpl();
    Author author = new Author();
    author.setName("Ireneusz");
    author.setSecondName("Marszałek");

    dao.save(author);

    Author saved = dao.findByID(author.getId());

    assertNotNull(saved);
    assertEquals(author.getName(), saved.getName());
    assertEquals(author.getSecondName(), saved.getSecondName());
  }

  @Test
  void findAll () {
    AuthorDao dao = new AuthorDaoImpl();

    Author author1 = new Author();
    author1.setName("Ireneusz");
    author1.setSecondName("Marszałek");

    Author author2 = new Author();
    author2.setName("Ireneusz2");
    author2.setSecondName("Marszałek2");

    dao.save(author1);
    dao.save(author2);

    List<Author> authors = dao.findAll();

    assertNotNull(authors);
    assertEquals(2, authors.size());

    Author found;
    if(authors.get(0).getId() == author1.getId()){
      found = authors.get(0);
    }else {
      found = authors.get(1);
    }

    assertNotNull(found);

    assertEquals(author1.getName(), found.getName());
    assertEquals(author1.getSecondName(), found.getSecondName());
  }

  @Test
  void delete () {
    AuthorDao dao = new AuthorDaoImpl();
    Author author = new Author();

    author.setName("Ireneusz");
    author.setSecondName("Marszałek");

    dao.save(author);
    dao.delete(author.getId());

    Author deleted = dao.findByID(author.getId());
    assertNull(deleted);
  }

  @Test
  void findByName () {
    AuthorDao dao = new AuthorDaoImpl();
    Author author = new Author();

    author.setName("Adam");
    author.setSecondName("Mickiewicz");

    dao.save(author);
    List<Author> find = dao.findByName("Adam");

    assertNotNull(find);
    assertEquals(1, find.size());

    assertEquals(author.getId(), find.get(0).getId());

    List<Author> nothing = dao.findByName("Y");
    assertEquals(0,nothing.size());
  }

  @Test
  void findBySecondName () {
    AuthorDao dao = new AuthorDaoImpl();
    Author author = new Author();

    author.setName("Adam");
    author.setSecondName("Mickiewicz");

    dao.save(author);
    List<Author> find = dao.findBySecondName("Mickiewicz");

    assertNotNull(find);
    assertEquals(1, find.size());

    assertEquals(author.getId(), find.get(0).getId());

    List<Author> nothing = dao.findBySecondName("Y");
    assertEquals(0,nothing.size());
  }
}