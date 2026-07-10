package mx.edu.tecdesoftware.market_backend_2026_3A.persistence.mapper;

import mx.edu.tecdesoftware.market_backend_2026_3A.domain.PurchaseItem;
import mx.edu.tecdesoftware.market_backend_2026_3A.persistence.entity.ComprasProductos;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(source = "id.idCompra", target = "purchaseId"),
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "total", target = "total"),
            @Mapping(source = "estado", target = "status")
    })
    PurchaseItem toPurchaseItem(ComprasProductos comprasProductos);
    List<PurchaseItem> toPurchaseItems(List<ComprasProductos> comprasProductos);

    @InheritInverseConfiguration
    @Mapping(target = "compra", ignore = true)
    ComprasProductos toComprasProductos(PurchaseItem purchaseItem);
}
