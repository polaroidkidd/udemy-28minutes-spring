package dev.dle.dev.jpahibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//  private final CourseJpaRepository repository;
//
//  @Autowired
//  public CourseCommandLineRunner(CourseJpaRepository repository) {
//    this.repository = repository;
//  }


  @Autowired
  private CourseSpringDataJpaRepository repository;

  @Override
  public void run(String... args) throws Exception {
    repository.save(new Course( "Learn AWS JPA", "in28minutes"));
    repository.save(new Course( "Learn DevOps JPA", "in28minutes"));
    repository.save(new Course( "Svelte JPA", "Daniel Einars"));
    repository.deleteById(1l);
//    System.out.println(repository.findById(2l));
//
//    System.out.println(repository.findAll());

    System.out.println(repository.findByAuthor("in28minutes"));

  }
}
