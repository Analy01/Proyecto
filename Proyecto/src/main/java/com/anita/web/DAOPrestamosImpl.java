package com.anita.web;

import static com.anita.web.DAO.close;
import static com.anita.web.DAO.getSession;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;

/**
 *
 * @author A-n-I-t-A
 */


public class DAOPrestamosImpl extends DAO{
    
    public void agregarPrestamos(Prestamos prestamos) {
    begin();
    getSession().save(prestamos);
    commit();
    close();
    
    }
 
    public ArrayList<Prestamos> buscarTodosPrestamos() {
        begin();
        Query q = getSession().createQuery("from Prestamos");
      //  Criteria c=getSession().createCriteria(Alumno.class);
        ArrayList<Prestamos> prestamos = (ArrayList<Prestamos>)q.list();
        commit();
        close();
         
return prestamos; 
        
      
    }
 
 public static void borrarPrestamos(Prestamos prestamos){
            begin();
             getSession().delete(prestamos);
            commit();
            close();
 }   
        
  public Prestamos buscarPorId(int id_p){
      begin();
     Query q = getSession().createQuery("from Prestamos where id_p = :id_p");
        q.setInteger("id",id_p);
        Prestamos p = (Prestamos)q.uniqueResult();
        commit();
        close();
return p;  
   
  } 
    
    
}
