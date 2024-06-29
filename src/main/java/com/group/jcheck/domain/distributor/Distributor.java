package com.group.jcheck.domain.distributor;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Distributor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false, length = 20)
    private String distributorName;
    @Column(nullable = false, length = 10)
    private String distributorType;

    public Distributor() {};

    public Distributor(String distributorName, String distributorType) {
        this.distributorName = distributorName;
        this.distributorType = distributorType;
    }

    public void updateName(String newDistributorName) {
        this.distributorName = newDistributorName;
    }

    public void updateType(String newDistributorType) {
        this.distributorType = newDistributorType;
    }
}
