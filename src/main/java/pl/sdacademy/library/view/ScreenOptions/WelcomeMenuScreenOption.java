package pl.sdacademy.library.view.ScreenOptions;

public enum WelcomeMenuScreenOption {
  LOG_IN("L"),
  CREATE_USER("C"),
  EXIT("X");

  public String label;

  WelcomeMenuScreenOption(String label){
	this.label = label;
  }

  public static WelcomeMenuScreenOption valueOfLabel(String label) {
	for (WelcomeMenuScreenOption option : WelcomeMenuScreenOption.values()) {
	  if (option.label.equals(label)) {
		return option;
	  }
	}
	return null;
  }
}
