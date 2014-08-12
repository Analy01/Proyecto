package com.anita.web;

import java.util.ArrayList;
import org.hibernate.Query;

/**
 *
 * @author A-n-I-t-A
 */



public class DAOUsuarioImpl extends DAO {

    public static void agregarUsuario(Usuario usuario){
        begin();
        getSession().save(usuario);
        commit();
        close();
    }
    
    public static ArrayList<Usuario> buscarTodosUsuario(){
        begin();
        Query q =getSession().createQuery("from Usuario");
        ArrayList<Usuario> usuario=(ArrayList<Usuario>) q.list();
        commit();
        close();
        return usuario;
    }
    public static void borraUsuario(Usuario usuario){
        begin();
        getSession().delete(usuario);
        commit();
        close();
    }
    public static Usuario buscarPorId(int id){
        begin();
        Query q =getSession().createQuery("from Usuario where id=:id");
        q.setInteger("id", id);
        Usuario a=(Usuario)q.uniqueResult();
        commit();
        close();
        return a;
    }
    public static void actualizar(Usuario u){
        begin();
        getSession().update(u);
        commit();
        close();
    }

    static Object buscarId(int id_u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}