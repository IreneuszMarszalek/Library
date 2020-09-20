package pl.sdacademy.library.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.sdacademy.library.model.entity.BookTurnover;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"turnovers"})

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
}
