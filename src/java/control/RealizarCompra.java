package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
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

@WebServlet(name = "RealizarCompra", urlPatterns = {"/RealizarCompra"})
public class RealizarCompra extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        HttpSession session = request.getSession();
        
        CarritoCompra carrito = (CarritoCompra) session.getAttribute("CarritoCompra");
        
        if(carrito == null) {
            carrito = new CarritoCompra();
            session.setAttribute("CarritoCompra", carrito);
        }
        
        ArrayList<Producto> carritoLibros = carrito.getCarrito();
        
        if(carritoLibros.isEmpty()) {
            RequestDispatcher dispatch = request.getRequestDispatcher("Error.jsp");
        
            if(dispatch != null) {
                dispatch.forward(request, response);
            }
        }
        
        double precioTotal = 0.0;
        
        for(Producto libro : carritoLibros) {
            precioTotal += libro.getPrecio();
        }
        
        DecimalFormatSymbols mySeparador = new DecimalFormatSymbols();
        mySeparador.setDecimalSeparator('.');
        DecimalFormat myFormat = new DecimalFormat("#.00", mySeparador);
        
        precioTotal = Double.parseDouble(myFormat.format(precioTotal));
        
        carritoLibros.clear();
        
        request.setAttribute("precioTotal", precioTotal);
        
        RequestDispatcher dispatch = request.getRequestDispatcher("VistaCompra.jsp");
        
        if(dispatch != null) {
            dispatch.forward(request, response);
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
