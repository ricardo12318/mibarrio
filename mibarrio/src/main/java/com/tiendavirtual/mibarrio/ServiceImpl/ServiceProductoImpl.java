package com.tiendavirtual.mibarrio.ServiceImpl;

import com.tiendavirtual.mibarrio.DAO.ProductoDao;
import com.tiendavirtual.mibarrio.Modelo.Producto;
import com.tiendavirtual.mibarrio.Service.ServiceProducto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceProductoImpl implements ServiceProducto {

    @Autowired
    private ProductoDao getDao;

    @Override
    public List<Producto> getListaProducto() {
        return getDao.findAll();
    }
    @Override
    public Producto crearProducto(Producto producto) {
        if (producto != null) {
            return getDao.save(producto);
        }
        return null;
    }
    @Override
    public Producto ActualizarProducto(Producto producto) {
        if (producto != null && producto.getIdpk() != 0) {
            Producto productoBD = getDao.getReferenceById(producto.getIdpk());
            if (productoBD != null) {
                productoBD.setCosto(producto.getCosto());
                productoBD.setDescripcion(producto.getDescripcion());
                return getDao.save(productoBD);
            }
        }
        return null;
    }

    @Override
    public Boolean EliminarProducto(Long id) {
        if (id != null && id != 0) {
            Producto productoBD = getDao.getReferenceById(id);
            if (productoBD != null) {
                getDao.deleteById(id);
                return true;
            }
        }
        return false;
    }

}
