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
public class ControladorPrestamos {
    
    @RequestMapping(value="/prestamos/{id_u}/{id_l}/{dia_entrega}/{dia_entrega}/{nombre_libro}", method=RequestMethod.POST, headers={"Accept=text/html"})
    public @ResponseBody String mensaje(@PathVariable int id_u,@PathVariable int id_l, @PathVariable String dia_prestamo,
                      @PathVariable String dia_entrega,@PathVariable String nombre_libro){
           DAOPrestamosImpl d= new DAOPrestamosImpl();
           d.agregarPrestamos (new Prestamos(id_u, id_l, dia_entrega, dia_entrega, nombre_libro));
           return "Libro guardado con exito";
    }
    
    @RequestMapping(value="/prestamos", method=RequestMethod.GET, headers={"Accept=application/json"})
    public @ResponseBody String metodo2()throws Exception {
        DAOPrestamosImpl d=new DAOPrestamosImpl();
        ObjectMapper maper=new ObjectMapper();
            
        return maper.writeValueAsString(d.buscarTodosPrestamos());
    }
     @RequestMapping(value = "/prestamos/{id_p}/{nombre}", method = RequestMethod.DELETE, headers = {"Accept=text/html"})
    public @ResponseBody String eliminar(@PathVariable int id, @PathVariable String nombre){
        
        try {
            DAOPrestamosImpl.borrarPrestamos(new Prestamos(id));
            return "El Prestamos se ha eliminado";
        } catch (Exception e) {
            return "error";
        }
        
    }
}
