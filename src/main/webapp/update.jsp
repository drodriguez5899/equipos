<%-- 
    Document   : update
    Created on : 21 mar. 2021, 16:14:30
    Author     : David
--%>

<%@page import="modelo.Equipos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-md bg-dark navbar-dark">
            <!-- Brand -->
            <a class="navbar-brand" href="index.jsp">FUBOL</a>

            <!-- Toggler/collapsibe Button -->
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
              <span class="navbar-toggler-icon"></span>
            </button>

            <!-- Navbar links -->
            <div class="collapse navbar-collapse" id="collapsibleNavbar">
              <ul class="navbar-nav">
                <li class="nav-item">
                  <a class="nav-link" href="servletEquipos?op=listar">listar Equipos</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="cliente.html">Rest Cliente</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="servletEquipos?op=insert1">Insertar nuevo equipo</a>
                </li>
              
              </ul>
            </div>
        </nav>
         <%
            Equipos miEquipo = (Equipos)request.getAttribute("equipo");
            String mensaje = (String) request.getAttribute("mensaje");
             String cadena ="";
            if(mensaje!=null){
                cadena="<h2 id='mensaje' class='alert alert-success'>Producto actualizado</h2>";
            }
        %>
        <%= cadena%>
        <h1>Editar Equipo de futbol</h1>
         <form action="servletEquipos" method="get" onchange="borrarMensaje()">
            <div class="form-group">
                <p><label>Nombre: <input class="form-control" oninput="borraMensaje()"  value="<%= miEquipo.getNombre()%>" type="text" name="nombre" required > </label></p>                
            </div>
            <div class="form-group">
                <p><label>Pais: <input class="form-control" oninput="borraMensaje()" value="<%= miEquipo.getPais()%>" type="text" name="pais" required > </label></p>              
            </div>
            <div class="form-group">
                 <p><label>Ciudad: <input class="form-control" oninput="borraMensaje()"  value="<%= miEquipo.getCiudad()%>" type="text" name="ciudad" required > </label></p>               
            </div>
            <div class="form-group">
                <p><label>Presupuesto: <input class="form-control" oninput="borraMensaje()"  value="<%= miEquipo.getPresupuesto()%>" type="text" name="presupuesto" required > </label></p>              
            </div>
            <div class="form-group">
               <p><label>Escudo: <input class="form-control" oninput="borraMensaje()"  value="<%= miEquipo.getEscudo()%>" type="text" name="escudo" required > </label></p>               
            </div>
           
          
           
           
            
       
            <input readonly type="hidden" name="op" required value="update2">
            <input  class="btn btn-primary" type="submit" value="actualizar" >       
        </form>
        </div>
            <script type="text/javascript">
                function borraMensaje(){
                    document.getElementById("mensaje").style.visiblity="hidden";
                }
                
                window.onbeforeunload = confirmExit;
            	function confirmExit()
            	{
              	return "Seguro que quiere salir?";
            	}

            </script>
            <!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
    </body>
</html>
