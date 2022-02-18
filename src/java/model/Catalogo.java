package model;

import java.util.ArrayList;

/**
 *
 * @author Daniel BZ
 */
public class Catalogo {

    private ArrayList<Producto> catalogo;
    
    public Catalogo() {
        this.catalogo = new ArrayList();
        this.catalogo.add(new Producto("Movil",600,1));
        this.catalogo.add(new Producto("Ordenador",1500,1));
        this.catalogo.add(new Producto("Playeras Nike",95,1));
        this.catalogo.add(new Producto("Oso de peluche",10,1));
    }
    
    public ArrayList<Producto> getCatalogo() {
        return this.catalogo;
    }
    
}
