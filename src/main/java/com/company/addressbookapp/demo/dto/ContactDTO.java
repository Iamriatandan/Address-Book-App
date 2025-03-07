package com.company.addressbookapp.demo.dto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactDTO {
    private Long id;

    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Name must contain only letters and spaces")

    private String name;
    private String email;
    private String phoneNumber;
}
