package com.copayment.models;

import jakarta.persistence.*;

import java.io.Serializable;
/**
 *
 * @Entity Sirve para marcar una clase que representa una tabla en un db
 * relacional.
 * */
@Entity
/**
 * espeficamos que la entidad esta mapeada a la tabla.
 ***/
@Table(name = "erca_usuarios")
public class UserModel  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id_usuario;

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "password")
    private String password;
}
