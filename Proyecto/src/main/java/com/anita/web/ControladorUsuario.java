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
public class ControladorUsuario {
    
    @RequestMapping(value="/usuario/{nombre}/{apellido_paterno}/{apellido_materno}/{carrera}/{correo}", method=RequestMethod.POST, headers={"Accept=text/html"})
    public @ResponseBody String mensaje(@PathVariable String nombre,@PathVariable String apellido_paterno, @PathVariable String apellido_materno,
                      @PathVariable String carrera,@PathVariable String correo){
           DAOUsuarioImpl d= new DAOUsuarioImpl();
           d.agregarUsuario (new Usuario(nombre, apellido_paterno, apellido_materno, carrera, correo ));
           return "Libro guardado con exito";
    }
    
    @RequestMapping(value="/usuario", method=RequestMethod.GET, headers={"Accept=application/json"})
    public @ResponseBody String metodo2()throws Exception {
        DAOUsuarioImpl d=new DAOUsuarioImpl();
        ObjectMapper maper=new ObjectMapper();
            
        return maper.writeValueAsString(d.buscarTodosUsuario());
    }
     @RequestMapping(value = "/usuario/{id_u}/{nombre}", method = RequestMethod.DELETE, headers = {"Accept=text/html"})
    public @ResponseBody String eliminar(@PathVariable int id, @PathVariable String nombre){
        
        try {
            DAOUsuarioImpl.borrarUsuario(new Usuario(id));
            return "El Usuario se ha eliminado";
        } catch (Exception e) {
            return "error";
        }
        
    }
}