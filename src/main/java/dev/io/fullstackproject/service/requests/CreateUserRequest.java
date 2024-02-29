package dev.io.fullstackproject.service.requests;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    private String name;
    private String password;
}
