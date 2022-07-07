package com.authentication.springsecurity.entity.entityClients;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "fidelity_card")
public class FidelityCard {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "points")
    private int points;

    @Column(name = "lastshop")
    private String lastshop;

    public FidelityCard(int points, String lastshop) {
        this.points = points;
        this.lastshop = lastshop;
    }

    public FidelityCard() {
    }

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "fidelity")
    private Clients client;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastshop() {
        return lastshop;
    }

    public void setLastshop(String lastshop) {
        this.lastshop = lastshop;
    }

    public Clients getClient(){
        return client;
    }

    public void setUser(Clients client){
        this.client = client;
    }

}
