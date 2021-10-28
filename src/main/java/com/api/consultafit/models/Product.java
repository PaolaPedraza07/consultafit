package com.api.consultafit.models;

import javax.persistence.*;
//import java.sql.Date;
import java.util.Date;

@Entity //ORM esta en fucnión e para definir que es una tabla
@Table(name = "producto") //Aqui se define como se llama la tabla a relacionar
public class Product {


    /*Variables con todito y su linkeo con la DB de ConsultaFit*/
    @Column(name="archivo")
    String archivo;
    @Column(name="categoria") //Se escribe para mapear directamente con las columnas de SQL
    String categoria;
    @Column(name="color")
    String color;
    @Column(name="descrip")
    String descrip;

    @Id //Con esta notación se define el PrimaryKey
//    @GeneratedValue(strategy = GenerationType.AUTO)//Para el autoincremento
    @Column(name="id_Producto",unique=true,nullable=false)
    Integer id;

    @Column(name="marca")
    String marca;
    @Column(name="nombre")
    String nombre;
    @Column(name="precio")
    Integer precio;
    @Column(name="talla")
    String talla;
    @Column(name="cantidad")
    Integer cantidad;



    //Getters & Setters


    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
