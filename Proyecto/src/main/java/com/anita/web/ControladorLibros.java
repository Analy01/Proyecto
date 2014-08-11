package com.anita.web;

import java.io.IOException;
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
    
       @RequestMapping (value = "/libro/{nombre}/{titulo}/{autor}/{editorial}", method = RequestMethod.POST, headers = {"Accept=text/html"}) 
     public @ResponseBody String agregar_lib(@PathVariable String nombre,@PathVariable String titulo,@PathVariable String autor,
             @PathVariable String editorial){ 
         DAOLibrosImpl.agregar_lib (new Libro(nombre,titulo,autor,editorial));
         return "Libro correcto para prestamo"; 
     } 
      
     @RequestMapping (value = "/libro/{nombre}/{titulo}/{autor}/{editorial}", method = RequestMethod.PUT, headers = {"Accept=text/html"}) 
     public @ResponseBody String actualizar (@PathVariable String nombre,@PathVariable String titulo,@PathVariable String autor,
             @PathVariable String autor,@PathVariable String editorial){ 
          
         try {
             DAOLibrosImpl.actualizar (new Libro(nombre,titulo,autor,editorial)); 
             return "Registro modificado ";     
         } catch (Exception e) { 
             return "No hay registro"; 
         } 
          
     } 
      
     @RequestMapping (value = "/libro/{id_l}/{nombre}", method = RequestMethod.DELETE, headers = {"Accept=text/html"}) 
     public @ResponseBody String borrarlib (@PathVariable int id_l, @PathVariable String nombre){ 
          
         try {
             DAOLibrosImpl.borrarlib(new Libro(id_l, nombre));
            return "Registro quitado";     
         } catch (Exception e) { 
             return "No hay registro"; 
         } 
          
     } 
      
     @RequestMapping (value = "/libros", method = RequestMethod.GET, headers = {"Accept=Application/json"}) 
     public @ResponseBody String buscarTodLibros() throws IOException{ 
          
         ObjectMapper mapper = new ObjectMapper(); 
         return mapper.writeValueAsString(DAOLibrosImpl.buscarTodLibros()); 
     } 
      
     @RequestMapping (value = "/libro/{id_l}", method = RequestMethod.GET, headers = {"Accept=text/html"}) 
     public @ResponseBody String buscarPorId(@PathVariable int id_l){ 
          
         return DAOLibrosImpl.buscarPorId(id_l).toString(); 
     }     
    
}