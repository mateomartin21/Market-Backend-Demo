package mx.edu.tecdesoftware.market_backend_2026_3A.domain.repository;


import mx.edu.tecdesoftware.market_backend_2026_3A.domain.Purchase;

import java.util.List;
import java.util.Optional;
public interface PurchaseRepository
{
    List<Purchase> getAll();
    Optional <Purchase> getById(int purchaseId);
    Purchase save(Purchase purchase);
    void delete(Purchase purchase);

}
