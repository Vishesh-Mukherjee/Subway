package com.gdgu.subway;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;

@Data
public class Registration {

    @NotBlank(message = "Firstname is required")
    private String firstname;

    @NotBlank(message = "Lastname is required")
    private String lastname;

    @Min(value = 18, message = "Age is required(Age>18)")
    private String age;

    @NotNull(message = "Gender is required")
    private String gender;

    @NotBlank(message = "Phone number is requried")
    @Pattern(regexp="^$|[0-9]{10}", message = "Invalid phone number")
    private String phoneNo;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email")
    private String email;

    @NotBlank(message = "Username is required")
    private String username;

    @Size(min = 6, message = "Password is required (Password>6 characters)")
    private String password;

    private String confirmPassword;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(firstname, lastname, age, gender, phoneNo, email, username, passwordEncoder.encode(password));
    }

}
