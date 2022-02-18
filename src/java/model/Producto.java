package model;

/**
 *
 * @author Daniel BZ
 */
public class Producto {

    private String nombreProducto;
    private double precio;
    private int cantidad;
    
    public Producto(String nombreProducto, double precio, int cantidad) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public String getNombreProducto() {
        return nombreProducto;
    }

    public double getPrecio() {
        return precio;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public boolean equalsProducto (Producto productoCMP) {

        if(this.nombreProducto.equals(productoCMP.getNombreProducto()) && this.precio == productoCMP.getPrecio()) {
            return true;
        } else {
            return false;
        }
        
    }
 
}
