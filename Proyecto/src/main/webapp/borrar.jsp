<%-- 
    Document   : borrar
    Created on : 11/08/2014, 11:04:31 PM
    Author     : A-n-I-t-A
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
        <title>Web Anita</title>
    </head>
    <body>
        <h1>*** Borrado Exitosamente ***</h1>
        
        <p>
            <b>
                Que Deseas Eliminar?
            </b>
            <p>
                <b>
                    Id:
        <input type="text" id_l="id_l" />
                </b>
        <p>
          <b>
                    Nombre:
        <input type="text" id="nombre" />
                </b>
        <p> 
            
            <input type="button" value="Inicio" onClick="location.href = 'index.jsp' ">
            
            <input type="button" value="Borrar" id="boton-borrar">
        
       

       
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

    </body>
</html>
