package dev.dle.dev.jpahibernate.course;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {

  List<Course> findByAuthor(String author);
}
