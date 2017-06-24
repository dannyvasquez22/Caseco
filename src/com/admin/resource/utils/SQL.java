package com.admin.resource.utils;

//package Utils;
//
//import View.Main.Acceso;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class SQL {
//    public static int ver = 0;
//    public static String valor, valor1, valor2, valor3, valor4, valor5, valor6, valor7, valor8;
//
//    public static void Consulta(int num, String sql) {
//        valor = "";    valor1 = "";   valor2 = "";
//        valor3 = "";   valor4 = "";   valor5 = "";
//        valor6 = "";   valor7 = "";   valor8 = "";
//        Statement sent1;
//        ResultSet rst1;
//        try {
//            sent1 = Acceso.cn.createStatement();
//            rst1 = sent1.executeQuery(sql);            
//            switch(num) {
//                case 1:
//                    while (rst1.next()) {
//                        valor = rst1.getString(1);
//                    }   break;
//                case 2:
//                    while (rst1.next()) {
//                        valor = rst1.getString(1);
//                        valor1 = rst1.getString(2);
//                    }   break;
//                case 3:
//                    while (rst1.next()) {
//                        valor = rst1.getString(1);
//                        valor1 = rst1.getString(2);
//                        valor2 = rst1.getString(3);
//                    }    break;
//                case 4:
//                    while (rst1.next()) {
//                        valor = rst1.getString(1);
//                        valor1 = rst1.getString(2);
//                        valor2 = rst1.getString(3);
//                        valor3 = rst1.getString(4);
//                    }    break;
//                case 5:
//                    while (rst1.next()) {
//                        valor = rst1.getString(1);
//                        valor1=rst1.getString(2);
//                        valor2=rst1.getString(3);
//                        valor3=rst1.getString(4);
//                        valor4=rst1.getString(5);
//                    }   break;
//                case 6:
//                    while (rst1.next()) {
//                        valor = rst1.getString(1);
//                        valor1 = rst1.getString(2);
//                        valor2 = rst1.getString(3);
//                        valor3 = rst1.getString(4);
//                        valor4 = rst1.getString(5);
//                        valor5 = rst1.getString(6);
//                    }   break;
//                case 7:
//                    while (rst1.next()) {
//                        valor = rst1.getString(1);
//                        valor1 = rst1.getString(2);
//                        valor2 = rst1.getString(3);
//                        valor3 = rst1.getString(4);
//                        valor4 = rst1.getString(5);
//                        valor5 = rst1.getString(6);
//                        valor6 = rst1.getString(7);
//                    }   break;
//                case 8:
//                    while (rst1.next()) {
//                        valor = rst1.getString(1);
//                        valor1 = rst1.getString(2);
//                        valor2 = rst1.getString(3);
//                        valor3 = rst1.getString(4);
//                        valor4 = rst1.getString(5);
//                        valor5 = rst1.getString(6);
//                        valor6 = rst1.getString(7);
//                        valor7 = rst1.getString(8);
//                    }   break;
//                case 9:
//                    while (rst1.next()) {
//                        valor = rst1.getString(1);
//                        valor1 = rst1.getString(2);
//                        valor2 = rst1.getString(3);
//                        valor3 = rst1.getString(4);
//                        valor4 = rst1.getString(5);
//                        valor5 = rst1.getString(6);
//                        valor6 = rst1.getString(7);
//                        valor7 = rst1.getString(8);
//                        valor8 = rst1.getString(9);
//                    }   break;
//            }
//            sent1.close();   rst1.close();
//        } catch (Exception ex) {
//            Mensajes.mensajeError("Error al mostrar datos, en: " + ex.getMessage());
//        }
//    }
//
//    public static void Modifica_Elimina(int tipoMensaje, String sql) {
//        ver = 0;
//        PreparedStatement pat;
//        try {
//            pat = Acceso.cn.prepareStatement(sql);
//            ver = pat.executeUpdate();
//            if (ver <= 0) {
//                Mensajes.mensajeError("Ocurrió un problema con su consulta de modificación o eliminación.");
//            } else {
//                if (tipoMensaje == 0) 
//                    Mensajes.mensajeOK("Modificación completada.");
//                if (tipoMensaje == 1) 
//                    Mensajes.mensajeOK("Eliminación completada.");                
//            }
//            pat.close();
//        } catch (SQLException ex) {
//            Mensajes.mensajeError("Ocurrió un problema al modificar o eliminar datos. \n" + "Error en: " + ex.getMessage());
//        }
//    }
//    
//    public static void Ingresa(String sql, String[] array, boolean mensaje) {
//        ver = 0;
//        PreparedStatement pat;
//        try {
//            pat = Acceso.cn.prepareStatement(sql);
//            for (int i = 0; i < array.length; i++) {
//                pat.setString(i + 1, array[i]);
//            }
//            ver = pat.executeUpdate();
//            if (ver <= 0) {
//                Mensajes.mensajeError("No se pudo completar el ingreso de datos.");
//            } else {
//                if (mensaje == true) 
//                    Mensajes.mensajeOK("Ingreso completado correctamente.");                
//            }
//            pat.close();
//        } catch (SQLException ex) {
//           Mensajes.mensajeError("Error al ingresar datos en: " + ex.getMessage());
//        }
//    }    
//}
