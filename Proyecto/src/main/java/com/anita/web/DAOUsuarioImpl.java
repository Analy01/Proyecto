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


public class DAOUsuarioImpl extends DAO{
    
    public void agregarUsuario(Usuario usuario) {
    begin();
    getSession().save(usuario);
    commit();
    close();
    
    }
 
    public ArrayList<Usuario> buscarTodosUsuario() {
        begin();
        Query q = getSession().createQuery("from Usuario");
      //  Criteria c=getSession().createCriteria(Alumno.class);
        ArrayList<Usuario> usuario = (ArrayList<Usuario>)q.list();
        commit();
        close();
         
return usuario; 
        
      
    }
 
 public static void borrarUsuario(Usuario usuario){
            begin();
             getSession().delete(usuario);
            commit();
            close();
 }   
        
  public Usuario buscarPorId(int id_u){
      begin();
     Query q = getSession().createQuery("from Usuario where id_u = :id_u");
        q.setInteger("id",id_u);
        Usuario p = (Usuario)q.uniqueResult();
        commit();
        close();
return p;  
   
  } 
    
    
}
