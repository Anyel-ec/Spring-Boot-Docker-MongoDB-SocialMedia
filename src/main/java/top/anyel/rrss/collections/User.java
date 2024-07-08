package top.anyel.rrss.collections;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String birthdate;
}
