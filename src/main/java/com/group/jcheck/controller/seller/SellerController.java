package com.group.jcheck.controller.seller;

import com.group.jcheck.domain.seller.Seller;
import com.group.jcheck.dto.seller.request.*;
import com.group.jcheck.dto.seller.response.SellerResponse;
import com.group.jcheck.service.seller.SellerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SellerController {
    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping("/seller/read_all")
    public List<SellerResponse> readSellers() {
        return sellerService.readSellers();
    }

    @GetMapping("/seller/find/id")
    public Seller readSeller(@RequestBody FindSellerIdRequest request) {
        return sellerService.readSeller(request);
    }

    @PutMapping("/seller/update/name")
    public String updateSellerName(@RequestBody UpdateSellerNameRequest request) {
        return sellerService.updateSellerName(request);
    }

    @PutMapping("/seller/update/phone_number")
    public String updateSellerPhoneNumber(@RequestBody UpdateSellerPhoneNumberRequest request) {
        return sellerService.updateSellerPhoneNumber(request);
    }

    @PutMapping("/seller/update/password")
    public String updateSellerPassword(@RequestBody UpdateSellerPasswordRequest request) {
        return sellerService.updateSellerPassword(request);
    }

    @PutMapping("/seller/reset/password")
    public String resetSellerPassword(@RequestBody ResetSellerPasswordRequest request) {
        return sellerService.resetSellerPassword(request);
    }

    @DeleteMapping("seller")
    public String deleteSeller(@RequestBody DeleteSellerRequest request) {
        return sellerService.deleteSeller(request);
    }
}
