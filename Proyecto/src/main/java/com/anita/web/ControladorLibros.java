package com.anita.web;

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
    
    @RequestMapping(value="/libros/{nombre}/{titulo}/{autor}/{editorial}", method=RequestMethod.POST, headers={"Accept=text/html"})
    public @ResponseBody String mensaje(@PathVariable String nombre, @PathVariable String titulo,@PathVariable String autor,@PathVariable String editorial){
           DAOLibrosImpl d= new DAOLibrosImpl();
           d.agregarLibros (new Libros(nombre, titulo, autor, editorial));
           return "Libro guardado con exito";
    }
    
    @RequestMapping(value="/libros", method=RequestMethod.GET, headers={"Accept=application/json"})
    public @ResponseBody String metodo2()throws Exception {
        DAOLibrosImpl d=new DAOLibrosImpl();
        ObjectMapper maper=new ObjectMapper();
            
        return maper.writeValueAsString(d.buscarTodosLibros());
    }
     @RequestMapping(value = "/libros/{id_l}/{nombre}", method = RequestMethod.DELETE, headers = {"Accept=text/html"})
    public @ResponseBody String eliminar(@PathVariable int id, @PathVariable String nombre){
        
        try {
            DAOLibrosImpl.borrarLibros(new Libros(id));
            return "El Libro se ha eliminado";
        } catch (Exception e) {
            return "error";
        }
        
    }
}
