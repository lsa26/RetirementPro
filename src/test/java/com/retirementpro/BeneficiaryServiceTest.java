package com.retirementpro;

import com.retirementpro.model.Beneficiary;
import com.retirementpro.repository.BeneficiaryRepository;
import com.retirementpro.service.BeneficiaryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BeneficiaryServiceTest {
    @Mock
    private BeneficiaryRepository repository;

    @InjectMocks
    private BeneficiaryService service;

    @Test
    public void testCalculateAnnualBenefit() {
        Beneficiary beneficiary = new Beneficiary("John", "Doe", "123-45-6789", 1500.0);
        beneficiary.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(beneficiary));

        Double annual = service.calculateAnnualBenefit(1L);
        assertEquals(18000.0, annual);
    }

    @Test
    public void testCreateBeneficiary() {
        Beneficiary beneficiary = new Beneficiary("Jane", "Smith", "987-65-4321", 2000.0);
        when(repository.save(any(Beneficiary.class))).thenReturn(beneficiary);

        Beneficiary created = service.createBeneficiary(beneficiary);
        assertNotNull(created);
        assertEquals("Jane", created.getFirstName());
    }
}
