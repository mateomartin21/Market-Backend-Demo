package mx.edu.tecdesoftware.market_backend_2026_3A.persistence;

import mx.edu.tecdesoftware.market_backend_2026_3A.domain.Product;
import mx.edu.tecdesoftware.market_backend_2026_3A.domain.repository.ProductRepository;
import mx.edu.tecdesoftware.market_backend_2026_3A.persistence.crud.ProductoCrudRepository;
import mx.edu.tecdesoftware.market_backend_2026_3A.persistence.entity.Producto;
import mx.edu.tecdesoftware.market_backend_2026_3A.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
//Le dice a Spring que esta clase se comunicara con la BD
public class ProductoRepository implements ProductRepository {

    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private final ProductMapper productMapper;



    public ProductoRepository(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }


    public List<Product> getALL() {
        List<Producto> productos= (List<Producto>) productoCrudRepository.findAll();
        return productMapper.toProducts(productos);
    }

    public Optional<List<Product>>getByCategory(int categoryId) {
        List<Producto> productos= productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(productMapper.toProducts(productos));
    }

    public Optional <List<Product>> getScarceProducts(int quantity){
        Optional <List<Producto>> productos= productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return Optional.of(productMapper.toProducts(productos.get()));
    }

    //Obtener un producto dado el id
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> productMapper.toProduct(producto));
    }

    //Guardar un producto
    public Product save(Product product) {
        Producto producto= productMapper.toProducto(product);
        return productMapper.toProduct(productoCrudRepository.save(producto));
    }

    public void delete(int  productId) {

        productoCrudRepository.deleteById(productId);
    }




}