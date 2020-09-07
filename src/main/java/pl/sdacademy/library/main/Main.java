package pl.sdacademy.library.main;

import org.hibernate.Session;
import pl.sdacademy.library.controller.Controller;
import pl.sdacademy.library.utils.HibernateUtils;

public class Main {
  public static void main(String[] args) {
	Controller controller = new Controller();
	controller.init();
	controller.start();
  }
}
