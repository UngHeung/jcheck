package com.group.jcheck.controller.seller;

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

    @PostMapping("/seller")
    public String createSeller(@RequestBody CreateSellerRequest request) {
        return sellerService.createSeller(request);
    }

    @GetMapping("/seller")
    public List<SellerResponse> readSellers() {
        return sellerService.readSellers();
    }

    @GetMapping("/seller_find_id")
    public SellerResponse readSeller(@RequestBody FindSellerIdRequest request) {
        return sellerService.readSeller(request);
    }

    @PutMapping("/seller_name")
    public String updateSellerName(@RequestBody UpdateSellerNameRequest request) {
        return sellerService.updateSellerName(request);
    }

    @PutMapping("/seller_phone_number")
    public String updateSellerPhoneNumber(@RequestBody UpdateSellerPhoneNumberRequest request) {
        return sellerService.updateSellerPhoneNumber(request);
    }

    @PutMapping("/seller_password")
    public String updateSellerPassword(@RequestBody UpdateSellerPasswordRequest request) {
        return sellerService.updateSellerPassword(request);
    }

    @PutMapping("/seller_password_reset")
    public String resetSellerPassword(@RequestBody ResetSellerPasswordRequest request) {
        return sellerService.resetSellerPassword(request);
    }

    @DeleteMapping("seller")
    public String deleteSeller(@RequestBody DeleteSellerRequest request) {
        return sellerService.deleteSeller(request);
    }
}
