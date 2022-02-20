/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CarritoCompra;
import model.Producto;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "AddCarrito", urlPatterns = {"/AddCarrito"})
public class AddCarrito extends HttpServlet {

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
        
        String tituloLibro = request.getParameter("tituloLibro");
        String autorLibro = request.getParameter("autorLibro");
        String imagenLibro = request.getParameter("imagenLibro");
        double precioLibro = Double.parseDouble(request.getParameter("precioLibro"));
        int cantidadLibro = Integer.parseInt(request.getParameter("cantidadLibro"));
        Long paginasLibro = Long.parseLong(request.getParameter("paginasLibro"));
        
        
        Producto nuevoProducto = new Producto(autorLibro, tituloLibro, paginasLibro, precioLibro, cantidadLibro, imagenLibro);
        
        HttpSession session = request.getSession();
        
        CarritoCompra carrito = (CarritoCompra) session.getAttribute("CarritoCompra");
        
        if(carrito == null) {
            
            carrito = new CarritoCompra();
            session.setAttribute("CarritoCompra", carrito);
            
        }
        
        ArrayList<Producto> arrayCarrito = carrito.getCarrito();
        boolean control = true;
        for(Producto a : arrayCarrito) {
            if (a.getTitulo().equals(nuevoProducto.getTitulo())) {
                a.setCantidad(a.getCantidad() + nuevoProducto.getCantidad());
                control = false;
            }
        }
        if(control) {
            carrito.addProducto(nuevoProducto);
        }
        response.sendRedirect(response.encodeRedirectURL(
            "/FirstWebPs/VistaCarrito.jsp"));
        
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
