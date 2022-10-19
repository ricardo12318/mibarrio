/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tiendavirtual.mibarrio.Service;

import com.tiendavirtual.mibarrio.Modelo.Proveedor;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ServiceProveedor {
    
    List<Proveedor> getListaProveedor();
    Proveedor crearProveedor(Proveedor proveedor);
    Proveedor ActualizarProveedor(Proveedor proveedor);
    Boolean EliminarProveedor(Long id);
    
}
