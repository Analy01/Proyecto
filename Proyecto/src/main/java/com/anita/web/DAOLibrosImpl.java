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


public class DAOLibrosImpl extends DAO{
    
    public void agregarLibros(Libros libros) {
    begin();
    getSession().save(libros);
    commit();
    close();
    
    }
 
    public ArrayList<Libros> buscarTodosLibros() {
        begin();
        Query q = getSession().createQuery("from Libros");
      //  Criteria c=getSession().createCriteria(Alumno.class);
        ArrayList<Libros> libros = (ArrayList<Libros>)q.list();
        commit();
        close();
         
return libros; 
        
      
    }
 
 public static void borrarLibros(Libros libros){
            begin();
             getSession().delete(libros);
            commit();
            close();
 }   
        
  public Libros buscarPorId(int id_l){
      begin();
     Query q = getSession().createQuery("from Equipo where id_l = :id_l");
        q.setInteger("id",id_l);
        Libros p = (Libros)q.uniqueResult();
        commit();
        close();
return p;  
   
  } 
    
    
}
