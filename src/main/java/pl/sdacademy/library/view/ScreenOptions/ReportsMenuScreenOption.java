package pl.sdacademy.library.view.ScreenOptions;

public enum ReportsMenuScreenOption {
  USERS("U"),
  BOOKS("B"),
  BORROWED("O"),
  AUTHORS("A"),
  BACK("C");

  public String label;

  ReportsMenuScreenOption(String label){
	this.label = label;
  }

  public static ReportsMenuScreenOption valueOfLabel(String label) {
	for (ReportsMenuScreenOption option : ReportsMenuScreenOption.values()) {
	  if (option.label.equals(label)) {
		return option;
	  }
	}
	return null;
  }
}
