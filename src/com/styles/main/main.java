/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.styles.main;

import com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel-Samir
 *
 */
public class main extends javax.swing.JFrame {

    int ciclo = 0;
    String codop = "vacio";
    String inst1 = "instr 1";
    String inst2 = "instr 2";

    public main() {

        initComponents();

    }

    public String obtenerCodop(String inst) {
        codop = "";
        for (int i = 0; i < 4; i++) {
            String a = String.valueOf(inst.charAt(i));
            codop += a;

        }
        return codop;
    }

    public String obtenerInstruccion1(String dir) {
        inst1 = "";
        for (int i = 4; i > 3 & i < 10; i++) {
            String b = String.valueOf(dir.charAt(i));
            inst1 += b;

        }
        return inst1;
    }

    public String obtenerInstruccion2(String dir) {
        inst2 = "";
        for (int i = 10;
                i > 9 & i < 16; i++) {
            String c = String.valueOf(dir.charAt(i));
            inst2 += c;
            //inst2.concat(c); 
        }
        return inst2;

    }

    public void exeResultado(int opcion) {
        switch (opcion) {
            case 0000: //move
                jTFResultado.setText(inst1 + "->" + inst2);
                JOptionPane.showMessageDialog(null, "La dirección " + inst1 + " se ha movido a la direción " + inst2, "Pantalla", 1);
                jTFmemoria.setText("[" + inst2 + "]: " + inst1);
                break;

            case 0001: //clear
                jTFResultado.setText(inst1 + "&" + inst2 + "=0 ");
                JOptionPane.showMessageDialog(null, "Las direcciones " + inst1 + " y " + inst2 + " se han reemplazado por palabras 0 ", "Pantalla", 1);
                String clear = "";
                clear += "[" + inst1 + "]: 000000\n";

                clear += "[" + inst2 + "]: 000000\n";

                jTFmemoria.setText(clear);
                break;

            case 10: //set
                jTFResultado.setText(inst1 + "&" + inst2 + "=1 ");
                JOptionPane.showMessageDialog(null, "Las direcciones " + inst1 + " y " + inst2 + " se han reemplazado por palabras 1 ", "Pantalla", 1);
                String set = "";
                set += "[" + inst1 + "]: 111111\n" + "";
                set += "[" + inst2 + "]: 111111\n";
                jTFmemoria.setText(set);
                break;

            case 11: //store
                jTFResultado.setText(inst1 + "&" + inst2);
                JOptionPane.showMessageDialog(null, "Las direcciones " + inst1 + " y " + inst2 + " se ha movido a la memoria ", "Pantalla", 1);
                jTFmemoria.setText("[" + inst2 + "]: " + inst1);
                break;

            case 100: //add

                String input0 = inst1;
                String input1 = inst2;

                int number0 = Integer.parseInt(input0, 2);
                int number1 = Integer.parseInt(input1, 2);

                int sum = number0 + number1;
                String resultado = Integer.toBinaryString(sum);
                jTFResultado.setText(String.valueOf(resultado));
                JOptionPane.showMessageDialog(null, "El resultado de la suma es: \n" + String.valueOf(resultado), "Pantalla", 1);
                break;

            case 101: //sub

                String nst = "",
                 max = "";
                char b = '0';
                boolean tf = (inst1.length() >= inst2.length());
                int l1 = inst1.length(),
                 l2 = inst2.length();
                if (l1 < l2) {
                    for (int a = 1; a <= l2 - l1; a++) {
                        inst1 = '0' + inst1;
                    }
                } else if (l2 < l1) {
                    for (int a = 1; a <= l1 - l2; a++) {
                        inst2 = "0" + inst2;
                    }
                }
                if (!tf) {
                    for (int a = l1 - 1; a >= 0; a--) {
                        if (inst1.charAt(a) != inst2.charAt(a)) {
                            if (inst2.charAt(a) == '1') {
                                max = inst2;
                                inst2 = inst1;
                                inst1 = max;
                                break;
                            }
                        }
                    }
                }

                for (int a = inst1.length() - 1; a >= 0; a--) {
                    if (inst1.charAt(a) == '1' && inst2.charAt(a) == '0') {
                        if (b == '1') {
                            nst = '0' + nst;
                            b = '0';
                        } else {
                            nst = '1' + nst;
                        }
                    } else if (inst1.charAt(a) == inst2.charAt(a) && inst2.charAt(a) == '1') {
                        if (b == '1') {
                            nst = '1' + nst;
                            b = '1';
                        } else {
                            nst = '0' + nst;
                        }
                    } else if (inst1.charAt(a) == '0' && inst2.charAt(a) == '1') {
                        if (b == '1') {
                            nst = '0' + nst;
                        } else {
                            nst = '1' + nst;
                            b = '1';
                        }
                    } else {
                        if (b == '1') {
                            nst = '1' + nst;
                        } else {
                            nst = '0' + nst;
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "El resultado de la resta es: \n" + nst, "Pantalla", 1);
                jTFResultado.setText(nst);

                break;

            case 110: //mpy              
                int prim = Integer.parseInt(inst1, 2);
                int sec = Integer.parseInt(inst2, 2);

                int r = prim * sec;

                String rBin = Integer.toBinaryString(r);
                JOptionPane.showMessageDialog(null, "El resultado de la multiplicacion es: \n" + rBin, "Pantalla", 1);
                jTFResultado.setText(rBin);
                break;

            case 111:// div
                int primero = Integer.parseInt(inst1, 2);
                int segundo = Integer.parseInt(inst2, 2);

                int div = primero / segundo;

                String division = Integer.toBinaryString(div);
                JOptionPane.showMessageDialog(null, "El resultado de la division es: \n" + division, "Pantalla", 1);
                jTFResultado.setText(division);
                break;

            case 1000: //negate
                String negate = "";

                for (int i = 0; i < inst1.length(); i++) {
                    char n = inst1.charAt(i);
                    if (String.valueOf(n).equals("1")) {
                        negate += "0";
                    }
                    if (String.valueOf(n).equals("0")) {
                        negate += "1";
                    }
                }
                negate += "-";
                for (int i = 0; i < inst2.length(); i++) {
                    char nn = inst2.charAt(i);
                    if (String.valueOf(nn).equals("1")) {
                        negate += "0";
                    }
                    if (String.valueOf(nn).equals("0")) {
                        negate += "1";
                    }
                }
                JOptionPane.showMessageDialog(null, "Los valores negados son: \n" + negate, "Pantalla", 1);
                jTFResultado.setText(negate);

                break;

            case 1001: //and
                String and = "";
                for (int i = 0; i < inst1.length(); i++) {
                    for (int j = 0; j < inst2.length(); j++) {
                        char ii = inst1.charAt(i);
                        char jj = inst2.charAt(j);
                        if (Character.valueOf(ii).equals(Character.valueOf(jj))) {
                            and += 1;
                        } else {
                            and += 0;
                        }

                    }
                }
                JOptionPane.showMessageDialog(null, "La conjuncion logica da: \n" + and, "Pantalla", 1);
                jTFResultado.setText(and);

                break;

            case 1010: //Or
                String or = "";
                for (int i = 0; i < inst1.length(); i++) {
                    for (int j = 0; j < inst2.length(); j++) {
                        char ii = inst1.charAt(i);
                        char jj = inst2.charAt(j);
                        if (Character.valueOf(ii).equals("1") | Character.valueOf(jj).equals("1")) {
                            or += 1;
                        } else {
                            or += 0;
                        }

                    }
                }
                jTFResultado.setText(or);
                JOptionPane.showMessageDialog(null, "La disyuncion logica da: \n" + or, "Pantalla", 1);
                break;

            case 1011: //not 
                String not = "";

                for (int i = 0; i < inst1.length(); i++) {
                    char n = inst1.charAt(i);
                    if (String.valueOf(n).equals("1")) {
                        not += "0";
                    }
                    if (String.valueOf(n).equals("0")) {
                        not += "1";
                    }
                }
                not += "-";
                for (int i = 0; i < inst2.length(); i++) {
                    char nn = inst2.charAt(i);
                    if (String.valueOf(nn).equals("1")) {
                        not += "0";
                    }
                    if (String.valueOf(nn).equals("0")) {
                        not += "1";
                    }
                }
                JOptionPane.showMessageDialog(null, "El valor negado es: \n" + not, "Pantalla", 1);

                jTFResultado.setText(not);

                break;

            case 1100: //compare
                String compare = "";

                if (inst1.equals(inst2)) {
                    compare = "Números iguales";
                } else {
                    compare = "Numeros distintos";
                }
                JOptionPane.showMessageDialog(null, "Los valores son: \n" + compare, "Pantalla", 1);
                jTFResultado.setText(compare);
                break;

            default:
                System.out.println("switch default case");

        }
    }

    public void paso1(String dir, String dir2, int ciclo) throws InterruptedException {

        if (ciclo == 1) {
            jTFuc.setText(dir);
        }
        if (ciclo == 2) {
            jTFuc.setText(dir2);
        }
    }

    public void paso2(String dir, String dir2, int ciclo) throws InterruptedException {

        if (ciclo == 1) {
            jTFuc.setText("");
            jTFpc.setText(dir);
        }
        if (ciclo == 2) {
            jTFuc.setText("");
            jTFpc.setText(dir2);
        }
    }

    public void paso3(String dir, String dir2, int ciclo) throws InterruptedException {

        if (ciclo == 1) {
            jTFpc.setText("");
            jTFmar.setText(dir);
        }
        if (ciclo == 2) {
            jTFpc.setText("");
            jTFmar.setText(dir2);
        }
    }

    public void paso4(String dir, String dir2, int ciclo) throws InterruptedException {

        if (ciclo == 1) {
            JTARegistros.append("\n" + dir);
            jTFmar.setText("");
            jTFbIntr.setText(dir);
        }
        if (ciclo == 2) {
            jTFac.setText(dir);
            JTARegistros.append("\n" + dir2);
            jTFmar.setText("");
            jTFbIntr.setText(dir2);
        }
    }

    public void paso5(String dir, String dir2, int ciclo) throws InterruptedException {

        if (ciclo == 1) {
            jTFbDatos.setText("");
            jTAalu.setText("Orden: \nmover dato de memoria a bus de datos \n" + dir);//move 
        }
        if (ciclo == 2) {
            jTFbDatos.setText("");
            jTAalu.setText("Orden: \nmover dato de memoria a bus de datos\n" + dir2);
        }

    }

    public void paso6(String dir, String dir2, int ciclo) throws InterruptedException {

        if (ciclo == 1) {
            jTFuc.setText("");
            jTFbControl.setText(dir);
        }
        if (ciclo == 2) {
            jTFuc.setText("");
            jTFbControl.setText(dir2);
        }
    }

    public void paso7(String dir, String dir2, int ciclo) throws InterruptedException {

        if (ciclo == 1) {
            jTFuc.setText("");
            jTFbControl.setText("");
            jTFbDatos.setText(dir);
        }
        if (ciclo == 2) {
            jTFuc.setText("");
            jTFbControl.setText("");
            jTFbDatos.setText(dir2);
        }

    }

    public void paso8(String dir, String dir2, int ciclo) throws InterruptedException {
        if (ciclo == 1) {
            jTFbDatos.setText("");
            jTFmbr.setText(dir);
        }
        if (ciclo == 2) {
            jTFbDatos.setText("");
            jTFmbr.setText(dir2);
        }
    }

    public void paso9(String dir, String dir2, int ciclo) {

        if (ciclo == 1) {
            jTFmbr.setText("");
            jTFir.setText(dir);
            jTAMemoriaProg.setText(JTARegistros.getText());
        }
        if (ciclo == 2) {
            jTFmbr.setText("");
            jTAMemoriaProg.setText(JTARegistros.getText());
            jTFir.setText(dir2);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelbord1 = new com.styles.swing.Panelborder();
        panelborder1 = new com.styles.swing.Panelborder();
        listRegistros = new java.awt.List();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTFbDatos = new javax.swing.JTextField();
        jTFbControl = new javax.swing.JTextField();
        jTFbIntr = new javax.swing.JTextField();
        jTFpc = new javax.swing.JTextField();
        jTFuc = new javax.swing.JTextField();
        jTFmbr = new javax.swing.JTextField();
        jTFmar = new javax.swing.JTextField();
        jTFir = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAalu = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jBtnSalir = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jTFintrucComp = new javax.swing.JTextField();
        btnCap1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTARegistros = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jTFac = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btnCap2 = new javax.swing.JButton();
        btnCap3 = new javax.swing.JButton();
        btnCap4 = new javax.swing.JButton();
        btnCap5 = new javax.swing.JButton();
        btnCap6 = new javax.swing.JButton();
        btnCap7 = new javax.swing.JButton();
        btnCap8 = new javax.swing.JButton();
        btnCap9 = new javax.swing.JButton();
        btnExe = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btnMostrarCod = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTFmemoria = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTFResultado = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTAMemoriaProg = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setTitle("CPU");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(204, 204, 204));
        setExtendedState(6);
        setMinimumSize(new java.awt.Dimension(1200, 550));
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 550));

        panelbord1.setFocusable(false);
        panelbord1.setPreferredSize(new java.awt.Dimension(1200, 550));

        panelborder1.setBackground(new java.awt.Color(51, 51, 51));
        panelborder1.setPreferredSize(new java.awt.Dimension(1200, 550));

        listRegistros.setVisible(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bus Datos");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bus Ctrl");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Bus Direcciones");

        jTFbDatos.setEditable(false);
        jTFbDatos.setForeground(new java.awt.Color(255, 255, 255));
        jTFbDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFbDatosActionPerformed(evt);
            }
        });

        jTFbControl.setEditable(false);
        jTFbControl.setForeground(new java.awt.Color(255, 255, 255));

        jTFbIntr.setEditable(false);
        jTFbIntr.setForeground(new java.awt.Color(255, 255, 255));

        jTFpc.setEditable(false);
        jTFpc.setForeground(new java.awt.Color(255, 255, 255));
        jTFpc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFpcActionPerformed(evt);
            }
        });

        jTFuc.setEditable(false);
        jTFuc.setForeground(new java.awt.Color(255, 255, 255));
        jTFuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFucActionPerformed(evt);
            }
        });

        jTFmbr.setEditable(false);
        jTFmbr.setForeground(new java.awt.Color(255, 255, 255));
        jTFmbr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFmbrActionPerformed(evt);
            }
        });

        jTFmar.setEditable(false);
        jTFmar.setForeground(new java.awt.Color(255, 255, 255));
        jTFmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFmarActionPerformed(evt);
            }
        });

        jTFir.setEditable(false);
        jTFir.setForeground(new java.awt.Color(255, 255, 255));
        jTFir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFirActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Controlador del Programa");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Unidad de control");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("IR");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("MAR");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("MBR");

        jTAalu.setEditable(false);
        jTAalu.setColumns(20);
        jTAalu.setRows(5);
        jScrollPane1.setViewportView(jTAalu);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ALU");

        jBtnSalir.setText("x");
        jBtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalirActionPerformed(evt);
            }
        });

        jTFintrucComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFintrucCompActionPerformed(evt);
            }
        });

        btnCap1.setFont(new java.awt.Font("Sitka Small", 1, 12)); // NOI18N
        btnCap1.setText("1");
        btnCap1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCap1ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Resultado");

        JTARegistros.setEditable(false);
        JTARegistros.setColumns(20);
        JTARegistros.setForeground(new java.awt.Color(255, 255, 255));
        JTARegistros.setRows(10);
        JTARegistros.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), javax.swing.BorderFactory.createCompoundBorder()));
        JTARegistros.setSelectionColor(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(JTARegistros);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Regristros");

        jTFac.setEditable(false);
        jTFac.setForeground(new java.awt.Color(255, 255, 255));
        jTFac.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTFac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFacActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Acumulador");

        btnCap2.setFont(new java.awt.Font("Sitka Small", 1, 12)); // NOI18N
        btnCap2.setText("2");
        btnCap2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCap2ActionPerformed(evt);
            }
        });

        btnCap3.setFont(new java.awt.Font("Sitka Small", 1, 12)); // NOI18N
        btnCap3.setText("3");
        btnCap3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCap3ActionPerformed(evt);
            }
        });

        btnCap4.setFont(new java.awt.Font("Sitka Small", 1, 12)); // NOI18N
        btnCap4.setText("4");
        btnCap4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCap4ActionPerformed(evt);
            }
        });

        btnCap5.setFont(new java.awt.Font("Sitka Small", 1, 12)); // NOI18N
        btnCap5.setText("5");
        btnCap5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCap5ActionPerformed(evt);
            }
        });

        btnCap6.setFont(new java.awt.Font("Sitka Small", 1, 12)); // NOI18N
        btnCap6.setText("6");
        btnCap6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCap6ActionPerformed(evt);
            }
        });

        btnCap7.setFont(new java.awt.Font("Sitka Small", 1, 12)); // NOI18N
        btnCap7.setText("7");
        btnCap7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCap7ActionPerformed(evt);
            }
        });

        btnCap8.setFont(new java.awt.Font("Sitka Small", 1, 12)); // NOI18N
        btnCap8.setText("8");
        btnCap8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCap8ActionPerformed(evt);
            }
        });

        btnCap9.setFont(new java.awt.Font("Sitka Small", 1, 12)); // NOI18N
        btnCap9.setText("9");
        btnCap9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCap9ActionPerformed(evt);
            }
        });

        btnExe.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnExe.setText("Generar Resultado");
        btnExe.setEnabled(false);
        btnExe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExeActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Entrada:");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnMostrarCod.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnMostrarCod.setText("CodOps");
        btnMostrarCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarCodActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Memoria de Datos:");

        jTFmemoria.setEditable(false);
        jTFmemoria.setColumns(20);
        jTFmemoria.setForeground(new java.awt.Color(255, 255, 255));
        jTFmemoria.setRows(5);
        jScrollPane3.setViewportView(jTFmemoria);

        jTFResultado.setEditable(false);
        jTFResultado.setColumns(20);
        jTFResultado.setForeground(new java.awt.Color(255, 255, 255));
        jTFResultado.setRows(5);
        jScrollPane4.setViewportView(jTFResultado);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Memoria de Programa:");

        jTAMemoriaProg.setEditable(false);
        jTAMemoriaProg.setColumns(20);
        jTAMemoriaProg.setForeground(new java.awt.Color(255, 255, 255));
        jTAMemoriaProg.setRows(5);
        jScrollPane5.setViewportView(jTAMemoriaProg);

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("CPU");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Pasos");
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout panelborder1Layout = new javax.swing.GroupLayout(panelborder1);
        panelborder1.setLayout(panelborder1Layout);
        panelborder1Layout.setHorizontalGroup(
            panelborder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelborder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelborder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelborder1Layout.createSequentialGroup()
                        .addGroup(panelborder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelborder1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(537, 537, 537))
                            .addGroup(panelborder1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(209, 209, 209)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelborder1Layout.createSequentialGroup()
                                .addGroup(panelborder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelborder1Layout.createSequentialGroup()
                                        .addGroup(panelborder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(panelborder1Layout.createSequentialGroup()
                                                .addGroup(panelborder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel7))
                                                .addGap(75, 75, 75))
                                            .addGroup(panelborder1Layout.createSequentialGroup()
                                                .addGroup(panelborder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jTFmbr, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTFmar, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTFac))
                                                .addGap(6, 6, 6)))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelborder1Layout.createSequentialGroup()
                                        .addGroup(panelborder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel13))
                                        .addGap(53, 53, 53)
                                        .addGroup(panelborder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTFuc, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jTFir, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54)
                                .addGroup(panelborder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTFpc, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addGroup(panelborder1Layout.createSequentialGroup()
                                        .addGroup(panelborder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(panelborder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGap(22, 22, 22)
                                        .addGroup(panelborder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTFbIntr, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTFbControl, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTFbDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelborder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3)
                                    .addComponent(jScrollPane5))))
                        .addGroup(panelborder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelborder1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelborder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnCap2)
                                    .addComponent(btnCap1)
                                    .addComponent(btnCap3)
                                    .addComponent(btnCap4)
                                    .addComponent(btnCap5)
                                    .addComponent(btnCap6)
                                    .addComponent(btnCap7)
                                    .addComponent(btnCap8)
                                    .addComponent(btnCap9)
                                    .addComponent(jLabel17)
                                    .addComponent(jBtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(92, 92, 92))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelborder1Layout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addComponent(listRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(19, 19, 19))))
                    .addGroup(panelborder1Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMostrarCod)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTFintrucComp, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelborder1Layout.setVerticalGroup(
            panelborder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelborder1Layout.createSequentialGroup()
                .addGroup(panelborder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelborder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(btnExe)
                        .addComponent(btnMostrarCod))
                    .addGroup(panelborder1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelborder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFintrucComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jBtnSalir))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelborder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelborder1Layout.createSequentialGroup()
                        .addComponent(listRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel17)
                        .addGap(18, 29, Short.MAX_VALUE)
                        .addComponent(btnCap1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCap2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCap3)
                        .addGap(18, 18, 18)
                        .addComponent(btnCap4)
                        .addGap(18, 18, 18)
                        .addComponent(btnCap5)
                        .addGap(18, 18, 18)
                        .addComponent(btnCap6)
                        .addGap(18, 18, 18)
                        .addComponent(btnCap7)
                        .addGap(18, 18, 18)
                        .addComponent(btnCap8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCap9)
                        .addGap(88, 88, 88))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelborder1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(panelborder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelborder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelborder1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane5))
                            .addGroup(panelborder1Layout.createSequentialGroup()
                                .addGroup(panelborder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelborder1Layout.createSequentialGroup()
                                        .addComponent(jTFir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTFac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panelborder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelborder1Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTFmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel8))
                                            .addGroup(panelborder1Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTFpc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTFmbr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29))
                                    .addGroup(panelborder1Layout.createSequentialGroup()
                                        .addGroup(panelborder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel1)
                                            .addComponent(jTFbDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelborder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(jTFbControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelborder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel3)
                                            .addComponent(jTFbIntr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(panelborder1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(panelborder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelborder1Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelborder1Layout.createSequentialGroup()
                                        .addGroup(panelborder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel12))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelborder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTFuc)
                                            .addComponent(jScrollPane4))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout panelbord1Layout = new javax.swing.GroupLayout(panelbord1);
        panelbord1.setLayout(panelbord1Layout);
        panelbord1Layout.setHorizontalGroup(
            panelbord1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelbord1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelborder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelbord1Layout.setVerticalGroup(
            panelbord1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelbord1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelborder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelbord1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelbord1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTFmbrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFmbrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFmbrActionPerformed

    private void jTFbDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFbDatosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFbDatosActionPerformed

    private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalirActionPerformed
        // TODO add your handling code here:

        JFrame frame = new JFrame("Salir");

        if (JOptionPane.showConfirmDialog(frame, "¿Desea cerrar el programa?",
                "SALIR", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
            System.exit(0);
        }

    }//GEN-LAST:event_jBtnSalirActionPerformed

    private void jTFmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFmarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFmarActionPerformed

    private void jTFirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFirActionPerformed

    private void btnCap1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCap1ActionPerformed
        // TODO add your handling code here:
        String dir = jTFintrucComp.getText().trim();
     

        while (dir.equals("") | dir.length() == 0) {
            JFrame fram = new JFrame("Entrada nula");
            fram.setAlwaysOnTop(true);
            dir = dir.valueOf(JOptionPane.showInputDialog(fram,
                    "La entrada no puede ser nula", "INVALID ENTRY", JOptionPane.INFORMATION_MESSAGE));
            jTFintrucComp.setText(dir);
            if (dir.equals("") | dir.length() == 0) {
                break;
            }
        }

        /*if (dir.length() > 16) {
            JFrame frame = new JFrame("Es mayor a 16");
            frame.setAlwaysOnTop(true);
            dir = dir.valueOf(JOptionPane.showInputDialog(frame,
                    "La entrada no puede ser mayor a 16", "INVALID ENTRY", JOptionPane.INFORMATION_MESSAGE));
            jTFintrucComp.setText(dir);
            // b16=true;
        }*/
        if (dir.length() < 16 & !dir.equals("")) {
            JFrame frames = new JFrame("Es menor a 16 bits");
            frames.setAlwaysOnTop(true);
            dir = dir.valueOf(JOptionPane.showInputDialog(frames,
                    "La entrada no puede ser menor a 16 bits", "INVALID ENTRY", JOptionPane.INFORMATION_MESSAGE));
            jTFintrucComp.setText(dir);
            //bm16=true;
        }

        btnCap1.setEnabled(false);
        ciclo += 1;

        codop = obtenerCodop(dir);
        inst1 = obtenerInstruccion1(dir);
        inst2 = obtenerInstruccion2(dir);

        try {
            paso1(inst1, inst2, ciclo);

        } catch (InterruptedException ex) {
            Logger.getLogger(main.class
                    .getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnCap1ActionPerformed

    private void btnCap2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCap2ActionPerformed
        // TODO add your handling code here:

        btnCap2.setEnabled(false);
        try {
            paso2(inst1, inst2, ciclo);

        } catch (InterruptedException ex) {
            Logger.getLogger(main.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCap2ActionPerformed

    private void btnCap4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCap4ActionPerformed
        // TODO add your handling code here:

        btnCap4.setEnabled(false);
        try {
            paso4(inst1, inst2, ciclo);

        } catch (InterruptedException ex) {
            Logger.getLogger(main.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCap4ActionPerformed

    private void btnExeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExeActionPerformed
        // TODO add your handling code here:
        int opcion = Integer.parseInt(codop);

        exeResultado(opcion);

    }//GEN-LAST:event_btnExeActionPerformed

    private void btnCap3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCap3ActionPerformed
        btnCap3.setEnabled(false);
        try {
            paso3(inst1, inst2, ciclo);

        } catch (InterruptedException ex) {
            Logger.getLogger(main.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCap3ActionPerformed

    private void btnCap8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCap8ActionPerformed
        // TODO add your handling code here:
        btnCap8.setEnabled(false);

        try {
            paso8(inst1, inst2, this.ciclo);

        } catch (InterruptedException ex) {
            Logger.getLogger(main.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCap8ActionPerformed

    private void jTFpcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFpcActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_jTFpcActionPerformed

    private void jTFacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFacActionPerformed

    private void btnCap5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCap5ActionPerformed
        // TODO add your handling code here:
        btnCap5.setEnabled(false);

        try {
            paso5(inst1, inst2, ciclo);

        } catch (InterruptedException ex) {
            Logger.getLogger(main.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCap5ActionPerformed

    private void btnCap6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCap6ActionPerformed
        // TODO add your handling code here:
        btnCap6.setEnabled(false);

        try {
            paso6(inst1, inst2, ciclo);

        } catch (InterruptedException ex) {
            Logger.getLogger(main.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCap6ActionPerformed

    private void btnCap7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCap7ActionPerformed
        // TODO add your handling code here:
        btnCap7.setEnabled(false);

        try {
            paso7(inst1, inst2, ciclo);

        } catch (InterruptedException ex) {
            Logger.getLogger(main.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCap7ActionPerformed

    private void btnCap9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCap9ActionPerformed
        // TODO add your handling code here:
        btnCap1.setEnabled(true);
        btnCap2.setEnabled(true);
        btnCap3.setEnabled(true);
        btnCap4.setEnabled(true);
        btnCap5.setEnabled(true);
        btnCap6.setEnabled(true);
        btnCap7.setEnabled(true);
        btnCap8.setEnabled(true);

        paso9(inst1, inst2, ciclo);

        JFrame fr = new JFrame(" Fin captación");
        //fr.setAlwaysOnTop(true);

        if (ciclo == 2) {
            btnExe.setEnabled(true);
            
            JOptionPane.showMessageDialog(fr,
                    "Fin del ciclo de captación\n",
                    "Fincap", JOptionPane.OK_OPTION);
            //jTFintrucComp.setText("");
            ciclo = 0;

        }
    }//GEN-LAST:event_btnCap9ActionPerformed

    private void btnMostrarCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarCodActionPerformed
        // TODO add your handling code here:

        JFrame fr = new JFrame("Mostrar codops");
        fr.setAlwaysOnTop(true);

        JOptionPane.showMessageDialog(fr,
                "0000 - move\n"
                + "0001 - clear\n"
                + "0010 - set\n"
                + "0011 - store	\n"
                + "0100 - add\n"
                + "0101 - sub\n"
                + "0110 - mpy\n"
                + "0111 - div\n"
                + "1000 - negate\n"
                + "1001 - and\n"
                + "1010 - or\n"
                + "1011 - not\n"
                + "1100 - compare",
                "Mostrar codops", JOptionPane.OK_OPTION);
    }//GEN-LAST:event_btnMostrarCodActionPerformed

    private void jTFucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFucActionPerformed

    private void jTFintrucCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFintrucCompActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFintrucCompActionPerformed
/**/
    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            FlatArcDarkIJTheme.setup();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea JTARegistros;
    private javax.swing.JButton btnCap1;
    private javax.swing.JButton btnCap2;
    private javax.swing.JButton btnCap3;
    private javax.swing.JButton btnCap4;
    private javax.swing.JButton btnCap5;
    private javax.swing.JButton btnCap6;
    private javax.swing.JButton btnCap7;
    private javax.swing.JButton btnCap8;
    private javax.swing.JButton btnCap9;
    private javax.swing.JButton btnExe;
    private javax.swing.JButton btnMostrarCod;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jBtnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTAMemoriaProg;
    private javax.swing.JTextArea jTAalu;
    private javax.swing.JTextArea jTFResultado;
    private javax.swing.JTextField jTFac;
    private javax.swing.JTextField jTFbControl;
    private javax.swing.JTextField jTFbDatos;
    private javax.swing.JTextField jTFbIntr;
    private javax.swing.JTextField jTFintrucComp;
    private javax.swing.JTextField jTFir;
    private javax.swing.JTextField jTFmar;
    private javax.swing.JTextField jTFmbr;
    private javax.swing.JTextArea jTFmemoria;
    private javax.swing.JTextField jTFpc;
    private javax.swing.JTextField jTFuc;
    private java.awt.List listRegistros;
    private com.styles.swing.Panelborder panelbord1;
    private com.styles.swing.Panelborder panelborder1;
    // End of variables declaration//GEN-END:variables
}
