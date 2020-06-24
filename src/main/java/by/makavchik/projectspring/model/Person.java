package by.makavchik.projectspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    private String FirstName;
    private String LastName;
    private String street;
    private String city;
    private String zip;
    private String email;
    private String birthday;
    private String phone;
}
