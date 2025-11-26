package com.retirementpro.service;

import com.retirementpro.model.Beneficiary;
import com.retirementpro.repository.BeneficiaryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BeneficiaryService {
    private final BeneficiaryRepository repository;

    public BeneficiaryService(BeneficiaryRepository repository) {
        this.repository = repository;
    }

    public List<Beneficiary> getAllBeneficiaries() {
        return repository.findAll();
    }

    public Beneficiary createBeneficiary(Beneficiary beneficiary) {
        return repository.save(beneficiary);
    }

    public Double calculateAnnualBenefit(Long id) {
        return repository.findById(id)
            .map(b -> b.getMonthlyBenefit() * 12)
            .orElse(0.0);
    }
}
