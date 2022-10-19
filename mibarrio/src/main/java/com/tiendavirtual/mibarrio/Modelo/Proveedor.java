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
import javax.validation.constraints.Size;


@Entity
@Table(name = "proveedor")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "prov_id_pk")
    private Long idpk;
    
    @Column(name = "prov_nombre", nullable = false)
    private String nombre;
    
    /**
     * esta vez volvemos a utilizar la propiedad validation esta vez con size
     * que nos permite fijar la cantidad de carateres a aceptar
     * 
     * */
    @Column(name = "prov_nit")
    @Size(min = 9,max = 11,message = "el nit solo se permiten un rango de 9 a 11 carateres")
    private String nit;
    
    @Column(name = "prov_tel")
    @Size(min = 8,max = 15,message = "el numero telefono solo se "
            + "permiten un rango de 9 a 15 carateres")
    private String telefono;

    public Proveedor() {
    }

    
    
    public Long getIdpk() {
        return idpk;
    }

    public void setIdpk(Long idpk) {
        this.idpk = idpk;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
