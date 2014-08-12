package com.anita.web;

import java.util.ArrayList;
import com.anita.web.Prestamos;
import org.hibernate.Criteria;
import org.hibernate.Query;

/**
 *
 * @author A-n-I-t-A
 */


public class DAOPrestamosImpl extends DAO {
    
    public static void agregarPrestamo(Prestamos prestamo){
        begin();
        getSession().save(prestamo);
        commit();
        close();
    }
    public static ArrayList<Prestamos> buscarTodosPrestamos() { 
         begin();  
         Criteria c=getSession().createCriteria(Prestamos.class); 
         ArrayList<Prestamos> pre = (ArrayList<Prestamos>)c.list(); 
         commit(); 
         close();
         return pre;
    }
    public static void eliminarPrestamo(Prestamos prestamo){
        begin();
        getSession().delete(prestamo);
        commit();
        close();
    }
    public  static Prestamos buscarPorId(int idpres){ 
       begin(); 
      Query q = getSession().createQuery("from Prestamos where idpres = :idpres"); 
         q.setInteger("idpres",idpres); 
         Prestamos pr = (Prestamos)q.uniqueResult(); 
         commit(); 
         close(); 
 return pr;   
     
   }
    public static void actualizar(Prestamos p){
        begin();
        getSession().update(p);
        commit();
        close();
    }

    static Object buscarId(int id_p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static Object buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}