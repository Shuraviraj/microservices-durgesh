package shuravi.rating.RatinngService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import shuravi.rating.RatinngService.entities.Rating;
import shuravi.rating.RatinngService.services.RatingService;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PreAuthorize("hasAnyAuthority('Admin')")
    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating) {
        var createdRating = ratingService.create(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRating);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_internal') || hasAnyAuthority('Admin')")
    @GetMapping
    public ResponseEntity<List<Rating>> getRatings() {
        var ratings = ratingService.getRatings();
        return ResponseEntity.ok(ratings);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_internal') || hasAnyAuthority('Admin')")
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
