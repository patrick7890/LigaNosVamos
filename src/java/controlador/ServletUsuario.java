/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.DAOUsuario;
import dto.TipoUsuario;
import dto.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Patricio
 */
public class ServletUsuario extends HttpServlet {

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
            case "Acceder":
                Login(request, response);
                break;
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
            String correo = request.getParameter("txtCorreo");
            String pass = request.getParameter("txtPass");
            String tipo = request.getParameter("ddlTipo");
            DAOUsuario dao = new DAOUsuario();
            TipoUsuario ti = dao.buscarTipo(tipo);
            Usuario usuario = new Usuario(ti, nombre, correo, pass);
            if (dao.buscarCorreo(correo) == null) {
                if (dao.agregar(usuario)) {
                    String mensaje = "<div class='alert alert-success text-center'>Usuario Agregado</div>'";
                    request.getSession().setAttribute("mensaje", mensaje);
                } else {
                    String mensaje = "<div class='alert alert-danger text-center'>No se Pudo Registar</div>'";
                    request.getSession().setAttribute("mensaje", mensaje);
                }
            } else {
                String mensaje = "<div class='alert alert-danger text-center'>El correo ya esta registrado</div>'";
                request.getSession().setAttribute("mensaje", mensaje);
            }
        } catch (Exception e) {
            String mensaje = "<div class='alert alert-danger text-center'>Ocurrio un error insesperado "+ e.getMessage()+"</div>'";
            request.getSession().setAttribute("mensaje", mensaje);
        } finally {
            response.sendRedirect("Usuario/registro.jsp");
        }

    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int id = Integer.parseInt(request.getParameter("idUsu"));
            DAOUsuario dao = new DAOUsuario();
            if (dao.eliminar(id)) {
                String mensaje = "<div class='alert alert-success text-center'>Usuario Eliminado</div>'";
                request.getSession().setAttribute("mensaje", mensaje);
            } else {
                String mensaje = "<div class='alert alert-danger text-center'>No se Pudo Eliminar al Usuario</div>'";
                request.getSession().setAttribute("mensaje", mensaje);
            }
        } catch (Exception e) {
            String mensaje = "<div class='alert alert-danger text-center'>Error inesperado </div>'";
            request.getSession().setAttribute("mensaje", mensaje);
        } finally {
            listar(request, response);
        }
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            DAOUsuario dao = new DAOUsuario();
            if (dao.listarTodo() != null) {
                request.getSession().setAttribute("listaUsu", dao.listarTodo());
            } else {
                String mensaje = "<div class='alert alert-danger text-center'>No se encontraron Usuarios</div>'";
                request.getSession().setAttribute("mensaje", mensaje);
            }
        } catch (Exception e) {
            String mensaje = "<div class='alert alert-danger text-center'>Error inesperado</div>'";
            request.getSession().setAttribute("mensaje", mensaje);
        } finally {
            response.sendRedirect("Index.jsp");
        }
    }

    private void Login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String correo = request.getParameter("txtCorreo");
            String pass = request.getParameter("txtPass");
            DAOUsuario dao = new DAOUsuario();
            if (dao.login(correo, pass) != null) {
                response.sendRedirect("Index.jsp");
            } else {
                String mensaje = "<div class='alert alert-danger text-center'>Correo o contraseña incorrecto</div>'";
                request.getSession().setAttribute("mensaje", mensaje);
                request.getSession().setAttribute("correo", correo);
                response.sendRedirect("Login.jsp");
            }
        } catch (Exception e) {
            String mensaje = "<div class='alert alert-danger text-center'>Error inesperado </div>'";
            request.getSession().setAttribute("mensaje", mensaje);
            response.sendRedirect("Login.jsp");
        }
    }

    private void actualizar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int id = Integer.parseInt(request.getParameter("idUsu"));
            String nombre = request.getParameter("txtNombre");
            String correo = request.getParameter("txtCorreo");
            String pass = request.getParameter("txtPass");
            String tipo = request.getParameter("ddlTipo");
            DAOUsuario dao = new DAOUsuario();
            TipoUsuario ti = dao.buscarTipo(tipo);
            Usuario usuario = new Usuario(ti, nombre, correo, pass);
            usuario.setIdUsuario(id);
            if (dao.buscar(id)!=null) {
                if (dao.actualizar(usuario)) {
                    String mensaje = "<div class='alert alert-success text-center'>Usuario Actualizado</div>'";
                    request.getSession().setAttribute("mensaje", mensaje);
                } else {
                    String mensaje = "<div class='alert alert-danger text-center'>No se Pudo Actualizar</div>'";
                    request.getSession().setAttribute("mensaje", mensaje);
                }
            } else {
                String mensaje = "<div class='alert alert-danger text-center'>El correo ya esta registrado</div>'";
                request.getSession().setAttribute("mensaje", mensaje);
            }
        } catch (Exception e) {
            String mensaje = "<div class='alert alert-danger text-center'>Ocurrio un error insesperado"+e.getMessage()+"</div>'";
            request.getSession().setAttribute("mensaje", mensaje );
        } finally {
            listar(request, response);
        }
    }

}
