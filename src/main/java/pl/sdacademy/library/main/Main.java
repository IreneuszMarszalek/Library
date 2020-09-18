package pl.sdacademy.library.main;

import pl.sdacademy.library.controller.Controller;

public class Main {
  public static void main(String[] args) {
    Controller controller = new Controller();
	controller.init();
	controller.start();
  }
}
