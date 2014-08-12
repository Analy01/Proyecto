package com.anita.web;

import static com.anita.web.DAO.close;
import static com.anita.web.DAO.getSession;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;

/**
 *
 * @author socom_000
 */
public class DAOLibrosImpl extends DAO{
    
    public void agregar_lib(Libros lib) {
    begin();
    getSession().save(lib);
    commit();
    close();
    
    }
 
    public ArrayList<Libros> buscarTodosLibros() {
        begin();
        Query q = getSession().createQuery("from Libros");
      //  Criteria c=getSession().createCriteria(Alumno.class);
        ArrayList<Libros> lib = (ArrayList<Libros>)q.list();
        commit();
        close();
         
return lib; 
        
      
    }
    
 public void borrarLibros(Libros p){
            begin();
             getSession().delete(p);
            commit();
            close();
 }   
       
  public Libros buscarPorId(int id){
      begin();
     Query q = getSession().createQuery("from Libros where id = :id");
        q.setInteger("id",id);
        Libros p = (Libros)q.uniqueResult();
        commit();
        close();
return p;  
   
  } 
    
    
}