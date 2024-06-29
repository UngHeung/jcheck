package com.group.jcheck.dto.distributor.response;

import com.group.jcheck.domain.distributor.Distributor;
import lombok.Data;

@Data
public class DistributorResponse {
    private final Long id;
    private final String distributorName;
    private final String distributorType;

    public DistributorResponse(Distributor distributor) {
        this.id = distributor.getId();
        this.distributorName = distributor.getDistributorName();
        this.distributorType = distributor.getDistributorType();
    }
}
