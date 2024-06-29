package com.group.jcheck.dto.store.response;

import com.group.jcheck.domain.store.Store;
import lombok.Data;

@Data
public class StoreResponse {
    private final Long id;
    private final String storeName;
    private final String storeCode;

    public StoreResponse(Store store) {
        this.id = store.getId();
        this.storeName = store.getStoreName();
        this.storeCode = store.getStoreCode();
    }
}
