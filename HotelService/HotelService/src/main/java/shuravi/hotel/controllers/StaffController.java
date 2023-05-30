package shuravi.hotel.controllers;

import java.util.Arrays;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staffs")
public class StaffController {

  @GetMapping
  public ResponseEntity<List<String>> getStaffs() {
    var members = Arrays.asList("Abhishek", "Aman", "Shambhavi", "sunidhi");
    return ResponseEntity.ok(members);
  }
}
