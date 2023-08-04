package com.example.ejercicio3m6.modelos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Capacitacion {

    private int numCapacitacion;
    private String nombre;
    private String detalle;
    private String rutCliente;
    private String diaSemana;
    private String hora;
    private String lugar;
    private String duracion;
    private int cantAsistentes;


}
