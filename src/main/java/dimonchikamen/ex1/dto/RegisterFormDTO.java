package dimonchikamen.ex1.dto;

import dimonchikamen.ex1.entity.Profile;
import dimonchikamen.ex1.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RegisterFormDTO {

    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    private String username;
    @NotBlank
    @Size(min = 8, max = 24)
    private CharSequence password;

    public Profile toProfile() {
        Profile profile = new Profile();
        profile.setName(name);
        profile.setSurname(surname);
        profile.setUsername(username);
        return profile;
    }

    public User toEntity() {
        var user = new User();
        user.setUsername(username);
        user.setEnabled(true);
        user.setAuthority("USER");
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setAccountNonExpired(true);
        return user;
    }
}

