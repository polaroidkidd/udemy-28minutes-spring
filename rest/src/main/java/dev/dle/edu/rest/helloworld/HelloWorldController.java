package dev.dle.edu.rest.helloworld;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {


  @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
  public String helloWorld(){
    return "Hell World";
  }


  @RequestMapping(method = RequestMethod.GET, path = "/hello-world-bean")
  public HelloWorldBean helloWorldBean(){
    return new HelloWorldBean("Hell World");
  }

  @RequestMapping(method = RequestMethod.GET, path = "/hello/{name}")
  public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
    return new HelloWorldBean(String.format("Hello, %s", Optional.ofNullable(name).orElse("Mr. Nobody")));
  }


}
