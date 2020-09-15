package pl.sdacademy.library.view.ScreenOptions;

public enum MainMenuScreenOption {
  ACTIONS("A"),
  REPORTS("R"),
  SETTINGS("S"),
  EXIT("X");

  public String label;

  MainMenuScreenOption(String label){
	this.label = label;
  }

  public static MainMenuScreenOption valueOfLabel(String label) {
	for (MainMenuScreenOption option : MainMenuScreenOption.values()) {
	  if (option.label.equals(label)) {
		return option;
	  }
	}
	return null;
  }
}
