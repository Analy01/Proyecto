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
public class ControladorUsuario {
    
    @RequestMapping (value = "/Usuario/{nombre}/{apellido_paterno}/{apellido_materno}/{carrera}/{correo}", method = RequestMethod.POST, headers = {"Accept=text/html"})
    public @ResponseBody String insertar(@PathVariable String nombre, @PathVariable String apellido_paterno, 
            @PathVariable String apellido_materno, @PathVariable String carrera, @PathVariable String correo){
        
        try {
            DAOUsuarioImpl.insertar(new Usuario(nombre, apellido_paterno, apellido_materno, carrera, correo));
            return "Registrado Insertado Correctamente";
        } catch (Exception e) {
            return "No Existen";
        }
        
    }
    
    @RequestMapping (value = "/Usuario/{nombre}/{apellido_paterno}/{apellido_materno}/{carrera}/{correo}", method = RequestMethod.PUT, headers = {"Accept=text/html"})
    public @ResponseBody String actualizar(@PathVariable String nombre, @PathVariable String apellido_paterno, 
            @PathVariable String apellido_materno, @PathVariable String carrera, @PathVariable String correo){
        
        try {
            DAOUsuarioImpl.actualizar(new Usuario(nombre, apellido_paterno, apellido_materno, carrera, correo));
            return "Registro Actualizado Correctamente";
        } catch (Exception e) {
            return "Error al actualizar";
        }
    }
    
    @RequestMapping (value = "/Usuario/{id_u}/{nombre}", method = RequestMethod.DELETE, headers = {"Accept=text/html"})
    public @ResponseBody String eliminar(@PathVariable int id_u, @PathVariable String nombre){
        
        try {
            DAOUsuarioImpl.borrar(new Usuario(id_u,Usuario));
            return "Registro Eliminado";
        } catch (Exception e) {
            return "Error al borrar";
        }
    }
    
    @RequestMapping (value = "/Usuario", method = RequestMethod.GET, headers = {"Accept=Application/jason"})
    public @ResponseBody String buscarTodos () throws IOException{
        
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(DAOUsuarioImpl.buscarTodos());
    }
    
    @RequestMapping (value = "/Usuario/{id_u}", method = RequestMethod.GET, headers = {"Accept=text/html"})
    public @ResponseBody String buscarPorId (@PathVariable int id_u){
        
        return DAOUsuarioImpl.buscarId(id_u).toString();
    }
    
}

