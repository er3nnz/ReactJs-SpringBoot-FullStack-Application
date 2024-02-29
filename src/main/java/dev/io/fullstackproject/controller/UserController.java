package dev.io.fullstackproject.controller;

import dev.io.fullstackproject.service.UserService;
import dev.io.fullstackproject.service.requests.CreateUserRequest;
import dev.io.fullstackproject.service.requests.UpdateUserRequest;
import dev.io.fullstackproject.service.responses.GetAllUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@CrossOrigin
public class UserController {

    private UserService userService;

    @GetMapping("/getAll")
    public List<GetAllUserResponse> getAll() {
        return this.userService.getAll();
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateUserRequest createUserRequest) {
        this.userService.add(createUserRequest);
    }

    @PutMapping
    public void update(UpdateUserRequest updateUserRequest) {
        this.userService.update(updateUserRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(int id) {
        this.userService.delete(id);
    }
}
