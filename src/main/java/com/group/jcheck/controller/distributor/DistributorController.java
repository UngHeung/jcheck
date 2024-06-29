package com.group.jcheck.controller.distributor;

import com.group.jcheck.domain.distributor.Distributor;
import com.group.jcheck.dto.distributor.request.CreateDistributorRequest;
import com.group.jcheck.dto.distributor.request.DeleteDistributorRequest;
import com.group.jcheck.dto.distributor.request.UpdateDistributorNameRequest;
import com.group.jcheck.dto.distributor.request.UpdateDistributorTypeRequest;
import com.group.jcheck.dto.distributor.response.DistributorResponse;
import com.group.jcheck.service.distributor.DistributorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class DistributorController {
    private final DistributorService distributorService;

    public DistributorController(DistributorService distributorService) {
        this.distributorService = distributorService;
    }

    @PostMapping("/distributor")
    public String createDistributor(@RequestBody CreateDistributorRequest request) {
        return distributorService.createDistributor(request);
    }

    @GetMapping("/distributor")
    public List<DistributorResponse> readDistributors() {
        return distributorService.readDistributors();
    }

    @GetMapping("/distributor_name")
    public Distributor readDistributorsByName(@RequestBody Map<String, String> request) {
        return distributorService.readDistributorsByName(request.get("distributorName"));
    }

    @GetMapping("/distributor_type")
    public List<DistributorResponse> readDistributorsByType(@RequestBody Map<String, String> request) {
        return distributorService.readDistributorsByType(request.get("distributorType"));
    }

    @PutMapping("/distributor_name")
    public String updateDistributorName(@RequestBody UpdateDistributorNameRequest request) {
        return distributorService.updateDistributorName(request);
    }

    @PutMapping("/distributor_type")
    public String updateDistributorType(@RequestBody UpdateDistributorTypeRequest request) {
        return distributorService.updateDistributorType(request);
    }

    @DeleteMapping("/distributor")
    public String deleteDistributor(@RequestBody DeleteDistributorRequest request) {
        return distributorService.deleteDistributor(request);
    }
}
