import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class VentanasEmergentes {
    public static void main(String[] args) {
        Ventana5 miVentana = new Ventana5();
        miVentana.setTitle("Ventana Emergentes");
    }
    
}

class Ventana5 extends JFrame {

    private static JPopupMenu menuEmergente;
    private static JMenuItem menuRojo;
    private static JMenuItem menuAzul;
    private static JMenuItem menuVerde;
    private static Panel5 miPanel;
    Ventana5(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setResizable(false);
        setLocationRelativeTo(null);

        miPanel = new Panel5();
        add(miPanel);
        setVisible(true);
    }

    class Panel5 extends JPanel  {

        Panel5(){
            menuEmergente = new JPopupMenu();
            menuRojo = new JMenuItem("Rojo");
            menuAzul = new JMenuItem("Azul");
            menuVerde = new JMenuItem("Verde");
            menuEmergente.add(menuRojo);
            menuEmergente.add(menuAzul);
            menuEmergente.add(menuVerde);

            EventoMouse eventoMouse = new EventoMouse();
            addMouseListener(eventoMouse);

            Evento evento = new Evento();
            menuRojo.addActionListener(evento);
            menuAzul.addActionListener(evento);
            menuVerde.addActionListener(evento);
        }

        private class EventoMouse extends MouseAdapter {
    
            public void mouseClicked(MouseEvent e){
    
                if (e.getButton()==3) {
                    menuEmergente.show(miPanel, e.getX(), e.getY());
                }
                
        
            }
        }

        private class Evento implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==menuRojo) {
                    setBackground(Color.RED);
                } else if (e.getSource()==menuAzul) {
                    setBackground(Color.BLUE);
                } else {
                    setBackground(Color.GREEN);
                }
            }
        }  
    }
}


