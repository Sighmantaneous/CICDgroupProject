package ie.atu.cicdgroupproject;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class RequestController {
    List<Login> userList = new ArrayList<>();

    @GetMapping("/login")
    public Login getLogin(@RequestParam String username, @RequestParam String password) {
        for (Login user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return new Login(username, "Login successful");
            }
        }
        return new Login(username, "Invalid credentials");
    }

    @PostMapping("/register")
    public Login registerUser(@Valid @RequestBody Login newUser){
        userList.add(newUser);
        return newUser;
    }

    @GetMapping("/getUsersInfo")
    public List<Login> getUserList(){
        return userList;
    }
}
