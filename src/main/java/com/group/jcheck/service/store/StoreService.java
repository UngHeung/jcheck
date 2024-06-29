package com.group.jcheck.service.store;

import com.group.jcheck.domain.store.Store;
import com.group.jcheck.dto.store.request.CreateStoreRequest;
import com.group.jcheck.dto.store.request.UpdateStoreCodeRequest;
import com.group.jcheck.dto.store.request.UpdateStoreNameRequest;
import com.group.jcheck.dto.store.response.StoreResponse;
import com.group.jcheck.repository.store.StoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreService {
    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Transactional
    public String createStore(CreateStoreRequest request) {
        if (storeRepository.findByStoreName(request.getStoreName()).isPresent())
            throw new IllegalArgumentException("이미 해당 이름으로 등록된 판매점이 있습니다.");
        storeRepository.save(new Store(request));
        return "판매점이 정상적으로 등록되었습니다.";
    }

    @Transactional
    public List<StoreResponse> readStores() {
        return storeRepository.findAll().stream()
                .map(StoreResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Store readStoreByStoreName(String storeName) {
        return storeRepository.findByStoreName(storeName)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Transactional
    public String updateStoreName(UpdateStoreNameRequest request) {
        if (storeRepository.findByStoreName(request.getNewStoreName()).isPresent())
            throw new IllegalArgumentException("이미 해당 이름으로 등록된 판매점이 있습니다.");
        Store store = storeRepository.findByStoreName(request.getStoreName())
                .orElseThrow(IllegalArgumentException::new);
        String currentStoreName = request.getStoreName();
        store.updateStoreName(request.getNewStoreName());
        return currentStoreName + " 판매점 이름이 " + store.getStoreName() + "으로 변경되었습니다.";
    }

    @Transactional
    public String updateStoreCode(UpdateStoreCodeRequest request) {
        if (storeRepository.findByStoreName(request.getNewStoreCode()).isPresent())
            throw new IllegalArgumentException("이미 해당 코드로 등록된 판매점이 있습니다.");
        Store store = storeRepository.findByStoreCode(request.getStoreCode())
                .orElseThrow(IllegalArgumentException::new);
        String currentStoreCode = request.getStoreCode();
        store.updateStoreCode(request.getNewStoreCode());
        return currentStoreCode + " 판매점 코드가 " + store.getStoreCode() + "으로 변경되었습니다.";
    }

    @Transactional
    public String deleteStore(String storeName) {
        Store store = storeRepository.findByStoreName(storeName)
                .orElseThrow(IllegalArgumentException::new);
        String deleteStoreName = store.getStoreName();
        storeRepository.delete(store);
        return deleteStoreName + " 판매점 삭제가 완료되었습니다.";
    }
}
