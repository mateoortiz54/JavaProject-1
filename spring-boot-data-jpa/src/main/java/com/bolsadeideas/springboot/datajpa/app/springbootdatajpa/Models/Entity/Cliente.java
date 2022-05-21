package com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity /* Esto lo comunica con la BD */
@Table(name = "clientes") /* Creamos la tabla */
public class Cliente implements Serializable{
    
    private static final long serialVersionUID = 1L; /*Necesaria para la comunicación con la  base de datos*/ 

    @Id /*Aquí lo marcamos para dar a entender que es el Id en la BD*/ 
    @GeneratedValue(strategy = GenerationType.IDENTITY)/*Esto es lo que nos da el AutoIncrement en la BD*/
    private long id;

    @NotEmpty
    private String Nombre;

    @NotEmpty
    private String Apellido;

    @NotEmpty//validacion solo se utiliza con string cuando sea campo requerido
    @Email//Validacion
    private String Email;

    @NotNull
    @Column(name = "create_at") /*Esto es e nombre de la columna en la BD*/
    @Temporal(TemporalType.DATE) /*Le decimos que este es un tipo de dato TEMPORAL y DATE, esto con el fin de comunicarlo con la BD*/ 
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date CreateAt;

    /*@PrePersist //Para decir que la fecha es de hoy
    public void PrePersist(){

        CreateAt = new Date();
    }*/

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Date getCreateAt() {
        return CreateAt;
    }

    public void setCreateAt(Date createAt) {
        CreateAt = createAt;
    }

}
