package com.project.store.entities;


import java.io.Serializable;
import java.util.Collection;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "USUARIOS")
public class UsuarioEntity implements Serializable {

    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nombres_usuario")
    private String nombresUsuario;

    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "email_usuario", unique = true)
    private String emailUsuario;

    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "password_usuario")
    private String passwordUsuario;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "Usuarios_roles", joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "id_rol"))
    private Collection<RolEntity> role;

}

