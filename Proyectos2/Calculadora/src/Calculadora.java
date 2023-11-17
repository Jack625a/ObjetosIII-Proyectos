//Calculadora
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Calculadora extends JFrame implements ActionListener {

    //Componentes de la calculadora
    private JButton[] botonesNumeros;
    private JTextArea pantalla;
    private JButton[] botonesOperadores;
    private JButton botonIgual;
    private JButton botonLimpiar;
    private double numero1;
    private String operador;

    //Constructor
    public Calculadora(){
        //Configuracion de la ventana
        setTitle("Calculadora");
        setSize(400,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        //Ventana
        pantalla=new JTextArea();
        pantalla.setEditable(false);
        add(pantalla,BorderLayout.NORTH);

        //Botones
        JPanel panelBotones=new JPanel();
        panelBotones.setLayout(new GridLayout(4,4));

        //Botones (0 al 9)
        botonesNumeros=new JButton[10];
        //Recorrido for para los 10  botones
        for (int i=9; i>=0;i--){
            botonesNumeros[i]=new JButton(String.valueOf(i));
            botonesNumeros[i].addActionListener(this);

            panelBotones.add(botonesNumeros[i]);
        };

        //Operadores
        botonesOperadores=new JButton[4];
        String[] operadores={"+","-","*","/"};
        for (int i=0; i<4;i++){
            botonesOperadores[i]=new JButton(operadores[i]);
            botonesOperadores[i].addActionListener(this);

            panelBotones.add(botonesOperadores[i]);
        }

        //Boton Igual
        botonIgual=new JButton("=");
        botonIgual.addActionListener(this);

        panelBotones.add(botonIgual);

        //Boton Limpiar Pantalla
        botonLimpiar=new JButton("C");
        botonLimpiar.addActionListener(this);

        panelBotones.add(botonLimpiar);

        //Agregar el panel de Botones a la ventana
        add(panelBotones,BorderLayout.CENTER);

        //Configuracion de la ventana
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source=(JButton) e.getSource();
        String botonTexto=source.getText();
        if (isNumeric(botonTexto)){
            pantalla.setText(pantalla.getText()+botonTexto);
        } else if (botonTexto.equals("C")) {
            pantalla.setText("");
            numero1=0;
            operador=null;
        } else if (isOperador(botonTexto)) {
            numero1=Double.parseDouble(pantalla.getText());
            operador=botonTexto;
            pantalla.setText("");
        } else if (botonTexto.equals("=")) {
            if (operador!=null){
                double numero2=Double.parseDouble(pantalla.getText());
                double resultado=calcular(numero1,numero2,operador);

                pantalla.setText(String.valueOf(resultado));

                operador=null;
            }
        }
    }

//Metodos para verifivar la cadena de caracteres.
    private boolean isNumeric(String str){
        try {
            Double.parseDouble(str);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    //Metodo para los operadores de la cadena de caracteres
    private boolean isOperador(String op){
        return op.equals("+")||op.equals("-")||op.equals("*")||op.equals("/");
    }


    //Metodo para calcular el resultados de la operaciones
    private double calcular(double num1,double num2, String operador){
        switch (operador){
            case "+":
                return num1+num2;
            case "-":
                return num1-num2;
            case "*":
                return num1*num2;
            case "/":
                if(num2!=0){
                    return num1/num2;
                }else{
                    System.out.println("Error");
                    return 0;
                }
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> new Calculadora());
    }


}