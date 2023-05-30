package shuravi.userservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import shuravi.userservice.entities.Profile;

public interface ProfileRepo extends JpaRepository<Profile, String> {

}
