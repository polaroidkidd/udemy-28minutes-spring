package dev.dle.edu.rest.users;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Post {

  @Id
  @GeneratedValue
  private Integer id;


  private String description;



  public void setId(Integer id) {
    this.id = id;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
