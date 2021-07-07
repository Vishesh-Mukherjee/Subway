package com.gdgu.controller;

import javax.validation.Valid;

import com.gdgu.entity.Registration;
import com.gdgu.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String getRegistrationForm(Model model) {
        model.addAttribute("registration", new Registration());
        return "registrationForm";
    }

    @PostMapping
    public String processRegistrationForm(@Valid Registration registration, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "registrationForm";
        }
        if (!registration.getPassword().equals(registration.getConfirmPassword())) {
            model.addAttribute("invalidPassword", "Confirm password does not match password");
            return "registrationForm";
        }
        if (userRepository.existsByUsername(registration.getUsername())) {
            model.addAttribute("usernameExist", "Username already exist");
            return "registrationForm";
        }
        userRepository.save(registration.toUser(passwordEncoder));
        return "redirect:/login";
    }

}
