package com.admin.resource.utils;

//import View.Main.Acceso;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException; 
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;

public class ExportExcelReport {
   String[] titulos;
   String[] titulos2;
   String nombre;
   String consulta;
   String consulta2;
   String consulta3;
   
    public ExportExcelReport(String[] titulos, String nombre, String consulta) {
        this.titulos = titulos;
        this.nombre = nombre;
        this.consulta = consulta;
    }

    public ExportExcelReport(String[] titulos, String nombre, String consulta, String consulta2) {
        this.titulos = titulos;
        this.nombre = nombre;
        this.consulta = consulta;
        this.consulta2 = consulta2;
    }

    public ExportExcelReport(String[] titulos, String[] titulos2, String consulta, String consulta2) {
        this.titulos = titulos;
        this.titulos2 = titulos2;
        this.consulta = consulta;
        this.consulta2 = consulta2;
    }

    public ExportExcelReport(String[] titulos, String nombre, String consulta, String consulta2, String consulta3) {
        this.titulos = titulos;
        this.nombre = nombre;
        this.consulta = consulta;
        this.consulta2 = consulta2;
        this.consulta3 = consulta3;
    }
    
    public void abrir(){
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + this.nombre);
        } catch (Exception e) {
            System.out.println("No se logro abrir el archivo.");
        }
    }
    
    public void reportePorMes(String Comprobante){
        try{
            int fila = 0;
            double total = 0;
//            Statement statement = Acceso.cn.createStatement();
            Statement statement = null;
            FileOutputStream fileOut;
            fileOut = new FileOutputStream(nombre);
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet worsheet = workbook.createSheet("Sheet 0");
            Font fuente = workbook.createFont();
            fuente.setFontName("Courier New");
            fuente.setFontHeightInPoints((short)11);
            fuente.setBoldweight(Font.BOLDWEIGHT_BOLD);
            fuente.setColor(IndexedColors.WHITE.getIndex());
            CellStyle estiloCelda = workbook.createCellStyle();
            estiloCelda.setWrapText(true);
            estiloCelda.setAlignment(CellStyle.ALIGN_CENTER);
            estiloCelda.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
            estiloCelda.setFont(fuente);
            estiloCelda.setFillBackgroundColor(IndexedColors.BLUE_GREY.getIndex());
            estiloCelda.setFillPattern(CellStyle.SOLID_FOREGROUND);
            Row row1 = worsheet.createRow((short)0);
            Cell ti = row1.createCell(0);
            ti.setCellValue(Comprobante);
            ti.setCellStyle(estiloCelda);
            ti.setCellType(Cell.CELL_TYPE_STRING);
            row1 = worsheet.createRow((short)1);
            fila++;
            for(int i = 0;i < this.titulos.length; i++){
                Cell celda = row1.createCell(i);
                celda.setCellValue(this.titulos[i]);
                celda.setCellStyle(estiloCelda);
                celda.setCellType(Cell.CELL_TYPE_STRING);
            }
            Row row2;
            ResultSet rs = statement.executeQuery(this.consulta);
            int a = fila + 1;
            while(rs.next()){
                row2 = worsheet.createRow((short)a);
                for(int i = 0;i < this.titulos.length; i++){
                        if(i == this.titulos.length - 1){
                        row2.createCell(i).setCellValue(rs.getDouble(i+1));
                        total = rs.getDouble(i+1) + total;
                    }else{
                       row2.createCell(i).setCellValue(rs.getString(i+1));
                    }
                }
                fila++;
                a++;
            }
            row2 = worsheet.createRow((short)fila+2);
            fila++;
            for(int i = 0; i < this.titulos.length; i++){
                if(i == this.titulos.length - 2){
                   Cell cel = row2.createCell(i);
                   cel.setCellValue("Total");
                   cel.setCellStyle(estiloCelda);
                   cel.setCellType(Cell.CELL_TYPE_STRING);
                }else{
                    if(i == this.titulos.length - 1){
                        row2.createCell(i).setCellValue(total);
                    }else{
                        row2.createCell(i).setCellValue("");
                    }
                }
            }            
            
            for (int i = 0; i < fila+1; i++) {
                worsheet.autoSizeColumn((short)i);
            }
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();
            rs.close();
            statement.close();
        }catch(SQLException ex){
            System.out.println(ex);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
       } catch (IOException ex) {
            System.out.println(ex);
       }     
    }
    
    private static double leyRendondeo(double valor, int decimal){
        double valorRen = 0;
        int i = 0,j = 0,k = 0, l = 0, r = 0;
        char cadNum[] = Double.toString(valor).toCharArray();
        
        String partEnt="";
        for(i = 0;i < cadNum.length;i++){ if(cadNum[i] == 46){ k = i + 1; break;} else{ partEnt = partEnt + cadNum[i]; } }
        
        int digitos[] = new int[decimal + 1];
        j = 0;
        for(i = k;i < k + (decimal + 1) && i < cadNum.length;i++){
            digitos[j] = Integer.parseInt(cadNum[i] + "");
            j++;
        }
        
        if(j == decimal + 1){
            String result = "";
            if(digitos[decimal] == 9){ 
                result = partEnt + ".";
                for(i = decimal - 1; i > -1; i--){
                    digitos[i] = digitos[i] + 1;
                    if(digitos[i] == 10){ digitos[i] = 0; }
                    if(digitos[0] == 0 && i == 0){
                        result = "";
                        int digAux[] = new int[k - 1];
                        r = 0;

                        for(l = 0;l < k - 1;l++){
                            digAux[r] = Integer.parseInt(cadNum[l] + "");
                            r++;
                        }

                        for(l = r - 1;l > -1;l--){
                            digAux[l] = digAux[l] + 1;
                            if(digAux[l] == 10){ digAux[l] = 0; }
                            if(digAux[l] == 0){ result = "1"; }
                            if(digAux[l] < 10 && digAux[l] > 0){
                                result = "";
                                break; 
                            }
                        }

                        for(l = 0;l < r; l++){ result = result + digAux[l]; }
                        result = result + ".";  
                    }
                    if(digitos[i] < 10 && digitos[i] > 0){ break; }
                } 
            }
            if(digitos[decimal] > 5 && digitos[decimal] < 9){ 
                result = partEnt + ".";
                for(i = decimal - 1; i > -1; i--){
                    digitos[i] = digitos[i] + 1;
                    if(digitos[i] == 10){ digitos[i] = 0; }
                    if(digitos[0] == 0 && i == 0){
                        result = "";
                        int digAux[] = new int[k - 1];
                        r = 0;

                        for(l = 0;l < k - 1;l++){
                            digAux[r] = Integer.parseInt(cadNum[l] + "");
                            r++;
                        }

                        for(l = r - 1;l > -1;l--){
                            digAux[l] = digAux[l] + 1;
                            if(digAux[l] == 10){ digAux[l] = 0; }
                            if(digAux[l] == 0){ result = "1"; }
                            if(digAux[l] < 10 && digAux[l] > 0){
                                result = "";
                                break; 
                            }
                        }

                        for(l = 0;l < r; l++){ result = result + digAux[l]; }
                        result = result + ".";  
                    }
                    if(digitos[i] < 10 && digitos[i] > 0){ break; }
                }
            }
            if(digitos[decimal] == 5){ 
                result = partEnt + ".";
                if(digitos[decimal - 1] == 0){ 
                    for(i = decimal - 1; i > -1; i--){
                        digitos[i] = digitos[i] + 1;
                        if(digitos[i] == 10){ digitos[i] = 0; }
                        if(digitos[0] == 0 && i == 0){
                            result = "";
                            int digAux[] = new int[k - 1];
                            r = 0;

                            for(l = 0;l < k - 1;l++){
                                digAux[r] = Integer.parseInt(cadNum[l] + "");
                                r++;
                            }

                            for(l = r - 1;l > -1;l--){
                                digAux[l] = digAux[l] + 1;
                                if(digAux[l] == 10){ digAux[l] = 0; }
                                if(digAux[l] == 0){ result = "1"; }
                                if(digAux[l] < 10 && digAux[l] > 0){
                                    result = "";
                                    break; 
                                }
                            }

                            for(l = 0;l < r; l++){ result = result + digAux[l]; }
                            result = result + ".";  
                        }
                        if(digitos[i] < 10 && digitos[i] > 0){ break; }
                    } 
                }
                else{ 
                    if((digitos[decimal - 1] % 2) > 0){ 
                        for(i = decimal - 1; i > -1; i--){
                            digitos[i] = digitos[i] + 1;
                            if(digitos[i] == 10){ digitos[i] = 0; }
                            if(digitos[0] == 0 && i == 0){
                                result = "";
                                int digAux[] = new int[k - 1];
                                r = 0;

                                for(l = 0;l < k - 1;l++){
                                    digAux[r] = Integer.parseInt(cadNum[l] + "");
                                    r++;
                                }

                                for(l = r - 1;l > -1;l--){
                                    digAux[l] = digAux[l] + 1;
                                    if(digAux[l] == 10){ digAux[l] = 0; }
                                    if(digAux[l] == 0){ result = "1"; }
                                    if(digAux[l] < 10 && digAux[l] > 0){
                                        result = "";
                                        break; 
                                    }
                                }

                                for(l = 0;l < r; l++){ result = result + digAux[l]; }
                                result = result + ".";  
                            }
                            if(digitos[i] < 10 && digitos[i] > 0){ break; }
                        }
                    }
                }
            } 
            if(digitos[decimal] < 5){ result = partEnt + "."; }
            
            for(i = 0;i < decimal; i++){ result = result + digitos[i]; }
            
            valorRen = Double.parseDouble(result);
        } else{ valorRen = valor; }
        
        return valorRen;
    }
    
    public void reportePorMesContable(){
        try{
            int nrofila = 1;
            int fila = 0;
//            Statement statement = Acceso.cn.createStatement();
            Statement statement = null;
            FileOutputStream fileOut;
            fileOut = new FileOutputStream(nombre);
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet worsheet = workbook.createSheet("Sheet 0");
            Font fuente = workbook.createFont();
            fuente.setFontName("Calibri");
            fuente.setFontHeightInPoints((short)8);
            fuente.setColor(IndexedColors.BLACK.getIndex());
            CellStyle estiloCelda = workbook.createCellStyle();
            CellStyle estiloCelda2 = workbook.createCellStyle();
            CellStyle estiloCelda3 = workbook.createCellStyle();
            estiloCelda.setWrapText(true);
            estiloCelda.setAlignment(CellStyle.ALIGN_CENTER);
            estiloCelda.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
            estiloCelda.setFont(fuente);
            estiloCelda2.setFont(fuente);
            estiloCelda3.setFont(fuente);
            estiloCelda3.setFillBackgroundColor(IndexedColors.YELLOW.getIndex());
            estiloCelda3.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
            estiloCelda.setFillBackgroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            estiloCelda.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            estiloCelda3.setFillPattern(CellStyle.SOLID_FOREGROUND);
            estiloCelda.setFillPattern(CellStyle.SOLID_FOREGROUND);
            Row row1 = worsheet.createRow((short)0);
            for(int i = 0; i < this.titulos.length; i++){
                Cell celda = row1.createCell(i);
                celda.setCellValue(this.titulos[i]);
                celda.setCellStyle(estiloCelda);
                celda.setCellType(Cell.CELL_TYPE_STRING);
            }
            Row row2;
            ResultSet rs = statement.executeQuery(this.consulta);
            int a = fila + 1;
            int k = 0;
            while(rs.next()){
                row2 = worsheet.createRow((short)a);
                for(int i = 0;i < this.titulos.length; i++){
                    if(i == 0){
                        Cell celda = row2.createCell(i);
                        celda.setCellValue(nrofila);
                        celda.setCellStyle(estiloCelda2);
                        nrofila++;
                    }
                    if(i == 2){
                        Cell celda = row2.createCell(i);
                        celda.setCellValue(2);
                        celda.setCellStyle(estiloCelda2);
                    }
                    if(i == 10){
                        if(rs.getInt(7) == 0){
                            Cell celda = row2.createCell(i);
                            celda.setCellValue(2);
                            celda.setCellStyle(estiloCelda2);
                        }else{
                            Cell celda = row2.createCell(i);
                            celda.setCellValue(1);
                            celda.setCellStyle(estiloCelda2);
                        }
                    }
                    if(i == 9){
                        if(rs.getInt(7) == 0){
                            Cell celda = row2.createCell(i);
                            celda.setCellValue(0.00);
                            celda.setCellStyle(estiloCelda2);
                            
                            celda = row2.createCell(i-1);
                            celda.setCellValue(0.00);
                            celda.setCellStyle(estiloCelda2);
                            
                            celda = row2.createCell(i-2);
                            celda.setCellValue(0.00);
                            celda.setCellStyle(estiloCelda2);
                        }else{
                            Cell celda = row2.createCell(i);
                            celda.setCellValue(rs.getDouble(6));
                            celda.setCellStyle(estiloCelda2);
                            
                            double valorIgv = (rs.getDouble(8) / 100) + 1;
                           
                            double imp = rs.getDouble(6) / valorIgv;
                            imp = leyRendondeo(imp,2);
                            
                            celda = row2.createCell(i-2);
                            celda.setCellValue(imp);
                            celda.setCellStyle(estiloCelda2);
                            
                            double igv = rs.getDouble(6) - imp;
                            igv = leyRendondeo(igv,2);
                            
                            celda = row2.createCell(i-1);
                            celda.setCellValue(igv);
                            celda.setCellStyle(estiloCelda2);
                        }
                    }else{
                        if(i == 1){
                            Cell celda = row2.createCell(i);
                            celda.setCellValue(rs.getString(i));
                            celda.setCellStyle(estiloCelda2);
                        }
                        if(i > 2 && i < 7){
                            Cell celda = row2.createCell(i);
                            celda.setCellValue(rs.getString(i-1));
                            celda.setCellStyle(estiloCelda2);
                        }
                    }
                }
                a++;
            }
            k = 0;
            ResultSet rs1 = statement.executeQuery(this.consulta2);
            while(rs1.next()){
                row2 = worsheet.createRow((short)a);
                for(int i = 0;i < this.titulos.length; i++){
                    if(i == 0){
                        Cell celda = row2.createCell(i);
                        celda.setCellValue(nrofila);
                        celda.setCellStyle(estiloCelda2);
                        nrofila++;
                    }
                    if(i == 2){
                        Cell celda = row2.createCell(i);
                        celda.setCellValue(1);
                        celda.setCellStyle(estiloCelda2);
                    }
                    if(i == 10){
                        if(rs1.getInt(7) == 0){
                            Cell celda = row2.createCell(i);
                            celda.setCellValue(2);
                            celda.setCellStyle(estiloCelda2);
                        }else{
                            Cell celda = row2.createCell(i);
                            celda.setCellValue(1);
                            celda.setCellStyle(estiloCelda2);
                        }
                    }
                    if(i == 9){
                        if(rs1.getInt(7) == 0){
                            Cell celda = row2.createCell(i);
                            celda.setCellValue(0.00);
                            celda.setCellStyle(estiloCelda2);
                            
                            celda = row2.createCell(i-1);
                            celda.setCellValue(0.00);
                            celda.setCellStyle(estiloCelda2);
                            
                            celda = row2.createCell(i-2);
                            celda.setCellValue(0.00);
                            celda.setCellStyle(estiloCelda2);
                        }else{
                            Cell celda = row2.createCell(i);
                            celda.setCellValue(rs1.getDouble(6));
                            celda.setCellStyle(estiloCelda2);
                            
                            double valorIgv = (rs1.getDouble(8) / 100) + 1;
                           
                            double imp = rs1.getDouble(6) / valorIgv;
                            imp = leyRendondeo(imp,2);
                            
                            celda = row2.createCell(i-2);
                            celda.setCellValue(imp);
                            celda.setCellStyle(estiloCelda2);
                            
                            double igv = rs1.getDouble(6) - imp;
                            igv = leyRendondeo(igv,2);
                            
                            celda = row2.createCell(i-1);
                            celda.setCellValue(igv);
                            celda.setCellStyle(estiloCelda2);
                        }
                    }else{
                        if(i == 1){
                            Cell celda = row2.createCell(i);
                            celda.setCellValue(rs1.getString(i));
                            celda.setCellStyle(estiloCelda2);
                        }
                        if(i > 2 && i < 7){
                            if(i == 5 || i == 6){
                                if(rs1.getString(i-1) != null){
                                    Cell celda = row2.createCell(i);
                                    celda.setCellValue(rs1.getString(i-1));
                                    celda.setCellStyle(estiloCelda2);
                                } else{
                                    Cell celda = row2.createCell(i);
                                    celda.setCellValue("-");
                                    celda.setCellStyle(estiloCelda2);
                                }
                            }
                            else{
                                Cell celda = row2.createCell(i);
                                celda.setCellValue(rs1.getString(i-1));
                                celda.setCellStyle(estiloCelda2);
                            }
                        }
                    }
                }
                a++;
            }
            
            row2 = worsheet.createRow((short)a);
            Cell celda = row2.createCell(2);
            celda.setCellValue("1:BOLETA");
            celda.setCellStyle(estiloCelda3);
            celda = row2.createCell(10);
            celda.setCellValue("1:CANCELADO");
            celda.setCellStyle(estiloCelda3);
            row2 = worsheet.createRow((short)a+1);
            celda = row2.createCell(2);
            celda.setCellValue("2:FACTURA");
            celda.setCellStyle(estiloCelda3);
            celda = row2.createCell(10);
            celda.setCellValue("2:ANULADO");
            celda.setCellStyle(estiloCelda2); 
            row2 = worsheet.createRow((short)a+2);
            celda = row2.createCell(2);
            celda.setCellValue("3:NOTA CREDITO");
            celda.setCellStyle(estiloCelda2); 
            
            for (int i = 0; i < a+1; i++) {
                worsheet.autoSizeColumn((short)i);
            }
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();
            rs.close();
            rs1.close();
            statement.close();
        }catch(SQLException ex){
            System.out.println(ex);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
       } catch (IOException ex) {
            System.out.println(ex);
       }     
    }

    
    public void reportePorFecha(String nombreTienda){
        try{
            int fila = 0;
            double total = 0;
//            Statement statement = Acceso.cn.createStatement();
            Statement statement = null;
            FileOutputStream fileOut;
            fileOut = new FileOutputStream(nombre);
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet worsheet = workbook.createSheet("Sheet 0");
            Font fuente = workbook.createFont();
            fuente.setFontName("Courier New");
            fuente.setFontHeightInPoints((short)11);
            fuente.setBoldweight(Font.BOLDWEIGHT_BOLD);
            fuente.setColor(IndexedColors.WHITE.getIndex());
            CellStyle estiloCelda = workbook.createCellStyle();
            estiloCelda.setWrapText(true);
            estiloCelda.setAlignment(CellStyle.ALIGN_CENTER);
            estiloCelda.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
            estiloCelda.setFont(fuente);
            estiloCelda.setFillBackgroundColor(IndexedColors.BLUE_GREY.getIndex());
            estiloCelda.setFillPattern(CellStyle.SOLID_FOREGROUND);
            Row row1 = worsheet.createRow((short)0);
            Cell t0 = row1.createCell(0);
            t0.setCellValue("Tienda");
            t0.setCellStyle(estiloCelda);
            t0.setCellType(Cell.CELL_TYPE_STRING);
            row1.createCell(1).setCellValue(nombreTienda);
            fila = fila + 3;
            row1 = worsheet.createRow((short)3);
            Cell ti = row1.createCell(0);
            ti.setCellValue("Boleta");
            ti.setCellStyle(estiloCelda);
            ti.setCellType(Cell.CELL_TYPE_STRING);
            row1 = worsheet.createRow((short)4);
            fila++;
            for(int i = 0;i < this.titulos.length;i++){
                Cell celda = row1.createCell(i);
                celda.setCellValue(this.titulos[i]);
                celda.setCellStyle(estiloCelda);
                celda.setCellType(Cell.CELL_TYPE_STRING);
            }
            Row row2;
            ResultSet rs = statement.executeQuery(this.consulta);
            int a = fila + 1;
            while(rs.next()){
                row2 = worsheet.createRow((short)a);
                for(int i = 0;i < this.titulos.length; i++){                   
                    if(i == 0){
                        if("1".equals(rs.getString(i+1))){row2.createCell(i).setCellValue("Enero");}
                        if("2".equals(rs.getString(i+1))){row2.createCell(i).setCellValue("Febrero");}
                        if("3".equals(rs.getString(i+1))){row2.createCell(i).setCellValue("Marzo");}
                        if("4".equals(rs.getString(i+1))){row2.createCell(i).setCellValue("Abril");}
                        if("5".equals(rs.getString(i+1))){row2.createCell(i).setCellValue("Mayo");}
                        if("6".equals(rs.getString(i+1))){row2.createCell(i).setCellValue("Junio");}
                        if("7".equals(rs.getString(i+1))){row2.createCell(i).setCellValue("Julio");}
                        if("8".equals(rs.getString(i+1))){row2.createCell(i).setCellValue("Agosto");}
                        if("9".equals(rs.getString(i+1))){row2.createCell(i).setCellValue("Setiembre");}
                        if("10".equals(rs.getString(i+1))){row2.createCell(i).setCellValue("Octubre");}
                        if("11".equals(rs.getString(i+1))){row2.createCell(i).setCellValue("Noviembre");}
                        if("12".equals(rs.getString(i+1))){row2.createCell(i).setCellValue("Diciembre");}
                    }else{
                        if(i == this.titulos.length - 1){
                            row2.createCell(i).setCellValue(rs.getDouble(i+1));
                            total = rs.getDouble(i+1) + total;
                        }else{
                           row2.createCell(i).setCellValue(rs.getString(i+1));
                        }
                    }
                }
                fila++;
                a++;
            }
            row2 = worsheet.createRow((short)fila+2);
            fila++;
            for(int i = 0; i < this.titulos.length; i++){
                if(i == this.titulos.length - 2){
                   Cell cel = row2.createCell(i);
                   cel.setCellValue("Total");
                   cel.setCellStyle(estiloCelda);
                   cel.setCellType(Cell.CELL_TYPE_STRING);
                }else{
                    if(i == this.titulos.length - 1){
                        row2.createCell(i).setCellValue(total);
                    }else{
                        row2.createCell(i).setCellValue("");
                    }
                }
            }
            
            fila = fila + 2;
            row1 = worsheet.createRow((short)fila+1);
            ti = row1.createCell(0);
            ti.setCellValue("Factura");
            ti.setCellStyle(estiloCelda);
            ti.setCellType(Cell.CELL_TYPE_STRING);
            
            row1 = worsheet.createRow((short)fila+2);
            for(int i = 0;i < this.titulos.length;i++){
                Cell celda = row1.createCell(i);
                celda.setCellValue(this.titulos[i]);
                celda.setCellStyle(estiloCelda);
                celda.setCellType(Cell.CELL_TYPE_STRING);
            }
            total = 0;
            ResultSet rs1 = statement.executeQuery(this.consulta2);
            a = fila + 3;
            while(rs1.next()){     
                row2 = worsheet.createRow((short)a);
                for(int i = 0;i < this.titulos.length; i++){
                    if(i == 0){
                        if("1".equals(rs1.getString(i+1))){row2.createCell(i).setCellValue("Enero");}
                        if("2".equals(rs1.getString(i+1))){row2.createCell(i).setCellValue("Febrero");}
                        if("3".equals(rs1.getString(i+1))){row2.createCell(i).setCellValue("Marzo");}
                        if("4".equals(rs1.getString(i+1))){row2.createCell(i).setCellValue("Abril");}
                        if("5".equals(rs1.getString(i+1))){row2.createCell(i).setCellValue("Mayo");}
                        if("6".equals(rs1.getString(i+1))){row2.createCell(i).setCellValue("Junio");}
                        if("7".equals(rs1.getString(i+1))){row2.createCell(i).setCellValue("Julio");}
                        if("8".equals(rs1.getString(i+1))){row2.createCell(i).setCellValue("Agosto");}
                        if("9".equals(rs1.getString(i+1))){row2.createCell(i).setCellValue("Setiembre");}
                        if("10".equals(rs1.getString(i+1))){row2.createCell(i).setCellValue("Octubre");}
                        if("11".equals(rs1.getString(i+1))){row2.createCell(i).setCellValue("Noviembre");}
                        if("12".equals(rs1.getString(i+1))){row2.createCell(i).setCellValue("Diciembre");}
                    }else{
                        if(i == this.titulos.length - 1){
                            row2.createCell(i).setCellValue(rs1.getDouble(i+1));
                            total = rs1.getDouble(i+1) + total;
                        }else{
                           row2.createCell(i).setCellValue(rs1.getString(i+1));
                        }
                    }
                }
                fila++;
                a++;
            }
            row2 = worsheet.createRow((short)fila+4);
            for(int i = 0; i < this.titulos.length; i++){
                if(i == this.titulos.length - 2){
                   Cell cel = row2.createCell(i);
                   cel.setCellValue("Total");
                   cel.setCellStyle(estiloCelda);
                   cel.setCellType(Cell.CELL_TYPE_STRING);
                }else{
                    if(i == this.titulos.length - 1){
                        row2.createCell(i).setCellValue(total);
                    }else{
                        row2.createCell(i).setCellValue("");
                    }
                }
            }           
            //Ticket
            fila = fila + 2;
            row1 = worsheet.createRow((short)fila+1);
            ti = row1.createCell(0);
            ti.setCellValue("Ticket");
            ti.setCellStyle(estiloCelda);
            ti.setCellType(Cell.CELL_TYPE_STRING);
            
            row1 = worsheet.createRow((short)fila+2);
            for(int i = 0;i < this.titulos.length;i++){
                Cell celda = row1.createCell(i);
                celda.setCellValue(this.titulos[i]);
                celda.setCellStyle(estiloCelda);
                celda.setCellType(Cell.CELL_TYPE_STRING);
            }
            total = 0;
            ResultSet rs2 = statement.executeQuery(this.consulta2);
            a = fila + 3;
            while(rs2.next()){     
                row2 = worsheet.createRow((short)a);
                for(int i = 0;i < this.titulos.length; i++){
                    if(i == 0){
                        if("1".equals(rs2.getString(i+1))){row2.createCell(i).setCellValue("Enero");}
                        if("2".equals(rs2.getString(i+1))){row2.createCell(i).setCellValue("Febrero");}
                        if("3".equals(rs2.getString(i+1))){row2.createCell(i).setCellValue("Marzo");}
                        if("4".equals(rs2.getString(i+1))){row2.createCell(i).setCellValue("Abril");}
                        if("5".equals(rs2.getString(i+1))){row2.createCell(i).setCellValue("Mayo");}
                        if("6".equals(rs2.getString(i+1))){row2.createCell(i).setCellValue("Junio");}
                        if("7".equals(rs2.getString(i+1))){row2.createCell(i).setCellValue("Julio");}
                        if("8".equals(rs2.getString(i+1))){row2.createCell(i).setCellValue("Agosto");}
                        if("9".equals(rs2.getString(i+1))){row2.createCell(i).setCellValue("Setiembre");}
                        if("10".equals(rs2.getString(i+1))){row2.createCell(i).setCellValue("Octubre");}
                        if("11".equals(rs2.getString(i+1))){row2.createCell(i).setCellValue("Noviembre");}
                        if("12".equals(rs2.getString(i+1))){row2.createCell(i).setCellValue("Diciembre");}
                    }else{
                        if(i == this.titulos.length - 1){
                            row2.createCell(i).setCellValue(rs2.getDouble(i+1));
                            total = rs2.getDouble(i+1) + total;
                        }else{
                           row2.createCell(i).setCellValue(rs2.getString(i+1));
                        }
                    }
                }
                fila++;
                a++;
            }
            row2 = worsheet.createRow((short)fila+4);
            for(int i = 0; i < this.titulos.length; i++){
                if(i == this.titulos.length - 2){
                   Cell cel = row2.createCell(i);
                   cel.setCellValue("Total");
                   cel.setCellStyle(estiloCelda);
                   cel.setCellType(Cell.CELL_TYPE_STRING);
                }else{
                    if(i == this.titulos.length - 1){
                        row2.createCell(i).setCellValue(total);
                    }else{
                        row2.createCell(i).setCellValue("");
                    }
                }
            }
            
            for (int i = 0; i < fila+1; i++) {
                worsheet.autoSizeColumn((short)i);
            }
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();
            rs.close();
            rs1.close();
            rs2.close();
            statement.close();
        }catch(SQLException ex){
            System.out.println(ex);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
       } catch (IOException ex) {
            System.out.println(ex);
       }           
    }
    
    public void reporteVenta(){
        try{
            int fila = 0;
            double total = 0;
//            Statement statement = Acceso.cn.createStatement();
            Statement statement = null;
            FileOutputStream fileOut;
            fileOut = new FileOutputStream(nombre);
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet worsheet = workbook.createSheet("Sheet 0");
            Font fuente = workbook.createFont();
            fuente.setFontName("Courier New");
            fuente.setFontHeightInPoints((short)11);
            fuente.setBoldweight(Font.BOLDWEIGHT_BOLD);
            fuente.setColor(IndexedColors.WHITE.getIndex());
            CellStyle estiloCelda = workbook.createCellStyle();
            estiloCelda.setWrapText(true);
            estiloCelda.setAlignment(CellStyle.ALIGN_CENTER);
            estiloCelda.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
            estiloCelda.setFont(fuente);
            estiloCelda.setFillBackgroundColor(IndexedColors.BLUE_GREY.getIndex());
            estiloCelda.setFillPattern(CellStyle.SOLID_FOREGROUND);
            Row row1 = worsheet.createRow((short)0);
            Cell ti = row1.createCell(0);
            ti.setCellValue("Boleta");
            ti.setCellStyle(estiloCelda);
            ti.setCellType(Cell.CELL_TYPE_STRING);
            row1 = worsheet.createRow((short)1);
            fila++;
            for(int i = 0;i < this.titulos.length;i++){
                Cell celda = row1.createCell(i);
                celda.setCellValue(this.titulos[i]);
                celda.setCellStyle(estiloCelda);
                celda.setCellType(Cell.CELL_TYPE_STRING);
            }
            Row row2;
            ResultSet rs = statement.executeQuery(this.consulta);
            int a = fila + 1;
            while(rs.next()){
                row2 = worsheet.createRow((short)a);
                for(int i = 0;i < this.titulos.length; i++){
                    if(i == this.titulos.length - 1){
                        row2.createCell(i).setCellValue(rs.getDouble(i+1));
                        total = rs.getDouble(i+1) + total;
                    }else{
                       row2.createCell(i).setCellValue(rs.getString(i+1));
                    }
                }
                fila++;
                a++;
            }
            row2 = worsheet.createRow((short)fila+2);
            fila++;
            for(int i = 0; i < this.titulos.length; i++){
                if(i == this.titulos.length - 2){
                   Cell cel = row2.createCell(i);
                   cel.setCellValue("Total");
                   cel.setCellStyle(estiloCelda);
                   cel.setCellType(Cell.CELL_TYPE_STRING);
                }else{
                    if(i == this.titulos.length - 1){
                        row2.createCell(i).setCellValue(total);
                    }else{
                        row2.createCell(i).setCellValue("");
                    }
                }
            }
            
            fila = fila + 2;
            row1 = worsheet.createRow((short)fila+1);
            ti = row1.createCell(0);
            ti.setCellValue("Factura");
            ti.setCellStyle(estiloCelda);
            ti.setCellType(Cell.CELL_TYPE_STRING);
            
            row1 = worsheet.createRow((short)fila+2);
            for(int i = 0;i < this.titulos.length;i++){
                Cell celda = row1.createCell(i);
                celda.setCellValue(this.titulos[i]);
                celda.setCellStyle(estiloCelda);
                celda.setCellType(Cell.CELL_TYPE_STRING);
            }
            total = 0;
            ResultSet rs1 = statement.executeQuery(this.consulta2);
            a = fila + 3;
            while(rs1.next()){        
                row2 = worsheet.createRow((short)a);
                for(int i = 0;i < this.titulos.length; i++){                 
                    if(i == this.titulos.length - 1){
                        row2.createCell(i).setCellValue(rs1.getDouble(i+1));
                        total = rs1.getDouble(i+1) + total;
                    }else{
                       row2.createCell(i).setCellValue(rs1.getString(i+1));
                    }
                }
                fila++;
                a++;
            }
            row2 = worsheet.createRow((short)fila+4);
            for(int i = 0; i < this.titulos.length; i++){
                if(i == this.titulos.length - 2){
                   Cell cel = row2.createCell(i);
                   cel.setCellValue("Total");
                   cel.setCellStyle(estiloCelda);
                   cel.setCellType(Cell.CELL_TYPE_STRING);
                }else{
                    if(i == this.titulos.length - 1){
                        row2.createCell(i).setCellValue(total);
                    }else{
                        row2.createCell(i).setCellValue("");
                    }
                }
            }       
            
            //Ticket
            fila = fila + 4;
            row1 = worsheet.createRow((short)fila+1);
            ti = row1.createCell(0);
            ti.setCellValue("Ticket");
            ti.setCellStyle(estiloCelda);
            ti.setCellType(Cell.CELL_TYPE_STRING);
            
            row1 = worsheet.createRow((short)fila+2);
            for(int i = 0;i < this.titulos.length;i++){
                Cell celda = row1.createCell(i);
                celda.setCellValue(this.titulos[i]);
                celda.setCellStyle(estiloCelda);
                celda.setCellType(Cell.CELL_TYPE_STRING);
            }
            total = 0;
            ResultSet rs2 = statement.executeQuery(this.consulta3);
            a = fila + 3;
            while(rs2.next()){        
                row2 = worsheet.createRow((short)a);
                for(int i = 0;i < this.titulos.length; i++){                 
                    if(i == this.titulos.length - 1){
                        row2.createCell(i).setCellValue(rs2.getDouble(i+1));
                        total = rs2.getDouble(i+1) + total;
                    }else{
                       row2.createCell(i).setCellValue(rs2.getString(i+1));
                    }
                }
                fila++;
                a++;
            }
            row2 = worsheet.createRow((short)fila+4);
            for(int i = 0; i < this.titulos.length; i++){
                if(i == this.titulos.length - 2){
                   Cell cel = row2.createCell(i);
                   cel.setCellValue("Total");
                   cel.setCellStyle(estiloCelda);
                   cel.setCellType(Cell.CELL_TYPE_STRING);
                }else{
                    if(i == this.titulos.length - 1){
                        row2.createCell(i).setCellValue(total);
                    }else{
                        row2.createCell(i).setCellValue("");
                    }
                }
            } 
            
            for (int i = 0; i < fila+1; i++) {
                worsheet.autoSizeColumn((short)i);
            }
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();
            rs.close();
            rs1.close();
            rs2.close();
            statement.close();
        }catch(SQLException ex){
            System.out.println(ex);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
       } catch (IOException ex) {
            System.out.println(ex);
       }        
    }
    
    public void reporte(){
        try{
            int fila = 0;
            double total = 0;
//            Statement statement = Acceso.cn.createStatement();
            Statement statement = null;
            FileOutputStream fileOut;
            fileOut = new FileOutputStream(nombre);
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet worsheet = workbook.createSheet("Sheet 0");
            Row row1 = worsheet.createRow((short)0);
            Font fuente = workbook.createFont();
            fuente.setFontName("Courier New");
            fuente.setFontHeightInPoints((short)11);
            fuente.setBoldweight(Font.BOLDWEIGHT_BOLD);
            fuente.setColor(IndexedColors.WHITE.getIndex());
            CellStyle estiloCelda = workbook.createCellStyle();
            estiloCelda.setWrapText(true);
            estiloCelda.setAlignment(CellStyle.ALIGN_CENTER);
            estiloCelda.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
            estiloCelda.setFont(fuente);
            estiloCelda.setFillBackgroundColor(IndexedColors.BLUE_GREY.getIndex());
            estiloCelda.setFillPattern(CellStyle.SOLID_FOREGROUND);
            for(int i = 0;i < this.titulos.length;i++){
                Cell celda = row1.createCell(i);
                celda.setCellValue(this.titulos[i]);
                celda.setCellStyle(estiloCelda);
                celda.setCellType(Cell.CELL_TYPE_STRING);
            }
            Row row2;
            ResultSet rs = statement.executeQuery(this.consulta);
            while(rs.next()){
                int a = rs.getRow();
                row2 = worsheet.createRow((short)a);
                for(int i = 0;i < this.titulos.length; i++){
                    row2.createCell(i).setCellValue(rs.getString(i+1));
                }
                fila++;
            }
            for (int i = 0; i < fila+1; i++) {
                worsheet.autoSizeColumn((short)i);
            }
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();
            rs.close();
            statement.close();
        }catch(SQLException ex){
            System.out.println(ex);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
       } catch (IOException ex) {
            System.out.println(ex);
       }
    }
}

