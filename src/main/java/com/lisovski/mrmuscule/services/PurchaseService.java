package com.lisovski.mrmuscule.services;

import com.lisovski.mrmuscule.models.Purchase;
import com.lisovski.mrmuscule.repositories.PurchaseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PurchaseService {
    PurchaseRepository purchaseRepository;

    public void addAllPurchases(List<Purchase> purchaseList){
        purchaseRepository.saveAll(purchaseList);
    }
}
