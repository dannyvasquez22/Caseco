package com.admin.resource.utils;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class ValidateForms {

    public static void soloMayus(JTextField txt0) {
        txt0.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                /*char c = e.getKeyChar();
                String aux = txt0.getText();
                txt0.setText("");
                if(!aux.isEmpty())
                    aux=aux.substring(0,aux.length()-1);
                aux+=String.valueOf(c).toUpperCase();
                txt0.setText(aux);*/
                char c = e.getKeyChar();
                if (Character.isLetter(c)) {
                    e.setKeyChar(Character.toUpperCase(c));
                }
            }
        });
    }

    public static void soloNumeros(JTextField txt) {//Validar solo el ingreso de numeros
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });
    }

    public static void soloDecimales(JTextField txt) {//Validar el ingreso de decimales
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && Character.isLetter(c)) {
                    e.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });
    }

    //Validar solo la cantidad de carateres deseados
    public static void cantCaracteres(final JTextField txt, final int limite) {
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (txt.getText().length() == limite) {
                    e.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
            }
            @Override
            public void keyPressed(KeyEvent arg0) {
            }
            @Override
            public void keyReleased(KeyEvent arg0) {
            }
        });
    }

    public static void soloLetras(JTextField txt) { //Validar que el ingreso sea solo letras
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isDigit(c)) {
                    e.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });
    }
    
    @SuppressWarnings("UnusedAssignment")
    public static boolean estaVacio(JTextField txt) {//Validar que campos no esten vacios
        boolean valor = false;
        String val = txt.getText().trim();
        valor = !val.isEmpty();
        return valor;
    }

    public static boolean validarPassword(char[]p1, char[]p2) {
        boolean valor = false;
        int puntero = 0;
        if (p1.length != p2.length) {
            valor = false;
        } else {
            while ((!valor) && puntero < p1.length) {
                valor = p1[puntero] == p2[puntero];
            }
        }
        return valor;
    }
}
