//Interfaz grafica
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class Main extends JFrame{
    private Cuenta cuenta;
    private JTextField usuarioEntrada;
    private JPasswordField contrasenaEntrada;
    private JLabel saldoLabel;
    private JTextField montoEntrada;
    private JPanel panelOperaciones;
    private JPanel panelCredenciales;

    //Contructor
    public Main(){
        cuenta=new Cuenta("Kevin","123",1500);
        setTitle("Cajero Automatico CATEC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200,200);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));



        //CONTENEDOR PARA LAS CREDENCIALES
        //USUARIO - CONTRASEÑA
        panelCredenciales=new JPanel();
        panelCredenciales.add(new JLabel("Usuario: "));
        usuarioEntrada=new JTextField(15);
        panelCredenciales.add(usuarioEntrada);
        panelCredenciales.add(new JLabel("Contraseña: "));
        contrasenaEntrada=new JPasswordField(15);
        panelCredenciales.add(contrasenaEntrada);
        JButton botonIngresar=new JButton("Ingresar");
        botonIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ingresar();
            }
        });
        panelCredenciales.add(botonIngresar);
        add(panelCredenciales);

        //Mostrar las operaciones que se pueden realizar
        saldoLabel=new JLabel("Saldo disponible 0 Bs");
        saldoLabel.setVisible(false);
        saldoLabel.setFont(new Font("Arial",Font.BOLD,20));
        add(saldoLabel);

        //CONTENEDOR DE LAS OPERACIONES
        panelOperaciones=new JPanel();
        panelOperaciones.setVisible(false);
        panelOperaciones.add(new JLabel("Monto: "));
        montoEntrada=new JTextField(8);

        panelOperaciones.add(montoEntrada);
        JButton depositarBoton=new JButton("Depositar");
        depositarBoton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                depositar();
            }
        });

        panelOperaciones.add(depositarBoton);
        JButton retirarBoton=new JButton("Retirar");
        retirarBoton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                retirar();
            }
        });
        panelOperaciones.add(retirarBoton);
        add(panelOperaciones);
    }
    //METODOS PARA INGRESAR , RETIRAR, DEPOSITAR
    private void ingresar(){
        String usuario=usuarioEntrada.getText();
        String contrasena= new String(contrasenaEntrada.getPassword());

        if (cuenta.verificar(usuario,contrasena)){
            saldoLabel.setText("Saldo Disponible: "+cuenta.verSaldo()+"Bs");
            saldoLabel.setVisible(true);
            panelOperaciones.setVisible(true);
            panelCredenciales.setVisible(false);
            setSize(600,100);
        }else{
            JOptionPane.showMessageDialog(this,"Usuario y/o Contraseña incorrectos","Error",JOptionPane.ERROR_MESSAGE);

        }
    }
    //Metodo de Depositar
    public void depositar(){
        try {
            double monto=Double.parseDouble(montoEntrada.getText());
            cuenta.depositar(monto);
            saldoLabel.setText("Saldo disponible: "+cuenta.verSaldo()+"Bs");
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this,"Error ingrese un monto valido","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    //Metodo Retirar
    public void retirar(){
        try{
            double monto=Double.parseDouble(montoEntrada.getText());
            if (cuenta.retirar(monto)){
                saldoLabel.setText("Saldo disponible: "+cuenta.verSaldo()+"Bs");
            }else{
                JOptionPane.showMessageDialog(this,"Saldo Insuficiente","Error",JOptionPane.ERROR_MESSAGE);
            }
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this,"Error ingrese un monto valido","Error",JOptionPane.ERROR_MESSAGE);
        }
    }


    public static void main(String[] args) {
    SwingUtilities.invokeLater(()->{
        new Main().setVisible(true);
    });

    }
}