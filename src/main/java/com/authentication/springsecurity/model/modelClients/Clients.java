package com.authentication.springsecurity.model.modelClients;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Document
@Data
public class Clients implements Serializable {
    @Serial
    private static final long serialVersionUID = -664869542688675108L;
    @Id
    private String id;
    private String code;
    private String name;
    private String address;
    private String ville;
    private String phone;
    private String email;
    private Boolean active;
    private Date creationdate;


    private Fidelity fidelity;

    public Clients() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Fidelity getFidelity() {
        return fidelity;
    }

    public void setFidelity(Fidelity fidelity) {
        this.fidelity = fidelity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Clients(String id,
                   String code,
                   String name,
                   String address,
                   String ville,
                   String phone,
                   String email,
                   boolean active,
                   Date creationdate,
                   Fidelity fidelity) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.address = address;
        this.ville = ville;
        this.phone = phone;
        this.email = email;
        this.active = active;
        this.creationdate = creationdate;
        this.fidelity = fidelity;
    }




}
