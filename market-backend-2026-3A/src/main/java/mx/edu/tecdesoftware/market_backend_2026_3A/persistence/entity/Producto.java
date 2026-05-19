package mx.edu.tecdesoftware.market_backend_2026_3A.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name="productos")
public class Producto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Integer idProducto;

    private String nombre;

    @Column(name="id_categoria")
    private Integer id_categoria;

    @Column(name="codigo_barras")
    private String codigo_barras;

    @Column(name="precio_venta")
    private Double precio_venta;

    @Column (name= "cantidad_stock")
    private Integer cantidad_stock;

    private Boolean estado;
}
