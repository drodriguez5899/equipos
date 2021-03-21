<%-- 
    Document   : listar
    Created on : 21 mar. 2021, 11:30:40
    Author     : David
--%>

<%@page import="java.util.List"%>
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
       <h1>Listado de Equipos de futbol</h1>
        <%
            List<Equipos> misEquipos = (List<Equipos>) request.getAttribute("misEquipos");
        %>
        
        <table class="table table-hover">
            <tr>
                <th>id</th>
                <th>Nombre</th>
                <th>Pais</th>
                <th>Ciudad</th>
                <th>Presupuesto</th>
                <th>Escudo</th>
                <td>Borrar</td>
                <td>Actualizar</td>
                
                
            </tr>
            <% 
                for(Equipos equi: misEquipos){
                String cadenaBorrar = "<a onclick='return Confirmation()' href='servletEquipos?op=borrar&id="+equi.getId()+"'> Borrar</i></a>";
                String cadenaActualizar = "<a href='servletEquipos?op=update1&id="+equi.getId()+"'>Editar</a>";
            %>
                
                <tr>
                    <td> <%= equi.getId() %></td>
                    <td> <%= equi.getNombre() %></td>
                    <td> <%= equi.getPais() %></td>
                    <td> <%= equi.getCiudad() %></td>
                    <td> <%= equi.getPresupuesto() %></td>                    
                    <td> <%= equi.getEscudo() %></td>
                    <td><%= cadenaBorrar %></td>
                    <td><%= cadenaActualizar %></td>
                    
                </tr>
                <%}%>
            
        </table>
                  <script type="text/javascript">
                    function Confirmation(){
                        if(confirm('Esta seguro de eliminar el registro')==true){
                            alert('El registro se ha eliminado correctamente');
                            return true;
                        }else{
                            alert('Operacion cancelada');
                            return false;
                        }
                    }
                    
                </script>
                <!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
    </body>
</html>
