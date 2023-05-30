package shuravi.rating.RatinngService.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shuravi.rating.RatinngService.entities.Rating;
import shuravi.rating.RatinngService.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

  @Autowired
  private RatingService ratingService;

  @PostMapping
  public ResponseEntity<Rating> create(@RequestBody Rating rating) {
    var createdRating = ratingService.create(rating);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdRating);
  }

  @GetMapping
  public ResponseEntity<List<Rating>> getRatings() {
    var ratings = ratingService.getRatings();
    return ResponseEntity.ok(ratings);
  }

  @GetMapping("/profiles/{profileId}")
  public ResponseEntity<List<Rating>> getRatingByProfileId(@PathVariable String profileId) {
    var ratingByProfileId = ratingService.getRatingByProfileId(profileId);
    return ResponseEntity.ok(ratingByProfileId);
  }

  @GetMapping("/hotels/{hotelId}")
  public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId) {
    var ratingByHotelId = ratingService.getRatingByHotelId(hotelId);
    return ResponseEntity.ok(ratingByHotelId);
  }


}
