package com.group.jcheck.domain.store;

import com.group.jcheck.dto.store.request.CreateStoreRequest;
import com.group.jcheck.dto.store.response.StoreResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;
    private String storeName;
    private String storeCode;

    public Store() {}

    public Store(CreateStoreRequest request) {
        this.storeName = request.getStoreName();
        this.storeCode = request.getStoreCode();
    }

    public void updateStoreName(String newStoreName) {
        this.storeName = newStoreName;
    }

    public void updateStoreCode(String newStoreCode) {
        this.storeCode = newStoreCode;
    }
}
