package com.authentication.springsecurity.model.modelClients;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serial;
import java.io.Serializable;

@Document
@Data
public class Fidelity implements Serializable {
    @Serial
    private static final long serialVersionUID = -7003022118077818002L;
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
