package dimonchikamen.ex1.controller;

import dimonchikamen.ex1.repository.ProfileRepository;
import dimonchikamen.ex1.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile/")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;

    @GetMapping("{username}")
    public String index(@PathVariable String username, Model model) {
        var profile = profileService.loadProfileByUsername(username);
        model.addAttribute("profile", profile);
        return "profile";
    }
}
