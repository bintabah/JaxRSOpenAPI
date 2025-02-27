package fr.istic.taa.jaxrs.domain;

import jakarta.persistence.*;

@Entity
public class Tag implements java.io.Serializable {

  private Long id;
  private String name;

  public Tag() {}

  public Tag(String name) {
    this.name = name;
  }

  @Id
  @GeneratedValue
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

