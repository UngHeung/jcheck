package com.group.jcheck.repository.distributor;

import com.group.jcheck.domain.distributor.Distributor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DistributorRepository extends JpaRepository<Distributor, Long> {
    Optional<Distributor> findByDistributorName(String DistributorName);
    List<Distributor> findAllByDistributorType(String DistributorType);
}
