package pl.sdacademy.library.model.dto;

import pl.sdacademy.library.model.entity.BookTurnover;

import java.time.LocalDate;
import java.util.Set;

public class UserDto {
  private long id;
  private String nick;
  private String password;
  private String name;
  private String secondName;
  private Integer age;
  private LocalDate joiningDate;
  private LocalDate leavingDate;
  private Boolean active;
  private Boolean admin;
  private Set<BookTurnover> turnovers;

  public long getId () {
	return id;
  }

  public void setId (long id) {
	this.id = id;
  }

  public String getNick () {
	return nick;
  }

  public void setNick (String nick) {
	this.nick = nick;
  }

  public String getPassword () {
	return password;
  }

  public void setPassword (String password) {
	this.password = password;
  }

  public String getName () {
	return name;
  }

  public void setName (String name) {
	this.name = name;
  }

  public String getSecondName () {
	return secondName;
  }

  public void setSecondName (String secondName) {
	this.secondName = secondName;
  }

  public Integer getAge () {
	return age;
  }

  public void setAge (Integer age) {
	this.age = age;
  }

  public LocalDate getJoiningDate () {
	return joiningDate;
  }

  public void setJoiningDate (LocalDate joiningDate) {
	this.joiningDate = joiningDate;
  }

  public LocalDate getLeavingDate () {
	return leavingDate;
  }

  public void setLeavingDate (LocalDate leavingDate) {
	this.leavingDate = leavingDate;
  }

  public Boolean getActive () {
	return active;
  }

  public void setActive (Boolean active) {
	this.active = active;
  }

  public Boolean getAdmin () {
	return admin;
  }

  public void setAdmin (Boolean admin) {
	this.admin = admin;
  }

  public Set<BookTurnover> getTurnovers () {
	return turnovers;
  }

  public void setTurnovers (Set<BookTurnover> turnovers) {
	this.turnovers = turnovers;
  }
}
