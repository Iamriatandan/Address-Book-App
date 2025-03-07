package com.company.addressbookapp.demo.dto;

import lombok.*;
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactDTO {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
}
