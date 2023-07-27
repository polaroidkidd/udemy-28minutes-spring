package dev.dle.edu.rest.jpa;

import dev.dle.edu.rest.users.Post;
import dev.dle.edu.rest.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
