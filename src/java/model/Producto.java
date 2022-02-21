package model;

/**
 *
 * @author Daniel BZ
 */

public class Producto {

    private String autor;
    private String titulo;
    private Long paginas;
    private int cantidad;
    private double precio;
    private String imagen;
    
    public Producto(String autor, String titulo, Long paginas, double precio, int cantidad, String imagen) {
        this.autor = autor;
        this.titulo = titulo;
        this.paginas = paginas;
        this.precio = precio;
        this.cantidad = cantidad;
        this.imagen = imagen;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPaginas(Long paginas) {
        this.paginas = paginas;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public Long getPaginas() {
        return paginas;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getImagen() {
        return imagen;
    }

}
