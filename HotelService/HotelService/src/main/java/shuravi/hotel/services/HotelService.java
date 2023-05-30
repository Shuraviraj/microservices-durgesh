package shuravi.hotel.services;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shuravi.hotel.entities.Hotel;
import shuravi.hotel.exceptions.ResourceNotFoundException;
import shuravi.hotel.repositories.HotelRepo;

@Service
public class HotelService {

  @Autowired
  private HotelRepo hotelRepo;

  public Hotel create(Hotel hotel) {
    var hotelId = UUID.randomUUID().toString();
    hotel.setId(hotelId);
    return hotelRepo.save(hotel);
  }

  public List<Hotel> getAll() {
    return hotelRepo.findAll();
  }

  public Hotel get(String id) {
    return hotelRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Hotel not found"));
  }

}
