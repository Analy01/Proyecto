<%-- 
    Document   : IncLibros
    Created on : 11/08/2014, 10:42:00 PM
    Author     : A-n-I-t-A
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Web Anita</title>
    </head>
    <body>
    <center>
        <h1>*** !!Bienvenido a la Sesión de Libros!! ***</h1>
        
        p>
            <b>
                Inserta los Campos Requeridos
            </b>
            <p>
                <b>
                    Nombre:
        <input type="text" id="nombre" />
                </b>
        <p>
            <b>
                Titulo:
        <input type="text" id="titulo" />
            </b>
        <p>
            <p>
            <b>
                Autor:
        <input type="text" id="autor" />
            </b>
        <p>
            <p>
            <b>
                Editorial:
        <input type="text" id="editorial" />
            </b>
        <p>
            <input type="button" value="Inicio" onClick="location.href = 'index.jsp' ">
            
            <input type="button" value="Mostrar Libro" id="boton-mostrar" >
            
            <input type="button" value="Guardar Libro" id="boton-guardar">
        
            <input type="button" value="Borrar Libro" onClick="location.href = 'borrar.jsp' ">
       

       
        </center>
        <select name="nombres" id="todos" hidden>
             
            </select>
       
        <script>
        
       $("#boton-mostrar").click(function(){ 
        $("#todos").show();/* Este hace que se vea la chingadera de menu */   
        $("#todos").empty(); /* con esta funcion empty vaciamos todo, si  no se te juntaran un chingo de registros en el select de html */   
  $.getJSON("http://localhost:8091/Proyecto/servicios/libros",function(result){
    $.each(result, function(i, campo){
      $("#todos").append("<option>"+campo.nombre + "</option> ");
    });
  });
});

$("#boton-guardar").click(function(){
    var nombre=$("#nombre").val();
    var titulo=$("#titulo").val();
    var autor=$("#autor").val();
    var editorial=$("#editorial").val();
                $.ajax({
        method:'GET',
        url:"http://localhost:8091/Proyecto/servicios/libros/"+nombre+"/"+titulo+"/"+autor+"/"+editorial,
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
