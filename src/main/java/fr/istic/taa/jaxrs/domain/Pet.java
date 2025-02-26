package fr.istic.taa.jaxrs.domain;

import java.util.ArrayList;
import java.util.List;

import fr.istic.taa.jaxrs.domain.Tag;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "Pet")
public class Pet implements java.io.Serializable {
  private long id;
  private String name;
  private List<Tag> tags = new ArrayList<Tag>();

  public Pet() {
  }

  public Pet(String name) {
    this.name = name;
  }

  @Id
  @GeneratedValue
  @XmlElement(name = "id")
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @XmlElement(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @XmlElementWrapper(name = "tags")
  @XmlElement(name = "tag")
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "pet_id")
  public List<Tag> getTags() {
    return tags;
  }

  public void setTags(List<Tag> tags) {
    this.tags = tags;
  }

  public void addTag(Tag tag) {
    tags.add(tag);
  }
}