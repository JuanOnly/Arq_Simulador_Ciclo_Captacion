/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.styles.main.main;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ctrlUtil {

    public static boolean validacaion(String dir) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
         boolean valido = false;

        try {
            boolean nula = true;
            boolean b16 = true;
            boolean bm16 = true;
            boolean binar = true;
            while (b16 | bm16 | binar | nula) {

                if (dir.equals("") | dir == null) {
                    JFrame fram = new JFrame("Entrada nula");
                    fram.setAlwaysOnTop(true);
                    dir = dir.valueOf(JOptionPane.showInputDialog(fram, "La entrada no puede ser nula", "INVALID ENTRY", JOptionPane.INFORMATION_MESSAGE));
                    nula = false;
                } else {
                    nula = false;
                }

                if (dir.length() > 16) {
                    JFrame frame = new JFrame("Es mayor a 16");
                    frame.setAlwaysOnTop(true);
                    dir = dir.valueOf(JOptionPane.showInputDialog(frame, "La entrada no puede ser mayor a 16", "INVALID ENTRY", JOptionPane.INFORMATION_MESSAGE));
                    // b16=false;
                } else {
                    b16 = false;
                }

                if (dir.length() < 16 & !dir.equals("")) {
                    JFrame frame = new JFrame("Es menor a 16 bits");
                    frame.setAlwaysOnTop(true);
                    dir = dir.valueOf(JOptionPane.showInputDialog(frame, "La entrada no puede ser menor a 16 bits", "INVALID ENTRY", JOptionPane.INFORMATION_MESSAGE));
                    bm16 = false;
                } else {
                    bm16 = false;
                }

                boolean flag = true;
                while (flag) {
                    for (int i = 0; i < dir.length(); i++) {
                        if (!dir.valueOf(i).equals('0') | !dir.valueOf(i).equals('1')) {

                            JFrame fram = new JFrame("Entrada nula");
                            fram.setAlwaysOnTop(true);
                            dir = dir.valueOf(JOptionPane.showInputDialog(fram, "La entrada no puede diferente de binario", "INVALID ENTRY", JOptionPane.INFORMATION_MESSAGE));
                            binar = false;
                        }

                    }
                    flag = false;
                    binar = false;
                }
            }
        } catch (Exception e) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, "la entrada es nula", e);
        }

        return valido;
    }

    public int[] stringToArray(String str) {
        //String cadena;

        // Creating array of string length
        int[] arr = new int[str.length()];

        // Copy character by character into array
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }

        // Printing the character array
        for (int x : arr) {
            System.out.println(x);
        }

        return arr;
    }

   

}
