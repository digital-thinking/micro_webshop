package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * User
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-20T14:40:13.830Z")

public class User   {
  private Integer id = null;

  private String username = null;

  private String name = null;

  private String lastname = null;

  private String password = null;

  private Integer role = null;

  public User id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * A unique identifier
   * @return id
  **/
  @ApiModelProperty(value = "A unique identifier")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public User username(String username) {
    this.username = username;
    return this;
  }

   /**
   * The user's username
   * @return username
  **/
  @ApiModelProperty(value = "The user's username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public User name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The user's firstname
   * @return name
  **/
  @ApiModelProperty(value = "The user's firstname")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public User lastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

   /**
   * The user's lastname
   * @return lastname
  **/
  @ApiModelProperty(value = "The user's lastname")
  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public User password(String password) {
    this.password = password;
    return this;
  }

   /**
   * The user's password
   * @return password
  **/
  @ApiModelProperty(value = "The user's password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public User role(Integer role) {
    this.role = role;
    return this;
  }

   /**
   * The ID of a role
   * @return role
  **/
  @ApiModelProperty(value = "The ID of a role")
  public Integer getRole() {
    return role;
  }

  public void setRole(Integer role) {
    this.role = role;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.id, user.id) &&
        Objects.equals(this.username, user.username) &&
        Objects.equals(this.name, user.name) &&
        Objects.equals(this.lastname, user.lastname) &&
        Objects.equals(this.password, user.password) &&
        Objects.equals(this.role, user.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, name, lastname, password, role);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    lastname: ").append(toIndentedString(lastname)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

