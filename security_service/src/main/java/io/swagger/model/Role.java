package io.swagger.model;

import java.util.Objects;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * Role
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-20T14:40:13.830Z")

@Entity
@Table(name ="role")
public class Role   {
	@GeneratedValue
	@Id
	@Column(name="id")
  private Integer id = null;

	@Column(name = "type")
  private String typ = null;

	@Column(name = "level1")
  private Integer level = null;

  public Role id(Integer id) {
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

  public Role typ(String typ) {
    this.typ = typ;
    return this;
  }

   /**
   * The type of the role
   * @return typ
  **/
  @ApiModelProperty(value = "The type of the role")
  public String getTyp() {
    return typ;
  }

  public void setTyp(String typ) {
    this.typ = typ;
  }

  public Role level(Integer level) {
    this.level = level;
    return this;
  }

   /**
   * The role's level
   * @return level
  **/
  @ApiModelProperty(value = "The role's level")
  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Role role = (Role) o;
    return Objects.equals(this.id, role.id) &&
        Objects.equals(this.typ, role.typ) &&
        Objects.equals(this.level, role.level);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, typ, level);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Role {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    typ: ").append(toIndentedString(typ)).append("\n");
    sb.append("    level: ").append(toIndentedString(level)).append("\n");
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

