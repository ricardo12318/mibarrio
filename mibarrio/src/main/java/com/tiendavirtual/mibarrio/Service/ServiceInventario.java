package com.tiendavirtual.mibarrio.Service;

import com.tiendavirtual.mibarrio.Modelo.Inventario;
import java.util.List;


public interface ServiceInventario {
    
    List<Inventario> getListaInventario();
    Inventario crearInventario(Inventario inventario);
    Inventario ActualizarStockInventario(Inventario inventario);
    Boolean EliminarInventario(Long id);
    
}
