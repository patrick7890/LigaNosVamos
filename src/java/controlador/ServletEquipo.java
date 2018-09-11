/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.DAOUsuario;
import DAO.DAOEquipo;
import DAO.DAOImagen;
import DAO.DAOLiga;

import dto.Equipo;
import dto.Imagen;
import dto.Liga;
import dto.TipoLiga;
import dto.Usuario;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Patricio
 */
public class ServletEquipo extends HttpServlet {

    private boolean isMultipart;
    private int maxFileSize = 50 * 1024;
    private int maxMemSize = 4 * 1024;
    InputStream is = null;

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
            case "Inscribir":
                inscribir(request, response);
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
            Usuario usu = daoUsu.buscarCorreo(nombreUsu);
            TipoLiga ti = dao.buscarTipo(tipo);
            Equipo e = new Equipo(nombre, null, ti, usu, estado);
            if (dao.agregar(e)) {
                imagen(request, response, e);

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
            response.sendRedirect("Equipos/administrar.jsp");
        }
    }

    private void actualizar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String nombreEquipo = request.getParameter("txtNombreEquipo");
            String tipo = request.getParameter("tipo");
            String nombreUsu = request.getParameter("usu");
            String liga = request.getParameter("liga");
            DAOEquipo dao = new DAOEquipo();
            Liga l = new DAOLiga().buscar(liga);
            DAOUsuario daoUsu = new DAOUsuario();
            Usuario usu = daoUsu.buscarCorreo(nombreUsu);
            TipoLiga ti = dao.buscarTipo(tipo);
            byte estado = Byte.parseByte(request.getParameter("ddlEstado"));
            Equipo e = new Equipo(nombreEquipo, l, ti, usu, estado);
            if (dao.buscar(nombreEquipo) != null) {
                if (dao.actualizar(e)) {
                    e.setEstadoEquipo(estado);
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

    private void imagen(HttpServletRequest request, HttpServletResponse response, Equipo e) throws ServletException, IOException {

        try {

            isMultipart = ServletFileUpload.isMultipartContent(request);
            response.setContentType("text/html;charset=UTF-8");
            java.io.PrintWriter out = response.getWriter();
            if (!isMultipart) {
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet upload</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<p>No file uploaded</p>");
                out.println("</body>");
                out.println("</html>");
            }
            String User = System.getProperty("user.name");
            // maximum size that will be stored in memory
            String archivourl = "C:\\Users\\" + User + "\\Documents\\NetBeansProjects\\LigaNosVamos\\web\\Recursos\\img";

            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(maxMemSize);

            // Location to save data that is larger than maxMemSize.
            factory.setRepository(new File("C:\\Users\\" + User + "\\Documents\\NetBeansProjects\\LigaNosVamos\\web\\Recursos\\img"));

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);

            // maximum file size to be uploaded.
            upload.setSizeMax(maxFileSize);

            factory.setSizeThreshold(1024);

            factory.setRepository(new File(archivourl));
            Imagen i = new Imagen("Equipo-" + e.getNombreEquipo(), e, null, null);
            DAOImagen daoimagen = new DAOImagen();
            daoimagen.agregarI(i);

            List<FileItem> partes = upload.parseRequest(request);

            for (FileItem items : partes) {

                File file = new File(archivourl, "Equipo-" + e.getNombreEquipo());
                items.write(file);
            }

        } catch (Exception ex) {
            String mensaje = "<div class='alert alert-danger text-center'>Ocurrio un error insesperado" + ex.getMessage() + "</div>";
            request.getSession().setAttribute("mensaje", mensaje);
        }
    }

    private void inscribir(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String nombre = request.getParameter("ddlEquipo");
            String nombreLiga = request.getParameter("txtNombreLiga");
            String tipo = request.getParameter("txtTipoLiga");
            String correo = request.getParameter("correo");
            Usuario u = new DAOUsuario().buscarCorreo(correo);
            DAOEquipo dao = new DAOEquipo();
            DAOLiga daoL = new DAOLiga();
            TipoLiga ti = dao.buscarTipo(tipo);

            Liga l = daoL.buscar(nombreLiga);
            Equipo e = dao.buscar(nombre);
            byte estado = 1;
            if (e != null && l != null) {
                Equipo eq = new Equipo(nombre, l, ti, u, estado);
                if (dao.actualizar(eq)) {
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
            response.sendRedirect("Ligas/inscribir.jsp");
        }
    }

}
