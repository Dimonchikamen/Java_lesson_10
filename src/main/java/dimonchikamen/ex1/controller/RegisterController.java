package dimonchikamen.ex1.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dimonchikamen.ex1.dto.RegisterFormDTO;
import dimonchikamen.ex1.service.UserService;
import dimonchikamen.ex1.service.ProfileService;

import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final ProfileService profileService;

    @GetMapping
    public String registerForm() {
        log.info("get register form");
        return "register";
    }

    @PostMapping
    public String register(@Valid RegisterFormDTO form, BindingResult result, Model model) {
        log.info("register request {}", form);
        if (!result.hasErrors()) {
            var user = form.toEntity();
            user.setPassword(passwordEncoder.encode(form.getPassword()));
            userService.save(user);
            var profile = form.toProfile();
            profileService.save(profile);
            return "redirect:/profile/" + profile.getSurname();
        } else {
            log.info("has errors: {}", result.getFieldErrors()
                    .stream()
                    .map(FieldError::getField)
                    .collect(Collectors.toList()));
        }

        return "register";
    }
}
