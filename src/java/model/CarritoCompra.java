package model;

import java.util.ArrayList;

/**
 *
 * @author Daniel BZ
 */
public class CarritoCompra {

    private ArrayList<Producto> carrito;

    public CarritoCompra() {
        this.carrito = new ArrayList();
    }
    
    public ArrayList<Producto> getCarrito() {
        return this.carrito;
    }
    
    public void addProducto(Producto producto) {
        this.carrito.add(producto);
    }
    
    public void removeProducto (int indice) {
        this.carrito.remove(indice);
    }
}
