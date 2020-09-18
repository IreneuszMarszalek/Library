package pl.sdacademy.library.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="User", uniqueConstraints = @UniqueConstraint(name = "uk_user_nick", columnNames = ("nick")))

@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @Column(unique = true)
  private String nick;
  private String password;
  private String name;
  private String secondName;
  private Integer age;
  private LocalDate joiningDate;
  private LocalDate leavingDate;
  private Boolean active;
  private Boolean admin;

  @OneToMany(mappedBy = "user")
  private Set<BookTurnover> turnovers;
}
