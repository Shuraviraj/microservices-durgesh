package shuravi.userservice.controllers;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shuravi.userservice.entities.Profile;
import shuravi.userservice.services.ProfileService;

@RestController
@RequestMapping("/profiles")
@Slf4j
public class ProfileController {

  int retryCount = 1;

  @Autowired
  private ProfileService profileService;

  @PostMapping
  public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) {
    var user1 = profileService.saveProfile(profile);
    return ResponseEntity.status(HttpStatus.CREATED).body(user1);
  }

  //creating fallback method for circuitbreaker

  @GetMapping("/{profileId}")
//    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
//  @Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallback")
  @RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallback")
  public ResponseEntity<Profile> getSingleProfile(@PathVariable String profileId) {
    log.info("Get Single Profile Handler: ProfileController");
    log.info("Retry count: {}", retryCount);
    retryCount++;
    var user = profileService.getProfile(profileId);
    return ResponseEntity.ok(user);
  }

  public ResponseEntity<Profile> ratingHotelFallback(String profileId, Exception exception) {
//        log.info("fallback is execeted because of exception: " + exception.getMessage());
    var profile = Profile.builder()
        .name("Dummy")
        .email("dummy@gmail.com")
        .about("Dummy is a fallback callback")
        .id("141234")
        .build();
    return new ResponseEntity<>(profile, HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
  }

  @GetMapping
  public ResponseEntity<List<Profile>> getAllProfile() {
    var user = profileService.getAllProfile();
    return ResponseEntity.ok(user);
  }

}
