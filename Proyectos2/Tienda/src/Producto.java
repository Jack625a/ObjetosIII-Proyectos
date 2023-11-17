public class Producto {
    private String nombre;
    private String imagen;
    private double precio;

    //Contructor de la clase Producto
    public Producto(String nombre, String imagen, double precio) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.precio = precio;
    }

    //Metodos de la clase
    public String getNombre() {
        return nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public double getPrecio() {
        return precio;
    }
}
