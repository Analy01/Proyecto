<%-- 
    Document   : BorrarLibros
    Created on : 12/08/2014, 11:05:43 PM
    Author     : A-n-I-t-A
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
        <title>Web Anita</title>
    </head>
    <body>
        <center>
        <h1>*** !!Bienvenido a la Sesión de Libros!! ***</h1>
        
        <p>
            <b>
                ^^ ¿Qué Libro Deseas Borrar? ^^
            </b>
            <p>
                <b>
                    Id Libro:
        <input type="text" id="id_l" />
                </b>
        <p>
          <b>
                    Nombre:
        <input type="text" id="nombre" />
                </b>
        <p> 
                <input type="button" value="Inicio" onClick="location.href = 'index.jsp' ">
                
        <p>
            
        <input type="button" value="Borrar Libro" id="boton-borrar">
        
     

       
        </center>
        <script>
        
       
$("#boton-borrar").click(function(){
    var id_l=$("#id_l").val();
    var nombre=$("#nombre").val();
                $.ajax({
        method:'DELETE',
        url:"http://localhost:8095/Proyecto/servicios/libros/"+id_l+"/"+nombre,
        success:function(valor){
            alert(valor);
        },
        failure:function(e){
            alert(e);
        }
    });
});

   


        </script>
        
        <div></div>
    </body>
</html>