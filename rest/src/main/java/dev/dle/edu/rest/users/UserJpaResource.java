package dev.dle.edu.rest.users;

import dev.dle.edu.rest.exception.UserNotFoundException;
import dev.dle.edu.rest.jpa.UserRepository;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJpaResource {


  private final UserRepository repository;

  @Autowired
  public UserJpaResource(UserRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/jpa/users")
  public List<User> retrieveAllUsers() {
    return repository.findAll();
  }


  @GetMapping("/jpa/users/{id}")
  public EntityModel<User> retrieveUserById(@PathVariable int id) {
    Optional<User> user = repository.findById(id);
    if (user.isEmpty()) {
      throw new UserNotFoundException("id: " + id);
    }
    EntityModel<User> entityModel = EntityModel.of(user.get());

    return entityModel;
  }


  @PostMapping(path = "/jpa/users")
  public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
    User created = repository.save(user);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/jpa/{id}")
        .buildAndExpand(created.getId()).toUri();
    return ResponseEntity.created(location).build();
  }

  @DeleteMapping("/jpa/users/{id}")
  public void deleteUser(@PathVariable int id) {

    repository.deleteById(id);

  }

}
