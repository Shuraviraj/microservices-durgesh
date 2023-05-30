package shuravi.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import shuravi.userservice.external.services.RatingService;

@SpringBootTest
class UserServiceApplicationTests {

    @Autowired
    private RatingService ratingService;

//    @Test
//    void createRating() {
//        var rating = Rating.builder()
//                .ratingByUser(10)
//                .profileId("")
//                .hotelId("")
//                .feedback("Lorem ipsom")
//                .build();
//        var savedRating = ratingService.createRating(rating);
//        System.out.println("new rating created");
//    }
}
