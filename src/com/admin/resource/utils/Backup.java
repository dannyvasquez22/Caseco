package com.admin.resource.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Calendar;
import javax.swing.JFileChooser;

/** * @author DANNY VASQUEZ RAFAEL */

public class Backup {
    
    public static void makeBackup(JFileChooser chooser, int opcion) {
        Global.CALENDARY = Calendar.getInstance();
        String fecha = String.valueOf(Global.CALENDARY.get(Calendar.DATE));
        fecha = fecha + "-" + String.valueOf(Global.CALENDARY.get(Calendar.MONTH) + 1);
        fecha = fecha + "-" + String.valueOf(Global.CALENDARY.get(Calendar.YEAR));
        if (opcion == JFileChooser.APPROVE_OPTION) {
            try {
//                Runtime runtime = Runtime.getRuntime();
                File backupFile = new File(String.valueOf(chooser.getSelectedFile().toString()) + "_" + fecha + ".sql");
                InputStreamReader irs;
                BufferedReader br;
                try (FileWriter fw = new FileWriter(backupFile)) {
                    Process child = Runtime.getRuntime().exec("C:\\Program Files (x86)\\MySQL\\MySQL Workbench SE 6.0.9\\"+
                            "mysqldump.exe --host=localhost --port=3306 --user=root --password=1234 --compact --complete-insert --extended-insert --skip-quote-names" +
                            " --skip-comments --skip-triggers ferreteriadino");
                    Runtime.getRuntime().exec("C:\\Program Files (x86)\\MySQL\\MySQL Workbench SE 6.0.9\\" +
                            "mysqldump --opt -uroot -p1234 -B ferreteriadino -r" + String.valueOf(chooser.getSelectedFile().toString()) + "_" + fecha + ".sql");
                    irs = new InputStreamReader(child.getInputStream());
                    br = new BufferedReader(irs);
                    String line;
                    while ((line = br.readLine()) != null) {
                        fw.write(line + "\n");
                    }
                }
                irs.close();
                br.close();
            } catch (Exception e) {
                Messages.messageError("Error en: " + e.getMessage());
            }
            Messages.messageOK("Copia creada satisfactoriamente.");
        } else if (opcion == JFileChooser.CANCEL_OPTION) {
            Messages.messageAlert("Ha cancelado la creación del Backup.");
        }
    }
    
}
