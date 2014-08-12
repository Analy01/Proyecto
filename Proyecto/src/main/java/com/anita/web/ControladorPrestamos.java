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
public class ControladorPrestamos {
    
    @RequestMapping (value = "/Prestamos/{id_u}/{id_l}/{dia_prestamo}/{dia_entrega}/{nombre_libro}", method = RequestMethod.POST, headers = {"Accept=text/html"})
    public @ResponseBody String insertar(@PathVariable int id_u, @PathVariable int id_l, 
            @PathVariable String dia_prestamo, @PathVariable String dia_entrega, @PathVariable String nombre_libro){
        
        try {
            DAOPrestamosImpl.insertar(new Prestamos(id_u, id_l, dia_prestamo, dia_entrega, nombre_libro));
            return "Registrado Insertado Correctamente";
        } catch (Exception e) {
            return "No Existen";
        }
        
    }
    
    @RequestMapping (value = "/Prestamos/{id_u}/{id_l}/{dia_prestamo}/{dia_entrega}/{nombre_libro}", method = RequestMethod.PUT, headers = {"Accept=text/html"})
    public @ResponseBody String actualizar(@PathVariable int id_u, @PathVariable int id_l, 
            @PathVariable String dia_prestamo, @PathVariable String dia_entrega, @PathVariable String nombre_libro){
        
        try {
            DAOPrestamosImpl.actualizar(new Libros(id_u, id_l, dia_prestamo, dia_entrega, nombre_libro));
            return "Registro Actualizado Correctamente";
        } catch (Exception e) {
            return "Error al actualizar";
        }
    }
    
    @RequestMapping (value = "/Prestamos/{id_p}/{nombre}", method = RequestMethod.DELETE, headers = {"Accept=text/html"})
    public @ResponseBody String eliminar(@PathVariable int id_l, @PathVariable String nombre){
        
        try {
            DAOPrestamosImpl.borrar(new Prestamos(id_p,Prestamos));
            return "Registro Eliminado";
        } catch (Exception e) {
            return "Error al borrar";
        }
    }
    
    @RequestMapping (value = "/Prestamos", method = RequestMethod.GET, headers = {"Accept=Application/jason"})
    public @ResponseBody String buscarTodos () throws IOException{
        
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(DAOPrestamosImpl.buscarTodos());
    }
    
    @RequestMapping (value = "/Prestamos/{id_p}", method = RequestMethod.GET, headers = {"Accept=text/html"})
    public @ResponseBody String buscarPorId (@PathVariable int id_p){
        
        return DAOPrestamosImpl.buscarId(id_p).toString();
    }
    
}
