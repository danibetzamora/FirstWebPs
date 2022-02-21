package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
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
 * @author Daniel BZ
 */

@WebServlet(name = "AddCarrito", urlPatterns = {"/AddCarrito"})
public class AddCarrito extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String tituloLibro = request.getParameter("tituloLibro");
        String autorLibro = request.getParameter("autorLibro");
        String imagenLibro = request.getParameter("imagenLibro");
        Long paginasLibro = Long.parseLong(request.getParameter("paginasLibro"));
        int cantidadLibro = Integer.parseInt(request.getParameter("cantidadLibro"));
        double precioLibro = Double.parseDouble(request.getParameter("precioLibro"));

        Producto nuevoLibro = new Producto(autorLibro, tituloLibro, paginasLibro, precioLibro, cantidadLibro, imagenLibro);
        
        HttpSession session = request.getSession();
        
        CarritoCompra carrito = (CarritoCompra) session.getAttribute("CarritoCompra");
        
        if(carrito == null) {
            carrito = new CarritoCompra();
            session.setAttribute("CarritoCompra", carrito);
        }
        
        ArrayList<Producto> carritoLibros = carrito.getCarrito();
        
        boolean control = true;
        
        DecimalFormatSymbols mySeparador = new DecimalFormatSymbols();
        mySeparador.setDecimalSeparator('.');
        DecimalFormat myFormat = new DecimalFormat("#.00", mySeparador);
        
        for(Producto libro : carritoLibros) {
            if (libro.getTitulo().equals(nuevoLibro.getTitulo())) {
                libro.setCantidad(libro.getCantidad() + nuevoLibro.getCantidad());
                libro.setPrecio(Double.parseDouble(myFormat.format(libro.getCantidad() * nuevoLibro.getPrecio())));
                control = false;
                
            }
        }
        if(control) {
            nuevoLibro.setPrecio(Double.parseDouble(myFormat.format(nuevoLibro.getCantidad() * nuevoLibro.getPrecio())));
            carrito.addProducto(nuevoLibro);
        }
        
        response.sendRedirect(response.encodeRedirectURL("/FirstWebPs/VistaCarrito.jsp"));
        
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
