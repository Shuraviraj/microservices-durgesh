package shuravi.hotel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import shuravi.hotel.entities.Hotel;
import shuravi.hotel.services.HotelService;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PreAuthorize("hasAnyAuthority('Admin')")
    @PostMapping
    public ResponseEntity<Hotel> createProfile(@RequestBody Hotel hotel) {
        var hotel1 = hotelService.create(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_internal')")
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getSingleProfile(@PathVariable String hotelId) {
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.get(hotelId));
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_internal') || hasAnyAuthority('Admin')")
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllProfile() {
        return ResponseEntity.ok(hotelService.getAll());
    }

}
