<%-- 
    Document   : IncUsuario
    Created on : 11/08/2014, 10:42:16 PM
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
        <h1>*** !!Bienvenido a la Sesión de Usuario!! ***</h1>

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
                Apellido Paterno:
        <input type="text" id="apellido_paterno" />
            </b>
        <p>
            <p>
            <b>
                Apellido Materno:
        <input type="text" id="apellido_materno" />
            </b>
        <p>
            <p>
            <b>
                Carrera:
        <input type="text" id="carrera" />
            </b>
        <p>
            <p>
            <b>
                Correo:
        <input type="text" id="correo" />
            </b>
        <p>
            <input type="button" value="Inicio" onClick="location.href = 'index.jsp' ">
            
            <input type="button" value="Mostrar Usuario" id="boton-mostrar" >
            
            <input type="button" value="Guardar Usuario" id="boton-guardar">
        
            <input type="button" value="Borrar Usuario" onClick="location.href = 'borrar.jsp' ">
       

       
        </center>
        <select name="nombres" id="todos" hidden>
             
            </select>
       
        <script>
        
       $("#boton-mostrar").click(function(){ 
        $("#todos").show();/* Este hace que se vea la chingadera de menu */   
        $("#todos").empty(); /* con esta funcion empty vaciamos todo, si  no se te juntaran un chingo de registros en el select de html */   
  $.getJSON("http://localhost:8091/Proyecto/servicios/usuario",function(result){
    $.each(result, function(i, campo){
      $("#todos").append("<option>"+campo.nombre + "</option> ");
    });
  });
});

$("#boton-guardar").click(function(){
    var nombre=$("#nombre").val();
    var apellido_paterno=$("#apellido_paterno").val();
    var apellido_materno=$("#apellido_materno").val();
    var carrera=$("#carrera").val();
    var correo=$("#correo").val();
                $.ajax({
        method:'GET',
        url:"http://localhost:8091/Proyecto/servicios/usuario/"+nombre+"/"+apellido_paterno+"/"+apellido_materno+"/"+carrera+"/"+correo,
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

    </body>
</html>

 