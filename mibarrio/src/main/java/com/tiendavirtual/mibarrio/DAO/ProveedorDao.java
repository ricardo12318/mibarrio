package com.tiendavirtual.mibarrio.DAO;

import com.tiendavirtual.mibarrio.Modelo.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProveedorDao extends JpaRepository<Proveedor, Long>{
    
}
