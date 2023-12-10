package dimonchikamen.ex1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class IndexController {
    @GetMapping("/")
    public static String index(Map<String, Object> model) {
        model.put("title","HOME");
        return "index";
    }

    @GetMapping("/profile")
    public static String getStringProfile(Map<String, Object> model) {
        model.put("title","My Profile");
        model.put("description", "This is my profile. Look this!");
        return "profile";
    }
}
