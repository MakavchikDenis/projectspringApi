package by.makavchik.projectspring.form;


import by.makavchik.projectspring.validator.CellPhone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonForm {
    @NotBlank(message = "{valid.FirstName.NotBlank}")
    @Size(min = 2,message = "{valid.FirstName.size.min2}")
    private String FirstName;
    @NotBlank (message = "{valid.LastName.NotBlank}")
    private String LastName;
    @NotBlank (message = "{valid.street.NotBlank}")
    private String street;
    @NotBlank (message = "{valid.city.NotBlank}")
    private String city;
    @NotBlank (message = "{valid.zip.NotBlank}")
    private String zip;
    @NotBlank (message = "{valid.email.NotBlank}")
    @Email(message = "{valid.email.Email}")
    private String email;
    @NotBlank (message = "{valid.birthday.NotBlank}")
    private String birthday;
    @CellPhone (message = "{valid.phone.CellPhone}")
    private String phone;
}
