package mx.edu.tecdesoftware.market_backend_2026_3A.persistence;

import mx.edu.tecdesoftware.market_backend_2026_3A.persistence.crud.ProductoCrudRepository;
import mx.edu.tecdesoftware.market_backend_2026_3A.persistence.entity.Producto;
import java.util.List;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;
    
    public List<Producto> getAll() {
        return (List<Producto>) productoCrudRepository.findAll(); 
    }
}