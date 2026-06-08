package mx.edu.tecdesoftware.market_backend_2026_3A.domain.repository;

import mx.edu.tecdesoftware.market_backend_2026_3A.domain.Category;
import mx.edu.tecdesoftware.market_backend_2026_3A.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository {
    List<Product> getALL();
    Optional<List<Product>> getByCategory(int categoryId);

    Optional<List<Product>> getScarceProducts(int quantity);

    Optional<Product> getProduct(int productId);

    Product save(Product product);
    void delete(int productId);

}
