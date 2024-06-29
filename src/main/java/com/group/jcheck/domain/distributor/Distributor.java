package com.group.jcheck.domain.distributor;

import com.group.jcheck.dto.distributor.request.CreateDistributorRequest;
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

    public Distributor(CreateDistributorRequest request) {
        this.distributorName = request.getDistributorName();
        this.distributorType = request.getDistributorType();
    }

    public void updateName(String newDistributorName) {
        this.distributorName = newDistributorName;
    }

    public void updateType(String newDistributorType) {
        this.distributorType = newDistributorType;
    }
}
