//SISTEMA PARA UNA TIENDA
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


//Interfaz Grafica
public class Main extends JFrame {
    private List<Producto> productos;
    public Main() throws MalformedURLException {
        //Crear los productos
        productos=new ArrayList<>();
        productos.add(new Producto("Producto 1","src/tv5.png",3550.50));
        productos.add(new Producto("Producto 2","src/tv1.png",4520));
        productos.add(new Producto("Producto 3","src/tv2.jpg",2900));
        productos.add(new Producto("Producto 4","src/tv3.jpg",4500));
        productos.add(new Producto("Producto 5","src/tv4.jpg",5500));
        productos.add(new Producto("Producto 6","src/tv1.png",4520));
        productos.add(new Producto("Producto 7","src/tv2.jpg",2900));
        productos.add(new Producto("Producto 8","src/tv3.jpg",4500));
        productos.add(new Producto("Producto 9","src/tv4.jpg",5500));

        //Configuracion de la ventana
        setTitle("Tienda Catec");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,productos.size()));

        int anchoImagen=200;
        int altoImagen=200;
        //Mostrar los productos
        //JLabel titulo=new JLabel("Productos Disponibles");
        //titulo.setFont(new Font("Calibri", Font.BOLD,20));
        //add(titulo,BorderLayout.CENTER);

        for (Producto producto: productos){
            JPanel panelProduto=new JPanel();
            panelProduto.setBorder(new EmptyBorder(20,20,20,20));
            panelProduto.setLayout(new BorderLayout());
            panelProduto.setBackground(Color.WHITE);

            JLabel nombreProducto=new JLabel(producto.getNombre());
            nombreProducto.setFont(new Font("Arial",Font.BOLD,18));
            panelProduto.add(nombreProducto,BorderLayout.NORTH);

            //Insertar Imagen
            //URL url=new URL(producto.getImagen());
            ImageIcon imagen=new ImageIcon(producto.getImagen());
            JLabel labelImagen=new JLabel(imagen);
           // imagen.
            panelProduto.add(labelImagen,BorderLayout.CENTER);

            JLabel precioProducto=new JLabel("Precio: "+producto.getPrecio()+"Bs");
            precioProducto.setFont(new Font("Arial",Font.PLAIN,16));
            panelProduto.add(precioProducto,BorderLayout.SOUTH);


            add(panelProduto);
        }
        //Configuracion de la Ventana
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> {
            try {
                new Main();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        });
    }
}