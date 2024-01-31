package com.project.store.entities;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "BASES")
public class BaseEntity implements Serializable {

    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_base")
    private Long idBase;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_hora_base", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false)
    private Date fechaHoraBase;

    @NotNull
    @Column(name = "valor_base")
    private Double valorBase;

}
