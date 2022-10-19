package com.tiendavirtual.mibarrio.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "inventario") //nombre de referencia en base de datos
public class Inventario {
    
    //ahora crearemos los atributos 
    @Id //le decimos que esta es la columna id de nuestra tabla
    @GeneratedValue(strategy = GenerationType.AUTO)//llave primaria inventario , con generacion automatica
    @Column(name = "inv_id_pk") //nombre de la columna en base de datos
    private Long idpk; 
    
    @Column(name = "inv_stock",nullable = false) //le decimos que no permita valores nulos
    private int stock; // si no se utiliza nombre, se pone el nombre del atributo
    
    @Column(name = "inv_sucursal",nullable = false)
    private int secursal; // id sucarsal que realizo el movimiento
  
    /**
     * manytoOne muchos a uno
     * Fecht carga perezosa
     * una relacions con la tabla producto join column
     * json ignore para que no genere error al cargar la lista perezosa
     **/
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "inv_idproducto_fk")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Producto producto; // 
    
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "inv_idproveedor_fk")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Proveedor proveedor;

    public Inventario() {
        
    }

    public Long getIdpk() {
        return idpk;
    }

    public void setIdpk(Long idpk) {
        this.idpk = idpk;
    }


    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSecursal() {
        return secursal;
    }

    public void setSecursal(int secursal) {
        this.secursal = secursal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
        
}
