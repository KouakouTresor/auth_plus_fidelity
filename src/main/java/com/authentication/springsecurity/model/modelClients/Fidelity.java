package com.authentication.springsecurity.model.modelClients;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "fidelity_card")
public class Fidelity {
    @Id
    @GeneratedValue
    private String id;
    private int points;
    private String lastshop;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getLastshop() {
        return lastshop;
    }

    public void setLastshop(String lastshop) {
        this.lastshop = lastshop;
    }

    public Fidelity() {
    }


}
