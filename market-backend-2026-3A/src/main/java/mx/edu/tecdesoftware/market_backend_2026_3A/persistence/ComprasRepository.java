package mx.edu.tecdesoftware.market_backend_2026_3A.persistence;

import mx.edu.tecdesoftware.market_backend_2026_3A.domain.Purchase;
import mx.edu.tecdesoftware.market_backend_2026_3A.domain.repository.PurchaseRepository;
import mx.edu.tecdesoftware.market_backend_2026_3A.persistence.crud.CompraCrudRepository;
import mx.edu.tecdesoftware.market_backend_2026_3A.persistence.entity.Compra;
import mx.edu.tecdesoftware.market_backend_2026_3A.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ComprasRepository implements PurchaseRepository {

    @Autowired
    private CompraCrudRepository compraCrudRepository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return Optional.of(mapper.toPurchases(compraCrudRepository.findByIdCliente(clientId)));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);

        compra.setIdCompra(null);

        if (compra.getProductos() != null) {
            compra.getProductos().forEach(producto -> {
                producto.setCompra(compra);
                if (producto.getId() != null) {
                    producto.getId().setIdCompra(null);
                }
            });
        }

        return mapper.toPurchase(compraCrudRepository.save(compra));
    }
}
