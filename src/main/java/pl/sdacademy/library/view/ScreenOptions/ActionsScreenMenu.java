package pl.sdacademy.library.view.ScreenOptions;

public enum ActionsScreenMenu {
  ADD_USER("AU"),
  DELETE_USER("DU"),
  ADD_AUTHOR("AA"),
  DELETE_AUTHOR("DA"),
  ADD_BOOK("AB"),
  DELETE_BOOK("DB"),
  BORROW_BOOK("BB"),
  GIVE_BACK_BOOK("GB"),
  BACK("C");

  public String label;

  ActionsScreenMenu(String label){
	this.label = label;
  }

  public static ActionsScreenMenu valueOfLabel(String label) {
	for (ActionsScreenMenu option : ActionsScreenMenu.values()) {
	  if (option.label.equals(label)) {
		return option;
	  }
	}
	return null;
  }
}
