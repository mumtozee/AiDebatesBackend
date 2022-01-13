package dev.mumtozee.ai_debates.model;

import java.time.LocalDate;

public class Person {
  private int id;
  private String username;
  private String email;
  private String password;
  private LocalDate registeredDate;

  public Person() {
  }

  public Person(String username, String email, String password, LocalDate registeredDate) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.registeredDate = registeredDate;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public LocalDate getRegisteredDate() {
    return registeredDate;
  }

  public void setRegisteredDate(LocalDate registeredDate) {
    this.registeredDate = registeredDate;
  }

  @Override
  public String toString() {
    return "Person{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", registeredDate=" + registeredDate +
            '}';
  }
}
