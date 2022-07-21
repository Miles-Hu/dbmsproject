package com.example.demo;

import com.example.demo.models.Merchant;
import com.example.demo.repository.MerchantRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
class RepositoryTest {

    @MockBean
    private MerchantRepository merchantRepository;

    @Before
    public void init() {
        Merchant merchant = new Merchant("A-001","Amazon Basic","Tools in daily life",true);
        when(merchantRepository.findById("A-001")).thenReturn(Optional.of(merchant));
        when(merchantRepository.save(merchant)).thenReturn(merchant);
        merchant.setActive(false);
        when(merchantRepository.save(merchant)).thenReturn(merchant);
    }

    @Test
    void saveMerchantTest() {
        Merchant merchant = new Merchant("A-001","Amazon Basic","Tools in daily life",true);
        Merchant response = merchantRepository.save(merchant);
        verify(response);
    }

    @Test
    void findMerchantTest() {
        Optional<Merchant> response = merchantRepository.findById("A-001");
        verify(response);
    }
}