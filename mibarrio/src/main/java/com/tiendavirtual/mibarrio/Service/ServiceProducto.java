
package com.tiendavirtual.mibarrio.Service;

import com.tiendavirtual.mibarrio.Modelo.Producto;
import java.util.List;


public interface ServiceProducto {
    
    List<Producto> getListaProducto();
    Producto crearProducto(Producto producto);
    Producto ActualizarProducto(Producto producto);
    Boolean EliminarProducto(Long id);
}
