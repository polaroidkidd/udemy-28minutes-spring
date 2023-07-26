package dev.dle.edu.rest.users;

import dev.dle.edu.rest.exception.UserNotFoundException;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

  private UserDAOService userDAOService;

  @Autowired
  public UserResource(UserDAOService userDAOService) {
    this.userDAOService = userDAOService;
  }

  @GetMapping("/users")
  public List<User> retrieveAllUsers() {
    return userDAOService.findAll();
  }


  @GetMapping("/users/{id}")
  public User retrieveUserById(@PathVariable int id) {
    User one = userDAOService.findOne(id);
    if (one == null) {
      throw new UserNotFoundException("id: " + id);
    }
    return one;
  }


  @PostMapping(path = "/users")
  public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
    User created = userDAOService.save(user);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(created.getId()).toUri();
    return ResponseEntity.created(location).build();
  }

  @DeleteMapping("/users/{id}")
  public void deleteUser(@PathVariable int id) {
    userDAOService.deleteById(id);

  }

}
