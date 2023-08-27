package com.copayment.models;
import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 *
 * @Entity Sirve para marcar una clase que representa una tabla en un db
 * relacional.
 * */
@Entity
/**
 * espeficamos que la entidad esta mapeada a la tabla.
 ***/
@Table(name = "erdo_entradas_salidas")
public class EmployeeLogEntryModel {
  /** @Id
      @GeneratedValue
      especificamos la llave primaria de la entidad
   */
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column
    private long id_entrada_salida;

    /**@Column hace referencia a la columna de db */

    @Column(name = "fecha")
    private LocalDateTime fecha;
    @Column(name = "tipo_registro")
    private String tipo_registro;

    /**indica  que id_empleado representa una relación de muchos a uno con otra entidad*/

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private EmployeeModel empleado;

    public long getId_entrada_salida() {
        return id_entrada_salida;
    }
    public void setId_entrada_salida(long id_entrada_salida) {
        this.id_entrada_salida = id_entrada_salida;
    }
    public String getTipo_registro() {
        return tipo_registro;
    }
    public void setTipo_registro(String tipo_registro) {
        this.tipo_registro = tipo_registro;
    }
    public LocalDateTime getFecha() {
        return fecha;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    public EmployeeModel getEmpleado() {
        return empleado;
    }
    public void setEmpleado(EmployeeModel employee) { this.empleado = employee;}

}
