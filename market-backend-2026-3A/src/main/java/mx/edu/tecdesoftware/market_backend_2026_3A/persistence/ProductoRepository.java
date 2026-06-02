package mx.edu.tecdesoftware.market_backend_2026_3A.persistence;

import mx.edu.tecdesoftware.market_backend_2026_3A.persistence.crud.ProductoCrudRepository;
import mx.edu.tecdesoftware.market_backend_2026_3A.persistence.entity.Producto;
import java.util.List;
import java.util.Optional;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;
    
    public List<Producto> getAll() {
        return (List<Producto>) productoCrudRepository.findAll(); 
    }

    public List<Producto> findByCategoria(int idCategoria) {
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional <List<Producto>> getEscaso(int cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    //Obtener un producto dado el id
    public Optional<Producto> getProductoById(int idProducto) {
        return productoCrudRepository.findById(idProducto);
    }

    //Guardar un producto
    public Producto save(Producto producto) {
        return productoCrudRepository.save(producto);
    }

    public void delete(int idProducto) {
        productoCrudRepository.deleteById(idProducto);
    }




}