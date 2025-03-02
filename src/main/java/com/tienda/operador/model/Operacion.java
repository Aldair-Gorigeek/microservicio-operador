package com.tienda.operador.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "operaciones")
public class Operacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tipo; // Ej: "COMPRA", "ALQUILER"

    @Column(nullable = false)
    private Long itemId; // ID del ítem en Microservicio Buscador

    @Column(nullable = false)
    private Long usuarioId; // ID del usuario que realizó la operación

    @Column(nullable = false)
    private LocalDateTime fecha;

    public Long getItemId() {
        return itemId;
    }
    
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
