package ie.atu.cicdgroupproject;

import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/userLoginService")

public class userLoginController {
    List<userLogin> userLogins = new ArrayList<>();
    @GetMapping("/Login")
    public userLogin Login(@Valid @RequestParam String username,@RequestParam String password) {
        for(userLogin user:userLogins){
            if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
                return new userLogin(username,"Successful Login");
            }
        }
        return new userLogin(username,"Failed Login");
    }

    @PostMapping("/RegisterUser")
    public userLogin RegisterUser(@Valid @RequestBody userLogin userDetails) {
        userLogins.add(userDetails);
        return userDetails;
    }

    @GetMapping ("/getUserDetails")
    public List<userLogin> getUserDetails() {
        return userLogins;
    }

}
