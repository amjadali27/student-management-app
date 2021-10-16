package com.parwaz.training.response;

import com.parwaz.training.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {

    private String token;
    private Long id;
    private String userName;
    private String email;
    private List<String> roles;
}
