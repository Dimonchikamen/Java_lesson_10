package dimonchikamen.ex1.controller;

import dimonchikamen.ex1.repository.ProfileRepository;
import dimonchikamen.ex1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class IndexController {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

    @GetMapping("/")
    public String index(Map<String, Object> model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated()) {
            return "redirect:/profile/" + authentication.getName();
        }

        return "index";
    }
}
