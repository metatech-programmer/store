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
@Table(name = "ROLES")
public class RolEntity implements Serializable {

    private static final long seriarVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long idRol;

    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombre_rol")
    private String nombreRol;

    public RolEntity(String nombreRol) {
        super();
        this.nombreRol = nombreRol;
    }

    public RolEntity() {

    }

}
