package shuravi.userservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "micro_users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

  @Id
  @Column(name = "ID", nullable = false)
  private String id;

  @Column(name = "NAME", length = 15)
  private String name;

  @Column(name = "EMAIL")
  private String email;

  @Column(name = "ABOUT")
  private String about;

  @Transient
  private List<Rating> ratings = new ArrayList<>();
}
