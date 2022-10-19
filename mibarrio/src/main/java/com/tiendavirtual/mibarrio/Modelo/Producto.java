/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tiendavirtual.mibarrio.Modelo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pro_id_pk")
    private Long idpk;
    
    @Column(name = "prod_descripcion")
    @NotNull(message = "El campo descripcion no puede estar null")
    private String descripcion;
    
    /**
     * utilizamos la librearia de validation el cual nos 
     * permite valida si un campo viene null o vacio
     * 
     * */
    @Column(name = "prod_costo")
    @NotNull(message = "El campo costo no puede estar null")
    private double costo;

    public Producto() {
    }

    
    public Long getIdpk() {
        return idpk;
    }

    public void setIdpk(Long idpk) {
        this.idpk = idpk;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
        
}
