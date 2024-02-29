package dev.io.fullstackproject.service;

import dev.io.fullstackproject.core.mapper.ModelMapperService;
import dev.io.fullstackproject.model.User;
import dev.io.fullstackproject.repository.UserRepository;
import dev.io.fullstackproject.service.requests.CreateUserRequest;
import dev.io.fullstackproject.service.requests.UpdateUserRequest;
import dev.io.fullstackproject.service.responses.GetAllUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserManager implements UserService {

    private UserRepository userRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllUserResponse> getAll() {
        List<User> users = userRepository.findAll();
        List<GetAllUserResponse> userResponses = users.stream().map(user -> this.modelMapperService.forResponse().map(user, GetAllUserResponse.class)).collect(Collectors.toList());
        return userResponses;
    }

    @Override
    public void add(CreateUserRequest createUserRequest) {
        User user = this.modelMapperService.forRequest().map(createUserRequest, User.class);
        this.userRepository.save(user);
    }

    @Override
    public void update(UpdateUserRequest updateUserRequest) {
        User user = this.modelMapperService.forRequest().map(updateUserRequest, User.class);
        this.userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        this.userRepository.deleteById(id);
    }
}
