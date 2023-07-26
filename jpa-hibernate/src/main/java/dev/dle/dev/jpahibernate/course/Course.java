package dev.dle.dev.jpahibernate.course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column
  private String name;
  @Column
  private String author;


  @Override
  public String toString() {
    return "Course{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", author='" + author + '\'' +
        '}';
  }

  public Course() {
  }

  public Course(String name, String author) {
    this.name = name;
    this.author = author;
  }

  public Course(long id, String name, String author) {
    super();
    this.id = id;
    this.name = name;
    this.author = author;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

}
