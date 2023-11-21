package com.scamposb.salesAPI.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "brands")
public class Brands {
    
    @Id
    @Column(name = "id")
    private int Id;

    @Column(name = "name")
    private String Name;
}
