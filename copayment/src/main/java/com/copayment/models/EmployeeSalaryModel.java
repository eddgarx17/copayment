package com.copayment.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @Entity Sirve para marcar una clase que representa una tabla en un db
 * relacional.
 * */
@Entity
public class EmployeeSalaryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long id_empleado;
    private String nombre;
    private String departamento;
    private LocalDateTime dia;
    private int horas_trabajadas;
    private BigDecimal pago_por_hora;
    private BigDecimal salario_diario_por_media_de_pago_por_hora;
    private BigDecimal salario_diario_por_horas_trabajadas;
    public Long getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Long id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public LocalDateTime getDia() {
        return dia;
    }

    public void setDia(LocalDateTime dia) {
        this.dia = dia;
    }

    public int getHoras_trabajadas() {
        return horas_trabajadas;
    }

    public void setHoras_trabajadas(int horas_trabajadas) {
        this.horas_trabajadas = horas_trabajadas;
    }

    public BigDecimal getPago_por_hora() {
        return pago_por_hora;
    }

    public void setPago_por_hora(BigDecimal pago_por_hora) {
        this.pago_por_hora = pago_por_hora;
    }

    public BigDecimal getSalario_diario_por_media_de_pago_por_hora() {
        return salario_diario_por_media_de_pago_por_hora;
    }

    public void setSalario_diario_por_media_de_pago_por_hora(BigDecimal salario_diario_por_media_de_pago_por_hora) {
        this.salario_diario_por_media_de_pago_por_hora = salario_diario_por_media_de_pago_por_hora;
    }

    public BigDecimal getSalario_diario_por_horas_trabajadas() {
        return salario_diario_por_horas_trabajadas;
    }

    public void setSalario_diario_por_horas_trabajadas(BigDecimal salario_diario_por_horas_trabajadas) {
        this.salario_diario_por_horas_trabajadas = salario_diario_por_horas_trabajadas;
    }


}
