/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cuc.metodos;

import edu.cuc.vistas.VentanaSecundaria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CARLOS
 */
public class Metodos {
    
    public static Cola cargarDatos(String archivo){
        Cola<String> newCola = new Cola();
        try {
            BufferedReader read = new BufferedReader(new FileReader(archivo));
            try {
                while(read.ready()){
                    newCola.enqueue(read.readLine());
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Archivo no encontrado");
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo indicado");
        
        }
        return newCola;
    }
    public static void tableTail(Cola<String> cola, JTable tabla) {
        DefaultTableModel tabla1 = new DefaultTableModel(cola.getSize(), 1);
        Iterator<String> recorrido = cola.recorrido();
        int i = 0;
        String[] header={"Material a imprimir"};
        while (recorrido.hasNext()) {
            String next = recorrido.next();
            String dato = " ";
            int j = 0;
            while (next.charAt(j) != ',') {
                dato += next.charAt(j);
                j++;
            }
            tabla1.setValueAt(dato, i, 0);
            i++;
        }
        tabla1.setColumnIdentifiers(header);
        tabla.setModel(tabla1);
    }
    public static void newTable (JTable tabla, Cola<String> imprimir) {
   
        DefaultTableModel tabla1= new DefaultTableModel(tabla.getRowCount()-1,1);
        imprimir.dequeue();
   Iterator<String> recorrido= imprimir.recorrido();
    int i=0;
    
       while (recorrido.hasNext()) {
           String next = recorrido.next();
            String dato = "";
            int j = 0;
            
            while (next.charAt(j) != ',') {
                dato += next.charAt(j);
                j++;
            }
            tabla1.setValueAt(dato, i, 0);
            i++;
       }
   tabla.setModel(tabla1);
   }
    
    public static String getName(String next) {
        int i=0;
        String dato = "";
        while (next.charAt(i) != ',') {
            dato += next.charAt(i);
            i++;
        }
        i++;
        return dato;
    }
    
    public static long getSeconds(String next) {
        int i=0;
        while (next.charAt(i) != ',') {
            i++;
        }
        i++;
        String timer = "";
        while (i < next.length()) {
            timer += next.charAt(i);
            i++;
        }
        return Long.parseLong(timer);
    }
    
    public static void iniciarSimulacion(String next,Cola imprimir, VentanaSecundaria dialog) {

            String dato = getName(next);
            dialog.setArchivo(dato);
            Timer timer = new Timer(1000, new ActionListener() {
                long time = getSeconds(next) * 1000;

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (time>0) {
                        
                        dialog.setLblEspere("Espere " + time / 1000 + " segundos");
                        time-= 1000;
                        
                    } else {
                        dialog.setVisible(false);
                    }
                }
            });
            
            boolean began = true;
            dialog.setLblEspere("Espere...");
            dialog.setVisible(true);
            while (began) {
                timer.start();
                if (!dialog.isVisible()) {
                    timer.stop();
                    began = false;
                }
            }
            
    }
    
    
}