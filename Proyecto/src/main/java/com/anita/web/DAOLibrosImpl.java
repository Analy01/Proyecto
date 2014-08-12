package com.anita.web;

import static com.anita.web.DAO.close;
import static com.anita.web.DAO.getSession;
import java.util.ArrayList;
import org.hibernate.Query;

/**
 *
 * @author A-n-I-t-A
 */


public class DAOLibrosImpl extends DAO{
    
    public static void agregarLibro(Libros libro){
        begin();
        getSession().save(libro);
        commit();
        close();
    }
    public static ArrayList<Libros> buscarTodosLibros(){
        begin();
        Query q =getSession().createQuery("from Libro");
        ArrayList<Libros> libro=(ArrayList<Libros>) q.list();
        commit();
        close();
        return libro;
    }
    public static void borrarLibro(Libros libro){
        begin();
        getSession().delete(libro);
        commit();
        close();
    }
    public static Libros buscarPorId(int id){
        begin();
        Query q =getSession().createQuery("from Libro where id=:id");
        q.setInteger("id", id);
        Libros a=(Libros)q.uniqueResult();
        commit();
        close();
        return a;
    }
    public static void actualizar(Libros l){
        begin();
        getSession().update(l);
        commit();
        close();
    }

    static Object buscarId(int id_l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static Object buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}