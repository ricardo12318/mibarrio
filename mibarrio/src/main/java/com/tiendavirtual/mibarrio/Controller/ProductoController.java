package com.tiendavirtual.mibarrio.Controller;

import com.tiendavirtual.mibarrio.Modelo.Producto;
import com.tiendavirtual.mibarrio.ServiceImpl.ServiceProductoImpl;
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
@RequestMapping(value = "/producto")
public class ProductoController {

    @Autowired
    private ServiceProductoImpl serviceProducto;

    @GetMapping(value = "")
    public ResponseEntity<List<Producto>> ListaProducto() {
        List<Producto> lista = serviceProducto.getListaProducto();
        return ResponseEntity.ok(lista);
    }

    @PostMapping(value = "")
    public ResponseEntity<Producto> CrearProducto(@Valid @RequestBody Producto inventario, BindingResult result) {
        if (result.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, result.getFieldError()
                    .getDefaultMessage());
        }
        Producto crear = serviceProducto.crearProducto(inventario);
        return ResponseEntity.ok(crear);
    }

    @PutMapping(value = "")
    public ResponseEntity<Producto> ActualizarProducto(@RequestBody Producto inventario) {
        Producto actualizar = serviceProducto.ActualizarProducto(inventario);
        return ResponseEntity.ok(actualizar);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> EliminarProducto(@PathVariable("id") Long id) {
        if (id != null) {
            if (serviceProducto.EliminarProducto(id)) {
                return ResponseEntity.ok().body("Eliminado");
            }
        }

        return ResponseEntity.notFound().build();
    }
}
