<%-- 
    Document   : IncPrestamos
    Created on : 11/08/2014, 10:41:42 PM
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
        <h1>*** !!Bienvenido a la Sesión de Prestamos!! ***</h1>
        
        p>
            <b>
                Inserta los Campos Requeridos
            </b>
            <p>
                <b>
                    Id_u:
        <input type="text" id="id_u" />
                </b>
        <p>
            <b>
                Id_l:
        <input type="text" id="id_l" />
            </b>
        <p>
            <p>
            <b>
                Nombre Libro:
        <input type="text" id="nombre_libro" />
            </b>
        <p>
            <p>
            <b>
                Dia Prestamo:
        <input type="text" id="dia_prestamo" />
            </b>
        <p>
            <p>
            <b>
                Dia Entrega:
        <input type="text" id="dia_entrega" />
            </b>
        <p>
            <input type="button" value="Inicio" onClick="location.href = 'index.jsp' ">
            
            <input type="button" value="Mostrar Prestamo" id="boton-mostrar" >
            
            <input type="button" value="Guardar Prestamo" id="boton-guardar">
        
            <input type="button" value="Borrar Prestamo" onClick="location.href = 'borrar.jsp' ">
       

       
        </center>
        <select name="nombres" id="todos" hidden>
             
            </select>
       
        <script>
        
       $("#boton-mostrar").click(function(){ 
        $("#todos").show();/* Este hace que se vea la chingadera de menu */   
        $("#todos").empty(); /* con esta funcion empty vaciamos todo, si  no se te juntaran un chingo de registros en el select de html */   
  $.getJSON("http://localhost:8091/Proyecto/servicios/prestamos",function(result){
    $.each(result, function(i, campo){
      $("#todos").append("<option>"+campo.nombre + "</option> ");
    });
  });
});

$("#boton-guardar").click(function(){
    var id_u=$("#id_u").val();
    var id_l=$("#id_l").val();
    var nombre_libro=$("#nombre_libro").val();
    var dia_prestamo=$("#dia_prestamo").val();
    var dia_entrega=$("#dia_ntrega").val();
                $.ajax({
        method:'GET',
        url:"http://localhost:8091/Proyecto/servicios/prestamos/"+id_u+"/"+id_l+"/"+nombre_libro+"/"+dia_prestamo+"/"+dia_entrega,
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
