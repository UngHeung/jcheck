package com.group.jcheck.controller.store;

import com.group.jcheck.domain.store.Store;
import com.group.jcheck.dto.store.request.CreateStoreRequest;
import com.group.jcheck.dto.store.request.DeleteStoreRequest;
import com.group.jcheck.dto.store.request.UpdateStoreCodeRequest;
import com.group.jcheck.dto.store.request.UpdateStoreNameRequest;
import com.group.jcheck.dto.store.response.StoreResponse;
import com.group.jcheck.service.store.StoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class StoreController {
    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping("/store")
    public String createStore(@RequestBody CreateStoreRequest request) {
        return storeService.createStore(request);
    }

    @GetMapping("/store")
    public List<StoreResponse> readStores() {
        return storeService.readStores();
    }

    @GetMapping("/store_name")
    public Store readStoreByStoreName(@RequestBody Map<String, String> request) {
        return storeService.readStoreByStoreName(request.get("storeName"));
    }

    @PutMapping("/store_name")
    public String updateStoreName(@RequestBody UpdateStoreNameRequest request) {
        return storeService.updateStoreName(request);
    }

    @PutMapping("/store_code")
    public String updateStoreCode(@RequestBody UpdateStoreCodeRequest request) {
        return storeService.updateStoreCode(request);
    }

    @DeleteMapping("/store")
    public String deleteStore(@RequestBody DeleteStoreRequest request) {
        return storeService.deleteStore(request);
    }
}
