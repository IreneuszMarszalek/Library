package pl.sdacademy.library.view;

public enum ExitScreenOption {
  EXIT("X");

  String label;

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
