package dimonchikamen.ex1.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProfileDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    private String username;
}
