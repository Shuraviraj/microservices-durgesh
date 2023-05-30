package shuravi.hotel.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "hotels")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

  @Id
  @Column(name = "ID", nullable = false)
  private String id;

  @Column(name = "NAME", length = 15)
  private String name;

  @Column(name = "LOCATION")
  private String location;

  @Column(name = "ABOUT")
  private String about;
}
