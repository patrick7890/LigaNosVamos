/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.DAOUsuario;
import DAO.DAOEquipo;
import DAO.DAOLiga;
import dto.Equipo;
import dto.Liga;
import dto.TipoLiga;
import dto.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Patricio
 */
public class ServletEquipo extends HttpServlet {

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
        String opcion = request.getParameter("btnAccion");

        switch (opcion) {
            case "Registar":
                agregar(request, response);
                break;
            case "Eliminar":
                eliminar(request, response);
                break;
            case "Listar":
                listar(request, response);
                break;
            case "Actualizar":
                actualizar(request, response);
                break;
            default:
                throw new AssertionError();
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

    private void agregar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {

            String nombre = request.getParameter("txtNombre");
            String nombreUsu = request.getParameter("txtNombreUsu");
            String tipo = request.getParameter("ddlTipo");
            byte estado = 1;
            DAOEquipo dao = new DAOEquipo();
            DAOUsuario daoUsu = new DAOUsuario();
            Usuario usu = daoUsu.buscar(nombreUsu);
            TipoLiga ti = dao.buscarTipo(tipo);
            Equipo e = new Equipo(null, ti, usu, nombre, estado);
            if (dao.agregar(e)) {
                String mensaje = "<div class='alert alert-success text-center'>Equipo Agregado</div>";
                request.getSession().setAttribute("mensaje", mensaje);
            } else {
                String mensaje = "<div class='alert alert-danger text-center'>No se Pudo Registar</div>";
                request.getSession().setAttribute("mensaje", mensaje);
            }

        } catch (Exception e) {
            String mensaje = "<div class='alert alert-danger text-center'>Ocurrio un error insesperado " + e.getMessage() + "</div>";
            request.getSession().setAttribute("mensaje", mensaje);
        } finally {
            response.sendRedirect("Equipos/registro.jsp");
        }

    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int id = Integer.parseInt(request.getParameter("idUsu"));
            DAOEquipo dao = new DAOEquipo();
            if (dao.eliminar(id)) {
                String mensaje = "<div class='alert alert-success text-center'>Equipo Eliminado</div>";
                request.getSession().setAttribute("mensaje", mensaje);
            } else {
                String mensaje = "<div class='alert alert-danger text-center'>No se Pudo Eliminar al Equipo</div>";
                request.getSession().setAttribute("mensaje", mensaje);
            }
        } catch (Exception e) {
            String mensaje = "<div class='alert alert-danger text-center'>Error inesperado </div>";
            request.getSession().setAttribute("mensaje", mensaje);
        } finally {
            listar(request, response);
        }
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            DAOEquipo dao = new DAOEquipo();
            if (dao.listarTodo() != null) {
                request.getSession().setAttribute("listaUsu", dao.listarTodo());
            } else {
                String mensaje = "<div class='alert alert-danger text-center'>No se encontraron Equipos</div>";
                request.getSession().setAttribute("mensaje", mensaje);
            }
        } catch (Exception e) {
            String mensaje = "<div class='alert alert-danger text-center'>Error inesperado</div>";
            request.getSession().setAttribute("mensaje", mensaje);
        } finally {
            response.sendRedirect("Index.jsp");
        }
    }

    private void actualizar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {

            int var = Integer.parseInt(request.getParameter("txt"));
            String var1 = request.getParameter("txt");
            String var2 = request.getParameter("txt");
            String var4 = request.getParameter("txt");
            String tipo = request.getParameter("ddlTipo");
            String estado = request.getParameter("txt");
            DAOEquipo dao = new DAOEquipo();
            DAOLiga daoL = new DAOLiga();
            Liga l = daoL.buscar(var1);
            DAOUsuario daoUsu = new DAOUsuario();
            Usuario usu = daoUsu.buscar(var2);
            TipoLiga ti = dao.buscarTipo(tipo);
            Equipo e = new Equipo(l, ti, usu, var4, Byte.parseByte(estado));
            e.setIdEquipo(var);
            if (dao.buscar(var) != null) {
                if (dao.actualizar(e)) {
                    String mensaje = "<div class='alert alert-success text-center'>Equipo Actualizado</div>";
                    request.getSession().setAttribute("mensaje", mensaje);
                } else {
                    String mensaje = "<div class='alert alert-danger text-center'>No se Pudo Actualizar</div>";
                    request.getSession().setAttribute("mensaje", mensaje);
                }
            } else {
                String mensaje = "<div class='alert alert-danger text-center'>El correo ya esta registrado</div>";
                request.getSession().setAttribute("mensaje", mensaje);
            }
        } catch (Exception e) {
            String mensaje = "<div class='alert alert-danger text-center'>Ocurrio un error insesperado" + e.getMessage() + "</div>";
            request.getSession().setAttribute("mensaje", mensaje);
        } finally {
            listar(request, response);
        }
    }
}
