package com.admin.resource.utils;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Messages {

    public static void messageInformation(String mensaje) {
        JOptionPane.showMessageDialog(null, "<html><p style=\"font-size:14; text-align: center; color: #0080FF; font-weight: bold;\">" + mensaje + "</p></html>", "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void messageAlert(String mensaje) {
        JOptionPane.showMessageDialog(null, "<html><p style=\"font-size:14; text-align: center; color: #CC0000; font-weight: bold\">" + mensaje + "</p></html>", "Alerta", JOptionPane.WARNING_MESSAGE);
    }
    
    public static void messageAlert() {
        JOptionPane.showMessageDialog(null, "<html><p style=\"font-size:14; text-align: center; color: #CC0000; font-weight: bold\">Complete los datos obligatorios, por favor.</p></html>", "Alerta", JOptionPane.WARNING_MESSAGE);
    }
    
    public static void messageRepeat() {
        JOptionPane.showMessageDialog(null, "<html><p style=\"font-size:14; text-align: center; color: #CC0000; font-weight: bold\">Elemento duplicado, favor de verificar.</p></html>", "Alerta", JOptionPane.WARNING_MESSAGE);
    }
    
    public static void messageSelected() {
        JOptionPane.showMessageDialog(null, "<html><p style=\"font-size:14; text-align: center; color: #CC0000; font-weight: bold\">Seleccione una fila, por favor.</p></html>", "Alerta", JOptionPane.WARNING_MESSAGE);
    }

    public static void messageError(String mensaje) {
        JOptionPane.showMessageDialog(null, "<html><p style=\"font-size:14; text-align: center; color: #CC0000; font-weight: bold\">" + mensaje + "</p></html>", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static int messageConfirmation(String mensaje) {
        return JOptionPane.showConfirmDialog(null, "<html><p style=\"font-size:14; text-align: center; color: #404040; font-weight: bold\">" + mensaje + "</p></html>", "Confirmación", JOptionPane.YES_NO_OPTION);
    }
    
    public static int messageDeactive() {
        return JOptionPane.showConfirmDialog(null, "<html><p style=\"font-size:14; text-align: center; color: #404040; font-weight: bold\">¿Desea desactivar la fila seleccionada?</p></html>", "Confirmación", JOptionPane.YES_NO_OPTION);
    }
    
    public static int messageActive() {
        return JOptionPane.showConfirmDialog(null, "<html><p style=\"font-size:14; text-align: center; color: #404040; font-weight: bold\">¿Desea activar la fila seleccionada?</p></html>", "Confirmación", JOptionPane.YES_NO_OPTION);
    }

    public static void messageOK(String mensaje) {
        final ImageIcon icon = new ImageIcon("src/Iconos/accept.png");
        JOptionPane.showMessageDialog(null, "<html><p style=\"font-size:14; text-align: center; color: #00994C; font-weight: bold\">" + mensaje + "</p></html>", "Solicitud completada", JOptionPane.INFORMATION_MESSAGE, icon);
    }
    
    public static void messageInsert() {
        final ImageIcon icon = new ImageIcon("src/Iconos/accept.png");
        JOptionPane.showMessageDialog(null, "<html><p style=\"font-size:14; text-align: center; color: #00994C; font-weight: bold\">Inserción completada.</p></html>", "Solicitud completada", JOptionPane.INFORMATION_MESSAGE, icon);
    }
    
    public static void messageUpdate() {
        final ImageIcon icon = new ImageIcon("src/Iconos/accept.png");
        JOptionPane.showMessageDialog(null, "<html><p style=\"font-size:14; text-align: center; color: #00994C; font-weight: bold\">Modificación completada.</p></html>", "Solicitud completada", JOptionPane.INFORMATION_MESSAGE, icon);
    }
    
    public static void messageDelete() {
        final ImageIcon icon = new ImageIcon("src/Iconos/accept.png");
        JOptionPane.showMessageDialog(null, "<html><p style=\"font-size:14; text-align: center; color: #00994C; font-weight: bold\">Desactivación completada.</p></html>", "Solicitud completada", JOptionPane.INFORMATION_MESSAGE, icon);
    }
    
    public static void messageUnDelete() {
        final ImageIcon icon = new ImageIcon("src/Iconos/accept.png");
        JOptionPane.showMessageDialog(null, "<html><p style=\"font-size:14; text-align: center; color: #00994C; font-weight: bold\">Activación completada.</p></html>", "Solicitud completada", JOptionPane.INFORMATION_MESSAGE, icon);
    }
    
    public static void messageErrorInsert() {
        JOptionPane.showMessageDialog(null, "<html><p style=\"font-size:14; text-align: center; color: #CC0000; font-weight: bold\">Ocurrio un problema al insertar.</p></html>", "Alerta", JOptionPane.WARNING_MESSAGE);
    }
    
    public static void messageErrorUpdate() {
        JOptionPane.showMessageDialog(null, "<html><p style=\"font-size:14; text-align: center; color: #CC0000; font-weight: bold\">Ocurrio un problema al modificar.</p></html>", "Alerta", JOptionPane.WARNING_MESSAGE);
    }
    
    public static void messageErrorUnDelete() {
        JOptionPane.showMessageDialog(null, "<html><p style=\"font-size:14; text-align: center; color: #CC0000; font-weight: bold\">Ocurrio un problema al activar.</p></html>", "Alerta", JOptionPane.WARNING_MESSAGE);
    }
    
    public static void messageErrorDelete() {
        JOptionPane.showMessageDialog(null, "<html><p style=\"font-size:14; text-align: center; color: #CC0000; font-weight: bold\">Ocurrio un problema al desactivar.</p></html>", "Alerta", JOptionPane.WARNING_MESSAGE);
    }
    
    public static String messageInput(String mensaje) {
        return JOptionPane.showInputDialog(null, mensaje);
    }

}
