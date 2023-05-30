package shuravi.rating.RatinngService.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shuravi.rating.RatinngService.entities.Rating;
import shuravi.rating.RatinngService.repository.RatingRepo;

@Service
public class RatingService {

  @Autowired
  private RatingRepo ratingRepo;

  public Rating create(Rating rating) {
    return ratingRepo.save(rating);
  }

  public List<Rating> getRatings() {
    return ratingRepo.findAll();
  }

  public List<Rating> getRatingByProfileId(String profileId) {
    return ratingRepo.findByProfileId(profileId);
  }

  public List<Rating> getRatingByHotelId(String hotelId) {
    return ratingRepo.findByHotelId(hotelId);
  }
}
