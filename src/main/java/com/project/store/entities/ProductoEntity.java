package com.project.store.entities;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "PRODUCTOS")
public class ProductoEntity implements Serializable {

    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;
    
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_producto" , unique = true)
    private String nombreProducto;

    @NotNull
    @Column(name = "precio_producto")
    private Double precioProducto;

    @NotNull
    @Column(name = "cantidad_producto")
    private Integer cantidadProducto;



}
