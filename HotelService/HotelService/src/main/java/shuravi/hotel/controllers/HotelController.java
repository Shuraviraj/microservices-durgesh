package shuravi.hotel.controllers;

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
import shuravi.hotel.entities.Hotel;
import shuravi.hotel.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

  @Autowired
  private HotelService hotelService;

  @PostMapping
  public ResponseEntity<Hotel> createProfile(@RequestBody Hotel hotel) {
    var hotel1 = hotelService.create(hotel);
    return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
  }

  @GetMapping("/{hotelId}")
  public ResponseEntity<Hotel> getSingleProfile(@PathVariable String hotelId) {
    return ResponseEntity.status(HttpStatus.OK).body(hotelService.get(hotelId));
  }

  @GetMapping
  public ResponseEntity<List<Hotel>> getAllProfile() {
    return ResponseEntity.ok(hotelService.getAll());
  }

}
