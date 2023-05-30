package shuravi.userservice.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import shuravi.userservice.entities.Profile;
import shuravi.userservice.entities.Rating;
import shuravi.userservice.exceptions.ResourceNotFoundException;
import shuravi.userservice.external.services.HotelService;
import shuravi.userservice.repositories.ProfileRepo;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ProfileService {

    @Autowired
    private ProfileRepo profileRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private Logger logger = LoggerFactory.getLogger(ProfileService.class);

    public Profile saveProfile(Profile profile) {
        var ranUserId = UUID.randomUUID().toString();
        profile.setId(ranUserId);
        return profileRepo.save(profile);
    }

    public List<Profile> getAllProfile() {
        return profileRepo.findAll();
    }

    public Profile getProfile(String profileId) {
        var profile = profileRepo.findById(profileId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Profile not found of id id : " + profileId));

        var ratingsOfUser = restTemplate.getForObject(
                "http://RATING-SERVICE/ratings/profiles/" + profile.getId(),
                Rating[].class);
        logger.info("{}", ratingsOfUser);

        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

        List<Rating> ratingList = ratings.stream().map(rating -> {
//      var hotelResponseEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
            var hotel = hotelService.getHotel(rating.getHotelId());
//      var hotel = hotelResponseEntity.getBody();
//      logger.info("response status code : {}", hotelResponseEntity.getStatusCode());
            rating.setHotel(hotel);
            return rating;
        }).toList();

        profile.setRatings(ratingList);

        return profile;
    }
}
