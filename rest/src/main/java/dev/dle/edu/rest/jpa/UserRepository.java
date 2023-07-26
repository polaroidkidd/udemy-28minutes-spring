package dev.dle.edu.rest.jpa;

import dev.dle.edu.rest.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
