package com.anita.web;

import java.io.IOException;
import com.anita.web.Libros;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author A-n-I-t-A
 */

@Controller
@RequestMapping("/")
public class ControladorLibros {
    
    @RequestMapping (value = "/Libros/{nombre}/{titulo}/{autor}/{editorial}", method = RequestMethod.POST, headers = {"Accept=text/html"})
    public @ResponseBody String insertar(@PathVariable String nombre, @PathVariable String titulo, 
            @PathVariable String autor, @PathVariable String editorial){
        
        try {
            DAOLibrosImpl.insertar(new Libros(nombre, titulo, autor, editorial));
            return "Registrado Insertado Correctamente";
        } catch (Exception e) {
            return "No Existen";
        }
        
    }
    
    @RequestMapping (value = "/Libros/{nombre}/{titulo}/{autor}/{editorial}", method = RequestMethod.PUT, headers = {"Accept=text/html"})
    public @ResponseBody String actualizar(@PathVariable int id_l,@PathVariable String nombre, @PathVariable String titulo, 
            @PathVariable String autor, @PathVariable String editorial){
        
        try {
            DAOLibrosImpl.actualizar(new Libros(id_l, nombre, titulo, autor, editorial));
            return "Registro Actualizado Correctamente";
        } catch (Exception e) {
            return "Error al actualizar";
        }
    }
    
    @RequestMapping (value = "/Libros/{id_l}/{nombre}", method = RequestMethod.DELETE, headers = {"Accept=text/html"})
    public @ResponseBody String eliminar(@PathVariable int id_l, @PathVariable String nombre){
        
        try {
            DAOLibrosImpl.borrar(new Libros(id_l,Libros));
            return "Registro Eliminado";
        } catch (Exception e) {
            return "Error al borrar";
        }
    }
    
    @RequestMapping (value = "/libros", method = RequestMethod.GET, headers = {"Accept=Application/jason"})
    public @ResponseBody String buscarTodos () throws IOException{
        
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(DAOLibrosImpl.buscarTodos());
    }
    
    @RequestMapping (value = "/libros/{id_l}", method = RequestMethod.GET, headers = {"Accept=text/html"})
    public @ResponseBody String buscarPorId (@PathVariable int id_l){
        
        return DAOLibrosImpl.buscarId(id_l).toString();
    }
    
}