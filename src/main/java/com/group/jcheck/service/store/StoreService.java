package com.group.jcheck.service.store;

import com.group.jcheck.domain.store.Store;
import com.group.jcheck.dto.store.request.CreateStoreRequest;
import com.group.jcheck.repository.store.StoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StoreService {
    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Transactional
    public String createStore(CreateStoreRequest request) {
        if (storeRepository.findByStoreName().isPresent())
            throw new IllegalArgumentException("이미 해당 이름으로 등록된 판매점이 있습니다.");
        storeRepository.save(new Store(request));
        return "판매점이 정상적으로 등록되었습니다.";
    }
}
