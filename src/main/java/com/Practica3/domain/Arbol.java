package com.Practica3.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "arbol")
public class Arbol implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArbol;
    
    private String nombreComun;
    private String tipoFlor;
    private Double alturaPromedio;
    private Integer esperanzaVida;
    private String rutaImagen;
}
