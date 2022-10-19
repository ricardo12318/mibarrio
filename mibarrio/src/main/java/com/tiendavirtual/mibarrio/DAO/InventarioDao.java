package com.tiendavirtual.mibarrio.DAO;

import com.tiendavirtual.mibarrio.Modelo.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InventarioDao extends JpaRepository<Inventario, Long> {
    
}
