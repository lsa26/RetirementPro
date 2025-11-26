package com.retirementpro.controller;

import com.retirementpro.model.Beneficiary;
import com.retirementpro.service.BeneficiaryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/beneficiaries")
public class BeneficiaryController {
    private final BeneficiaryService service;

    public BeneficiaryController(BeneficiaryService service) {
        this.service = service;
    }

    @GetMapping
    public List<Beneficiary> getAll() {
        return service.getAllBeneficiaries();
    }

    @PostMapping
    public Beneficiary create(@RequestBody Beneficiary beneficiary) {
        return service.createBeneficiary(beneficiary);
    }

    @GetMapping("/{id}/annual-benefit")
    public Double getAnnualBenefit(@PathVariable Long id) {
        return service.calculateAnnualBenefit(id);
    }
}
