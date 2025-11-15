/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programas;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author crist
 */
public class ListasTipoArrayList extends JFrame implements ActionListener {
    private JButton boton;
    private JTextField campoTexto;
    private JTextArea areaTexto;
    private ArrayList<String> lista = new ArrayList<>();

    public static void main(String[] args){
        ListasTipoArrayList marco = new ListasTipoArrayList();
        marco.setSize(200,300);
        marco.crearGUI();
        marco.setVisible(true);
    }    
    
    private void crearGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container ventana = getContentPane();
        ventana.setLayout(new FlowLayout());
        areaTexto = new JTextArea(7, 7);
//        ventana.add(areaTexto); // Probar primero esta linea
        // ---- Luego comentar la linea anterior y probar las siguientes
        JScrollPane panelDesplazable = new JScrollPane(areaTexto);
        ventana.add(panelDesplazable);
        boton = new JButton("Agregar");
        campoTexto = new JTextField(5);
        ventana.add(campoTexto);
        ventana.add(boton);
        boton.addActionListener(this);
    }
    
    private void mostrarConIndices(ArrayList <String> lista) {
        final String nuevaLinea = "\r\n";
        final String tab = "\t";
        areaTexto.setTabSize(3);
        areaTexto.setText("");
        for (int indice = 0; indice < lista.size(); indice ++) {
            areaTexto.append(Integer.toString(indice) + tab + lista.get(indice) + nuevaLinea);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        agregarUnElemento(lista);
        mostrarConIndices(lista);
//        mostrar(lista);
    }
    
        private void agregarUnElemento(ArrayList <String> lista) {
            lista.add(campoTexto.getText());
        }   
    


  
    private void mostrar(ArrayList <String> lista) {
        final String nuevaLinea = "\r\n";
        areaTexto.setText("");
        for (String cadena : lista) {
        areaTexto.append(cadena + nuevaLinea);
        }   
    }
}
