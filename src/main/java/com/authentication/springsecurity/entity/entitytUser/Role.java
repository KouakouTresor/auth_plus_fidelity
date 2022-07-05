 package com.authentication.springsecurity.entity.entitytUser;


import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

 @Entity
public class Role implements Serializable {
     @Serial
     private static final long serialVersionUID = -7211311465818442678L;
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}