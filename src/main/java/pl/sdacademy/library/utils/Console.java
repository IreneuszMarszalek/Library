package pl.sdacademy.library.utils;

public class Console {
  public static void clearScreen() {
	try
	{
	  Runtime.getRuntime().exec("cmd /c cls");
	}
	catch(final Exception e)
	{
	  System.out.print(e);
	}
  }
}
