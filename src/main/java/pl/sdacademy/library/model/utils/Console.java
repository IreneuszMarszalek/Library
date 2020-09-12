package pl.sdacademy.library.model.utils;

import java.io.IOException;

public class Console {
  public static void clearScreen() {
	try {
	  if (System.getProperty("os.name").contains("Windows"))
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	  else
		Runtime.getRuntime().exec("clear");
	} catch (IOException | InterruptedException ex) {}
  }
}
