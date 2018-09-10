/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.DAOEquipo;
import DAO.DAOIntegrantes;
import DAO.DAOUsuario;
import dto.Equipo;
import dto.Integrantes;
import dto.TipoLiga;
import dto.Usuario;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import java.util.*;

import javax.servlet.ServletConfig;
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
public class ServletIntegrantes extends HttpServlet {

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
            String equipo = request.getParameter("ddlEquipo");
            Equipo e = new DAOEquipo().buscar(equipo);
            for (int i = 1; i < 2; i++) {
                String rut = request.getParameter("txtRut"+i);
                String nombre = request.getParameter("txtNombre"+i);
                String nick = request.getParameter("txtNick"+i);
                byte estado = 1;
                

                Integrantes in = new Integrantes(rut, e, nombre, nick, estado);

                DAOIntegrantes daoI = new DAOIntegrantes();

                if (daoI.agregar(in)) {
                    //imagen(request, response, in);

                    String mensaje = "<div class='alert alert-success text-center'>Intengrante Agregado</div>";
                    request.getSession().setAttribute("mensaje", mensaje);

                } else {
                    String mensaje = "<div class='alert alert-danger text-center'>No se Pudo Registar</div>";
                    request.getSession().setAttribute("mensaje", mensaje);
                }

            }

        } catch (Exception e) {
            String mensaje = "<div class='alert alert-danger text-center'>Ocurrio un error insesperado " + e.getMessage() + "</div>";
            request.getSession().setAttribute("mensaje", mensaje);
        } finally {
            response.sendRedirect("Integrantes/registro.jsp");
        }

    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void actualizar(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void imagen(HttpServletRequest request, HttpServletResponse response, Integrantes in) {

        response.setContentType("text/html;charset=UTF-8");

        // maximum size that will be stored in memory
        String archivourl = "C:\\Users\\Lennon\\Documents\\NetBeansProjects\\LigaNosVamos\\web\\Recursos\\img";

        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(maxMemSize);

        // Location to save data that is larger than maxMemSize.
        factory.setRepository(new File("C:\\Users\\Lennon\\Documents\\NetBeansProjects\\LigaNosVamos\\web\\Recursos\\img"));

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        // maximum file size to be uploaded.
        upload.setSizeMax(maxFileSize);

        factory.setSizeThreshold(1024);

        factory.setRepository(new File(archivourl));

        try {

            List<FileItem> partes = upload.parseRequest(request);

            for (FileItem items : partes) {
                File file = new File(archivourl, "img1.jpg");
                items.write(file);
            }

        } catch (Exception e) {

        }
    }

}
