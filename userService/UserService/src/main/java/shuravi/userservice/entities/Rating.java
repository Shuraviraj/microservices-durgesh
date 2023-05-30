package shuravi.userservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {

  private String ratingId;

  private String profileId;
  private String hotelId;
  private int ratingByUser;
  private String feedback;
  private Hotel hotel;
}
