package pl.sdacademy.library.view.ScreenOptions;

public enum ExitScreenOption {
  EXIT("X");

  public String label;

  ExitScreenOption(String label){
	this.label = label;
  }

  public static ExitScreenOption valueOfLabel(String label) {
	for (ExitScreenOption option : ExitScreenOption.values()) {
	  if (option.label.equals(label)) {
		return option;
	  }
	}
	return null;
  }
}
