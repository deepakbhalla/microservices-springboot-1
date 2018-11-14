package uk.co.ybs.App.domain.in_memory_entities;

public class Account {

  String name;
  Long id;
  String email;
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }


}
