package ie.atu.cicdgroupproject;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class userLogin {
    @Size(min = 1, max = 20)
    private String username;
    @Size(min = 6, max = 20)
    private String password;
}