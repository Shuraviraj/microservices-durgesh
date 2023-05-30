package shuravi.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import shuravi.hotel.entities.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, String> {

}
