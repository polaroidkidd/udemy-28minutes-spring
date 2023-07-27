package dev.dle.edu.rest.users;

import dev.dle.edu.rest.exception.UserNotFoundException;
import dev.dle.edu.rest.jpa.PostRepository;
import dev.dle.edu.rest.jpa.UserRepository;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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


  private final UserRepository userRepository;
  private final PostRepository postRepository;

  @Autowired
  public UserJpaResource(UserRepository userRepository, PostRepository postRepository) {
    this.userRepository = userRepository;

    this.postRepository = postRepository;
  }

  @GetMapping("/jpa/users")
  public List<User> retrieveAllUsers() {
    return userRepository.findAll();
  }


  @GetMapping("/jpa/users/{id}")
  public EntityModel<User> retrieveUserById(@PathVariable int id) {
    Optional<User> user = userRepository.findById(id);
    if (user.isEmpty()) {
      throw new UserNotFoundException("id: " + id);
    }
    EntityModel<User> entityModel = EntityModel.of(user.get());
    WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(
        WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
    entityModel.add(link.withRel("all-users"));
    return entityModel;
  }


  @PostMapping(path = "/jpa/users")
  public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
    User created = userRepository.save(user);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/jpa/{id}")
        .buildAndExpand(created.getId()).toUri();
    return ResponseEntity.created(location).build();
  }

  @DeleteMapping("/jpa/users/{id}")
  public void deleteUser(@PathVariable int id) {

    userRepository.deleteById(id);

  }

  @GetMapping("/jpa/users/{id}/posts")
  public List<Post> retrievePostsForUser(@PathVariable int id) {
    Optional<User> user = userRepository.findById(id);
    if (user.isEmpty()) {
      throw new UserNotFoundException("id: " + id);
    }
    return user.get().getPosts();
  }

  @PostMapping("/jpa/users/{id}/posts")
  public ResponseEntity<Object> createPost(@PathVariable int id, @Valid @RequestBody Post post) {
    Optional<User> user = userRepository.findById(id);
    if (user.isEmpty()) {
      throw new UserNotFoundException("id: " + id);
    }
    post.setUser(user.get());
    Post savedPost = postRepository.save(post);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(savedPost.getId()).toUri();

    return ResponseEntity.created(location).build();
  }


}
