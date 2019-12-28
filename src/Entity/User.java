package Entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class User {

    private String id;
    private String name;
    private String password;
    private String status;
    private double scores;
    private LocalDateTime lastlogintime;




}
