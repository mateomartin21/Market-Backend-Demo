package mx.edu.tecdesoftware.market_backend_2026_3A.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name= "categorias")
public class Categorias {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_categoria")
    private Integer idCategoria;

    private String descripcion;

    private Boolean estado;

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
