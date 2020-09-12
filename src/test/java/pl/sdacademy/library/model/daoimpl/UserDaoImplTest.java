package pl.sdacademy.library.model.daoimpl;

import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdacademy.library.model.dao.UserDao;
import pl.sdacademy.library.model.entity.User;
import pl.sdacademy.library.model.utils.HibernateUtils;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoImplTest {
  @BeforeEach
  void clearBeforeEach(){
    Session session = HibernateUtils
        .getInstance()
        .GetSessionFactory()
        .getCurrentSession();

    session.beginTransaction();
    session.createSQLQuery("delete from User").executeUpdate();
    session.getTransaction().commit();
    session.close();
  }

  @Test
  void save () {
    UserDao dao = new UserDaoImpl();
    User user = new User();
    user.setNick("IRRasek");
    user.setPassword("Password");
    user.setName("Ireneusz");
    user.setSecondName("Marszałek");
    user.setAge(18);
    user.setJoiningDate(LocalDate.of(2020,9,5));
    user.setLeavingDate(LocalDate.of(2020, 9,6));
    user.setActive(true);
    user.setAdmin(false);

    dao.save(user);

    User saved = dao.findByID(user.getId());

    assertNotNull(saved);
    assertEquals(user.getId(), saved.getId());
    assertEquals(user.getNick(), saved.getNick());
    assertEquals(user.getPassword(), saved.getPassword());
    assertEquals(user.getName(), saved.getName());
    assertEquals(user.getSecondName(), saved.getSecondName());
    assertEquals(user.getAge(), saved.getAge());
    assertEquals(user.getJoiningDate(), saved.getJoiningDate());
    assertEquals(user.getLeavingDate(), saved.getLeavingDate());
    assertEquals(user.getActive(), saved.getActive());
    assertEquals(user.getAdmin(), saved.getAdmin());
  }

  @Test
  void findAll () {
    UserDao dao = new UserDaoImpl();
    User user1 = new User();
    user1.setNick("IRRasek");
    user1.setPassword("Password");
    user1.setName("Ireneusz");
    user1.setSecondName("Marszałek");
    user1.setAge(18);
    user1.setJoiningDate(LocalDate.of(2020,9,5));
    user1.setLeavingDate(LocalDate.of(2020, 9,6));
    user1.setActive(true);
    user1.setAdmin(false);

    User user2 = new User();
    user2.setNick("IRRasek2");
    user2.setPassword("Password");
    user2.setName("Ireneusz");
    user2.setSecondName("Marszałek");
    user2.setAge(18);
    user2.setJoiningDate(LocalDate.of(2020,9,5));
    user2.setLeavingDate(LocalDate.of(2020, 9,6));
    user2.setActive(true);
    user2.setAdmin(false);

    dao.save(user1);
    dao.save(user2);

    List<User> users = dao.findAll();

    assertNotNull(users);
    assertEquals(2, users.size());

    User found;
    if(users.get(0).getId() == user1.getId()){
      found = users.get(0);
    }else {
      found = users.get(1);
    }

    assertNotNull(found);
    assertEquals(user1.getId(), found.getId());
    assertEquals(user1.getNick(), found.getNick());
    assertEquals(user1.getPassword(), found.getPassword());
    assertEquals(user1.getName(), found.getName());
    assertEquals(user1.getSecondName(), found.getSecondName());
    assertEquals(user1.getAge(), found.getAge());
    assertEquals(user1.getJoiningDate(), found.getJoiningDate());
    assertEquals(user1.getLeavingDate(), found.getLeavingDate());
    assertEquals(user1.getActive(), found.getActive());
    assertEquals(user1.getAdmin(), found.getAdmin());

  }

  @Test
  void delete () {
    UserDao dao = new UserDaoImpl();
    User user = new User();

    user.setNick("IRRasek");
    user.setPassword("Password");
    user.setName("Ireneusz");
    user.setSecondName("Marszałek");
    user.setAge(18);
    user.setJoiningDate(LocalDate.of(2020,9,5));
    user.setLeavingDate(LocalDate.of(2020, 9,6));
    user.setActive(true);
    user.setAdmin(false);

    dao.save(user);
    dao.delete(user.getId());

    User deleted = dao.findByID(user.getId());
    assertNull(deleted);
  }

  @Test
  void findByNick () {
    UserDao dao = new UserDaoImpl();
    User user = new User();

    user.setNick("IRRasek");
    user.setPassword("Password");
    user.setName("Ireneusz");
    user.setSecondName("Marszałek");
    user.setAge(18);
    user.setJoiningDate(LocalDate.of(2020,9,5));
    user.setLeavingDate(LocalDate.of(2020, 9,6));
    user.setActive(true);
    user.setAdmin(false);

    dao.save(user);
    User find = dao.findByNick("IRRasek");

    assertNotNull(find);
    assertEquals("IRRasek", find.getNick());

    User nothing = dao.findByNick("Y");
    assertNull(nothing);
  }
}