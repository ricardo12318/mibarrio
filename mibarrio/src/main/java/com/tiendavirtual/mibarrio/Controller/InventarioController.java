

package com.tiendavirtual.mibarrio.Controller;

import com.tiendavirtual.mibarrio.Modelo.Inventario;
import com.tiendavirtual.mibarrio.ServiceImpl.ServiceInventarioImpl;
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
@RequestMapping(value = "/inventario")
public class InventarioController {
    
    @Autowired
    private ServiceInventarioImpl serviceInventario;
    
    @GetMapping(value = "")
    public ResponseEntity<List<Inventario>> ListaInventario(){
        List<Inventario> lista = serviceInventario.getListaInventario();
        return ResponseEntity.ok(lista);
    }
    
    @PostMapping(value = "")
    public ResponseEntity<Inventario> CrearInventario(@Valid @RequestBody Inventario 
            inventario,BindingResult result){
        if(result.hasErrors()){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND,result.getFieldError()
                    .getDefaultMessage());
        }
        Inventario crear = serviceInventario.crearInventario(inventario);
        return ResponseEntity.ok(crear);
    }
    
    @PutMapping(value = "")
    public ResponseEntity<Inventario> ActualizarStock(@RequestBody Inventario inventario){
        Inventario actualizar = serviceInventario.ActualizarStockInventario(inventario);
        return ResponseEntity.ok(actualizar);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> EliminarInventario(@PathVariable("id") Long id){
        if(id != null){
            if( serviceInventario.EliminarInventario(id)){
                 return ResponseEntity.ok().body("Eliminado");
            }
        }
      
        return ResponseEntity.notFound().build();
    }
}
