package shuravi.rating.RatinngService.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import shuravi.rating.RatinngService.entities.Rating;

public interface RatingRepo extends MongoRepository<Rating, String> {

  List<Rating> findByProfileId(String profileId);

  List<Rating> findByHotelId(String hotelId);
}
