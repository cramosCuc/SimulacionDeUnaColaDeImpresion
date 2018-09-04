/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cuc.metodos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
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
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newCola;
    }
    public static void tableTail(Cola<String> cola, JTable tabla) {
        DefaultTableModel tabla1 = new DefaultTableModel(cola.getSize(), 1);
        Iterator<String> recorrido = cola.recorrido();
        int i = 0;
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
        tabla.setModel(tabla1);
    }
}