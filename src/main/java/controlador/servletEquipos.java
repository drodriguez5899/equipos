/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Equipos;
import modelo.EquiposCRUD;

/**
 *
 * @author David
 */
public class servletEquipos extends HttpServlet {
    private int id;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String op = request.getParameter("op");
        try {
              if ( op.equals("listar")){
                List<Equipos> misEquipos = EquiposCRUD.getEquipos();
                request.setAttribute("misEquipos", misEquipos);
                request.getRequestDispatcher("listar.jsp").forward(request, response);
                         
            }
              if ( op.equals("insert1")) { //cuando le indicamos que vaya a insertar
                 request.getRequestDispatcher("insert.jsp").forward(request, response);
            }
            if ( op.equals("insert2")) { //cuando recibe los datos de la inserción
                Equipos miEquipo = new Equipos();
                miEquipo.setNombre(request.getParameter("nombre"));
                miEquipo.setPais(request.getParameter("pais"));
                miEquipo.setCiudad(request.getParameter("ciudad"));
                miEquipo.setEscudo(request.getParameter("escudo"));
                String presupuesto=request.getParameter("presupuesto");
                miEquipo.setPresupuesto(Float.parseFloat(presupuesto));
                EquiposCRUD.insertaEquipo(miEquipo);
                out.println("<h1>Registro insertado " + "<a href='index.jsp'>Volver</a>" + "</h1>");
            }
             if(op.equals("borrar")){
                int id = Integer.parseInt(request.getParameter("id")) ;
                if( EquiposCRUD.destroyEquipo(id)>0){
                    out.println("<h1>Registro Borrado " + "<a href='index.jsp'>Volver</a>" + "</h1>");
                }
            }
            if(op.equals("update1")){
                int id = Integer.parseInt(request.getParameter("id"));
                Equipos miEquipo = EquiposCRUD.getEquipo(id);
                request.setAttribute("equipo", miEquipo);
                this.id = miEquipo.getId();
                request.getRequestDispatcher("update.jsp").forward(request, response);
            }
            if(op.equals("update2")){
                Equipos miEquipo = new Equipos();
                miEquipo.setId(this.id);
                miEquipo.setNombre(request.getParameter("nombre"));
                miEquipo.setPais(request.getParameter("pais"));
                miEquipo.setCiudad(request.getParameter("ciudad"));
                miEquipo.setEscudo(request.getParameter("escudo"));
                String presupuesto=request.getParameter("presupuesto");
                miEquipo.setPresupuesto(Float.parseFloat(presupuesto));
                EquiposCRUD.actualizaEquipo(miEquipo);
                //Con el metodo merge que utilizamos en insertar tambien actualiza
                //ProductosCRUD.insertaProducto(miProducto);
                String mensaje ="Equipo actualizado";
                request.setAttribute("mensaje", mensaje);
                request.setAttribute("equipo", miEquipo);
                request.getRequestDispatcher("update.jsp").forward(request, response);
                //out.println("<h1>Se ha editado el producto</h1>");
                //out.println("<a href='index.html'>Volver a index</a>");
            }
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
