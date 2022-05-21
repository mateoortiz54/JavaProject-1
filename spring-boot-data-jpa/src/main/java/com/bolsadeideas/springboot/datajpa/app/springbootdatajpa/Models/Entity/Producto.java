package com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "productos")
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id /*Aquí lo marcamos para dar a entender que es el Id en la BD*/ 
    @GeneratedValue(strategy = GenerationType.IDENTITY)/*Esto es lo que nos da el AutoIncrement en la BD*/
    private long id;

    @NotEmpty
    @Column(name = "nombre_producto")
    private String NombreProducto;

    @NotNull
    @Column(name = "fecha") /*Esto es e nombre de la columna en la BD*/
    @Temporal(TemporalType.DATE) /*Le decimos que este es un tipo de dato TEMPORAL y DATE, esto con el fin de comunicarlo con la BD*/ 
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date Fecha;

    @NotNull
    private int Cantidad;

    @NotNull
    private int Precio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        NombreProducto = nombreProducto;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int precio) {
        Precio = precio;
    }

   


}
