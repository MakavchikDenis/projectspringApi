package by.makavchik.projectspring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.lang.Long;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PersonDto {
    private Long PersonId;
    private String FirstName;
    private String LastName;
    private String street;
    private String city;
    private String zip;
    private String email;
    private String birthday;
    private String phone;
}
