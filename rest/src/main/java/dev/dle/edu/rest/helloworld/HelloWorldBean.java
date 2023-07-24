package dev.dle.edu.rest.helloworld;

public class HelloWorldBean {
  private String message;

  public HelloWorldBean(String hellWorld) {
    this.message = hellWorld;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "HelloWorldBean{" +
        "message='" + message + '\'' +
        '}';
  }
}
