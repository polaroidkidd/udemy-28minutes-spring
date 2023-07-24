package dev.dle.edu.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

  @RequestMapping("/courses")
  public List<Course> retrieveAllCourses() {
    return Arrays.asList(new Course(1, "Learn Spring", "in28Minutes"),
        new Course(1, "Learn DevOps", "in28minutes"),
        new Course(3, "Learn Typescript", "dle.dev.edu")
        );
  }
}
