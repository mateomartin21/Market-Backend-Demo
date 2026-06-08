package mx.edu.tecdesoftware.market_backend_2026_3A.persistence.mapper;
import mx.edu.tecdesoftware.market_backend_2026_3A.domain.Product;
import mx.edu.tecdesoftware.market_backend_2026_3A.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses={CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "precio_venta", target = "price"),
            @Mapping(source = "cantidad_stock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "categoria", target = "category")
    }
    )
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos);

    @InheritInverseConfiguration
    @Mapping(target= "codigo_barras", ignore = true)
    Producto toProducto(Product product);
}
