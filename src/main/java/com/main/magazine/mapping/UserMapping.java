package com.main.magazine.mapping;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class UserMapping {

    private Long id;
    private String name;
    private String firstname;
    private String username;
    private String email;
    private String password;
    private String role;
}
