package dev.io.fullstackproject.service;

import dev.io.fullstackproject.service.requests.CreateUserRequest;
import dev.io.fullstackproject.service.requests.UpdateUserRequest;
import dev.io.fullstackproject.service.responses.GetAllUserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void add(CreateUserRequest createUserRequest);

    List<GetAllUserResponse> getAll();

    void update(UpdateUserRequest updateUserRequest);

    void delete(int id);


}
