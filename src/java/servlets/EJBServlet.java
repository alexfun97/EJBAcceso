/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.CantanteEJB;
import beans.GeneroEJB;
import entity.Cantante;
import entity.Genero;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author skaynx
 */
@WebServlet(name = "EJBServlet", urlPatterns = {"/EJBServlet"})
public class EJBServlet extends HttpServlet {
    @EJB
    CantanteEJB cEJB;
    @EJB
    GeneroEJB gEJB;
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
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Prueba Servlet con EJB </title>");
            out.println("</head>");
            out.println("<body>");
            List<Cantante> lC = cEJB.findAll();
            List<Genero> lG = gEJB.findAll();
            if(request.getParameter("crud").equals("Crear")){
                out.println("<b>Crear</b><br>");
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Genero genAct = null;
                for(int i = 0; i < 4; i++ ){
                    if(lG.get(i).getId() == Integer.parseInt(request.getParameter("genero"))){
                        genAct = lG.get(i);
                    }
                }
                Cantante cantante = new Cantante(request.getParameter("nombre"), format.parse(request.getParameter("fechaNac")), request.getParameter("nacionalidad"), genAct);
                lC.add(cantante);
            } else if(request.getParameter("crud").equals("Leer")){
                out.println("<b>Leer</b><br>");
                out.println(request.getParameter("nombre"));
                //Cantante cantante = new Cantante(request.getParameter("nombre"), request.getParameter("fechaNac"), request.getParameter("nacionalidad"), request.getParameter("genero"));
                //l.add(cantante);
            } else if(request.getParameter("crud").equals("Actualizar")){
                out.println("<b>Actualizar</b><br>");
                //Cantante cantante = new Cantante(request.getParameter("nombre"), request.getParameter("fechaNac"), request.getParameter("nacionalidad"), request.getParameter("genero"));
                //l.add(cantante);
            } else if(request.getParameter("crud").equals("Borrar")){
                out.println("<b>Borrar</b><br>");
                out.println(request.getParameter("nombre"));
                //Cantante cantante = new Cantante(request.getParameter("nombre"), request.getParameter("fechaNac"), request.getParameter("nacionalidad"), request.getParameter("genero"));
                //l.add(cantante);
            }
            /* bucle para recorrer la lista que corresponda */
            for(int i = 0; i < 10; i++ ){
                out.println("<b>Nombre: </b>" + lC.get(i).getNombre() + 
                    ", <b>Fecha de nacimiento: </b>" + lC.get(i).getFechaNac() + 
                    ", <b>Nacionalidad: </b>" + lC.get(i).getNacionalidad() + 
                    ", <b>Genero: </b>" + lC.get(i).getGenero().getNombre() + 
                    "<br>" );
            }
            out.println("</body>");
            out.println("</html>");
        } catch (ParseException ex) {
            Logger.getLogger(EJBServlet.class.getName()).log(Level.SEVERE, null, ex);
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
