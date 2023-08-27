package com.copayment.models;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
/**
 *
 * @Entity Sirve para marcar una clase que representa una tabla en un db
 * relacional.
 * */
@Entity
/**
 * espeficamos que la entidad esta mapeada a la tabla.
 ***/
@Table(name = "erca_empleados")
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private long id_empleado;
    @Column(name = "nombre")
    private  String nombre;
    @Column(name = "apellido_materno")
    private  String apellido_materno;
    @Column(name = "apellido_paterno")
    private  String apellido_paterno;
    @Column(name = "departamento")
    private String departamento;
    @Column(name = "pago_por_hora")
    private BigDecimal pago_por_hora;
    public BigDecimal getPago_por_hora() {
        return pago_por_hora;
    }

    public void setPago_por_hora(BigDecimal pago_por_hora) {
        this.pago_por_hora = pago_por_hora;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(long id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
