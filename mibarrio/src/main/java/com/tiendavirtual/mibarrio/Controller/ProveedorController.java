
package com.tiendavirtual.mibarrio.Controller;

import com.tiendavirtual.mibarrio.Modelo.Proveedor;
import com.tiendavirtual.mibarrio.ServiceImpl.ServiceProveedorImpl;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
@CrossOrigin(origins={"http://127.0.0.1:5502"})
@RequestMapping(value = "/proveedor")
public class ProveedorController {
    @Autowired
    private ServiceProveedorImpl serviceProveedor;

    @GetMapping(value = "")
    public ResponseEntity<List<Proveedor>> ListaProveedor() {
        List<Proveedor> lista = serviceProveedor.getListaProveedor();
        return ResponseEntity.ok(lista);
    }

    @PostMapping(value = "")
    public ResponseEntity<Proveedor> CrearProveedor(@Valid @RequestBody Proveedor inventario, 
            BindingResult result) {
        if (result.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, result.getFieldError()
                    .getDefaultMessage());
        }
        Proveedor crear = serviceProveedor.crearProveedor(inventario);
        return ResponseEntity.ok(crear);
    }

    @PutMapping(value = "")
    public ResponseEntity<Proveedor> ActualizarProveedor(@RequestBody Proveedor inventario) {
        Proveedor actualizar = serviceProveedor.ActualizarProveedor(inventario);
        return ResponseEntity.ok(actualizar);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> EliminarProveedor(@PathVariable("id") Long id) {
        if (id != null) {
            if (serviceProveedor.EliminarProveedor(id)) {
                return ResponseEntity.ok().body("Eliminado");
            }
        }

        return ResponseEntity.notFound().build();
    }
}
