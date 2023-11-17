//Importar las clases
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Main extends JFrame{
    private String[] preguntas={"¿Cuál es el comando para crear un repositorio Git?",
    "¿Cuál es el comando para añadir archivos a un repositorio Git?",
            "¿Cuál es el comando para realizar un commit de los cambios realizados en un repositorio Git?",
            "¿Cuál es el comando para crear una rama en un repositorio Git?",
            "¿Cuál es el comando para cambiar a una rama en un repositorio Git?",
            "¿Cuál es el comando para fusionar dos ramas en un repositorio Git?",
            "¿Cuál es el comando para enviar los cambios realizados en un repositorio local a un repositorio remoto?",
            "¿Cuál es el comando para recibir los cambios realizados en un repositorio remoto en un repositorio local?",
            "¿Cuál es el comando para ver el historial de commits de un repositorio Git?",
            "¿Cuál es el comando para ver las diferencias entre dos commits de un repositorio Git?"
};

    private String[][] opciones={
            {"git init", "git clone", "git add", "git commit"},
            {"git init", "git clone", "git add", "git commit"},
            {"git init", "git clone", "git add", "git commit"},
            {"git init", "git clone", "git checkout", "git branch"},
            {"git init", "git clone", "git checkout", "git branch"},
            {"git merge", "git checkout", "git push", "git pull"},
            {"git merge", "git checkout", "git push", "git pull"},
            {"git merge", "git checkout", "git push", "git pull"},
            {"git log", "git checkout", "git push", "git pull"},
            {"git log", "git diff", "git push", "git pull"}
    };

    private int[] respuestas={0,2,3,3,2,0,2,3,0,1};

    private int preguntaActual=0;
    private int totalPreguntas=preguntas.length;
    private int puntaje=0;
    private JLabel preguntaLabel;
    private JRadioButton[] opcionesRadio;
    private JButton botonSiguiente;

    public Main(){
        //configurar la ventana
        setTitle("Juego Preguntas GIT");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,200);
        //setBackground(Color.ORANGE);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));

        preguntaLabel=new JLabel(preguntas[preguntaActual]);
        preguntaLabel.setFont(new Font("Calibri",Font.BOLD,18));
        add(preguntaLabel);

        //Agrupamiento de botones para las opciones de la respuesta a la pregunta
        ButtonGroup grupoOpciones=new ButtonGroup();
        opcionesRadio=new JRadioButton[4];
        for (int i=0;i<4;i++){
            opcionesRadio[i]=new JRadioButton(opciones[preguntaActual][i]);
            grupoOpciones.add(opcionesRadio[i]);
            add(opcionesRadio[i]);
        }

        botonSiguiente=new JButton("Siguiente");
        botonSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarRespuesta(); //Crear la funcion para verificar la respuesta correcta
            }
        });
        add(botonSiguiente);
        setVisible(true);

    }

    //Metodos para darle funcionamiento al Juego
    private void verificarRespuesta(){
        for (int i=0;i<4;i++){
            if(opcionesRadio[i].isSelected()&& i==respuestas[preguntaActual]){
                puntaje=puntaje+10;
                break;
            }
        }
        //preguntaActual=preguntaActual+1;
        preguntaActual++;
        if(preguntaActual<totalPreguntas){
            //Actualizacion de Pregunta
            actualizarPregunta();
        }else{
            //Mostrar el Resultado
            mostrarResultado();
        }
    }

    //Metodo para actualizar la pregunta
    private void actualizarPregunta(){
        preguntaLabel.setText(preguntas[preguntaActual]);
        for (int i=0;i<4;i++){
            opcionesRadio[i].setText(opciones[preguntaActual][i]);
            opcionesRadio[i].setSelected(false);
        }
    }

    //Metodo para mostrar el resultado final
    private void mostrarResultado(){
        JOptionPane.showMessageDialog(this,"Game Over.\n El puntaje Final es: "+puntaje,"Resultado Final",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(()->{
            new Main();
        });
    }
}

