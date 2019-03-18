package com.admin.controller.complements;

import com.admin.resource.utils.Global;
import com.admin.view.complements.ListPrinters;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import org.apache.log4j.Logger;

/** * @author DANNY VASQUEZ RAFAEL */

public class CListPrinters implements ActionListener {
    
    private final ListPrinters view_listPrinters;
    final static Logger logger = Logger.getLogger(CListPrinters.class);
    
    public CListPrinters (ListPrinters listPrinters) {
        this.view_listPrinters = listPrinters;
        this.view_listPrinters.btnEstablecer.addActionListener(this);
    }
    
    public void iniciar() {
        view_listPrinters.setResizable(false);
        view_listPrinters.setIconImage(Global.ICON_IMAGE);
        view_listPrinters.setCursor(Global.CURSOR);
        view_listPrinters.setTitle("Impresoras");
        listarImpresoras();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == view_listPrinters.btnEstablecer) {
            estableceImpresoraPredeterminada(view_listPrinters.comboImpresoras.getSelectedItem().toString());
            seleccionarImpresoraPredeterminada();
        }
    }
    
    private void seleccionarImpresoraPredeterminada() {
        PrintService service = PrintServiceLookup.lookupDefaultPrintService();
        if (service != null) {
            String printServiceName = service.getName();
            view_listPrinters.comboImpresoras.setSelectedItem(printServiceName);
            view_listPrinters.lblImpresora.setText(printServiceName);
        } else {
            view_listPrinters.comboImpresoras.setSelectedItem("Seleccionar impresoras");
        }
    }

    private void listarImpresoras() {
        PrintService[] ps = PrintServiceLookup.lookupPrintServices(null, null);
        view_listPrinters.comboImpresoras.addItem("Seleccionar impresoras");
        for (PrintService p : ps) {
            view_listPrinters.comboImpresoras.addItem(p.getName());
        }
    }

    @SuppressWarnings("CallToPrintStackTrace")
    private void estableceImpresoraPredeterminada(String printerName) {
        String cmdLine = String.format("RUNDLL32 PRINTUI.DLL,PrintUIEntry /y /n \"%s\"", printerName);
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", cmdLine);
        builder.redirectErrorStream(true);
        Process p = null;
        try {
            p = builder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        @SuppressWarnings("null")
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = new String();
        while (true) {
            try {
                line = r.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (line == null) {
                break;
            }
        }
    }
}
