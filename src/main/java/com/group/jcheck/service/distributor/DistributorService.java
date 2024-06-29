package com.group.jcheck.service.distributor;

import com.group.jcheck.domain.distributor.Distributor;
import com.group.jcheck.dto.distributor.request.CreateDistributorRequest;
import com.group.jcheck.dto.distributor.request.DeleteDistributorRequest;
import com.group.jcheck.dto.distributor.request.UpdateDistributorNameRequest;
import com.group.jcheck.dto.distributor.request.UpdateDistributorTypeRequest;
import com.group.jcheck.dto.distributor.response.DistributorResponse;
import com.group.jcheck.repository.distributor.DistributorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DistributorService {
    private final DistributorRepository distributorRepository;

    public DistributorService(DistributorRepository distributorRepository) {
        this.distributorRepository = distributorRepository;
    }

    @Transactional
    public String createDistributor(CreateDistributorRequest request) {
        Optional<Distributor> distributor = distributorRepository.findByDistributorName(request.getDistributorName());
        if (distributor.isPresent())
            throw new IllegalArgumentException("이미 해당 이름으로 등록된 대리점이 있습니다.");
        distributorRepository.save(new Distributor(request.getDistributorName(), request.getDistributorType()));
        return "새로운 대리점 등록이 완료되었습니다.";
    }

    @Transactional(readOnly = true)
    public List<DistributorResponse> readDistributors() {
        return distributorRepository.findAll().stream()
                .map(DistributorResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Distributor readDistributorsByName(String distributorName) {
        return distributorRepository.findByDistributorName(distributorName)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Transactional(readOnly = true)
    public List<DistributorResponse> readDistributorsByType(String distributorType) {
        return distributorRepository.findAllByDistributorType(distributorType).stream()
                .map(DistributorResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public String updateDistributorName(UpdateDistributorNameRequest request) {
        Distributor distributor = distributorRepository.findByDistributorName(request.getDistributorName())
                .orElseThrow(IllegalArgumentException::new);
        Optional<Distributor> currentDistributor = distributorRepository.findByDistributorName(request.getNewDistributorName());
        if (currentDistributor.isPresent())
            throw new IllegalArgumentException("이미 해당 이름으로 등록된 대리점이 있습니다.");
        if (!request.getSuperAdminPassword().equals("tempPw"))
            throw new IllegalArgumentException("비밀번호를 확인해주세요.");
        String currentDistributorName = distributor.getDistributorName();
        distributor.updateName(request.getNewDistributorName());
        return "대리점 이름이 " + currentDistributorName + "에서 " + distributor.getDistributorName() + "으로 변경되었습니다.";
    }

    @Transactional
    public String updateDistributorType(UpdateDistributorTypeRequest request) {
        Distributor distributor = distributorRepository.findByDistributorName(request.getDistributorName())
                .orElseThrow(IllegalArgumentException::new);
        if (!request.getSuperAdminPassword().equals("tempPw"))
            throw new IllegalArgumentException("비밀번호를 확인해주세요");
        String currentDistributorType = distributor.getDistributorType();
        distributor.setDistributorType(request.getNewDistributorType());
        return "대리점 통신사가 " + currentDistributorType + "에서 " + distributor.getDistributorType() + "으로 변경되었습니다.";
    }

    @Transactional
    public String deleteDistributor(DeleteDistributorRequest request) {
        Distributor distributor = distributorRepository.findByDistributorName(request.getDistributorName())
                .orElseThrow(IllegalArgumentException::new);
        if (!request.getSuperAdminPassword().equals("tempPw"))
            throw new IllegalArgumentException("비밀번호를 확인해주세요");
        String deleteDistributorName = distributor.getDistributorName();
        distributorRepository.delete(distributor);
        return deleteDistributorName + " 대리점 삭제가 완료되었습니다.";
    }

}
