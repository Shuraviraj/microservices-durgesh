package shuravi.rating.RatinngService.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("user_rating")
public class Rating {

  @Id
  private String ratingId;
  
  private String profileId;
  private String hotelId;
  private int ratingByUser;
  private String feedback;
}
