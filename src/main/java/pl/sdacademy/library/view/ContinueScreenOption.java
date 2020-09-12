package pl.sdacademy.library.view;

public enum ContinueScreenOption {
  CONTINUE("C");

  String label;

  ContinueScreenOption(String label){
    this.label = label;
  }

  public static ContinueScreenOption valueOfLabel(String label) {
	for (ContinueScreenOption option : ContinueScreenOption.values()) {
	  if (option.label.equals(label)) {
		return option;
	  }
	}
	return null;
  }
}
