package com.tiendavirtual.mibarrio.DAO;

import com.tiendavirtual.mibarrio.Modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductoDao extends JpaRepository<Producto, Long>{
    
}
