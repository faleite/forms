package faleite.xyz.back_form;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
//@CrossOrigin(origins = "http://127.0.0.1:5500/")
public class UserDataController {

    private final UserDataService service;

    public UserDataController(UserDataService service) {
        this.service = service;
    }

    @PostMapping("save-data")
    public ResponseEntity<UserData> saveData(@RequestBody UserData userData) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.saveUserData(userData));
    }
}
