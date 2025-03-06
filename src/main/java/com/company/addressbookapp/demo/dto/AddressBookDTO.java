package com.company.addressbookapp.demo.dto;

import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookDTO {
    private Long index;
    private String name;
    private String email;
    private String phoneNumber;
}
