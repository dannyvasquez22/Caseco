package com.admin.resource.utils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;

/** * @author DANNY VASQUEZ RAFAEL */

public class Pagination {
    final static Logger logger = Logger.getLogger(Pagination.class);
    private static final Config dbInstance = Config.getInstance();
    private int numPage = 0;
    private int numPages = 0;
    private String[] columnames;
    private Object[][] data;
    
    /** * Paginacion
    * @param numRegPagina Numero de registros por pagina
    * @param numPage Numero de Pagina
    * @param query Consulta SQL
    * @return Matriz nxm con los registros que corresponde a Numero de Pagina dado por numPage   */ 
    public Object[][] getPagina(String query, int numPage, int numRegPagina) {        
        this.numPage = (numPage <= 1) ? 1 : numPage; //Numero de pagina 
        
        Statement st;
        ResultSet rs;
        try {
            st = dbInstance.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            st = dbInstance.getConnection().;
            rs = st.executeQuery(query);

            //Obtiene la cantidad total de registros en la tabla
            rs.last();
            int numReg = rs.getRow();            
            rs.first();         

            //calcula posicion de registro de inicio de paginacion
            int fila = numRegPagina * ( this.numPage - 1 ) + 1;           
            this.numPages = numReg / numRegPagina + ((numReg % numRegPagina > 0) ? 1 : 0);
            
            //obtencion de metadatos de la tabla
            //nombre de las columnas
            ResultSetMetaData md = rs.getMetaData();
            int numeroColumnas = md.getColumnCount();//numero de columnas de la tabla
            //recorre las columnas de la tabla y asigna a array de columnas
            columnames = new String[numeroColumnas];
            for (int i = 1; i <= numeroColumnas; i++) {                
                this.columnames[i - 1] = md.getColumnName(i);                
            }
                        
            //Inicia matriz para los registros
            this.data = new String[numRegPagina][numeroColumnas];
            int cont = 1;
            // Se mueve a la "fila" indicada y si hay datos llena la matriz con los registros
            if (rs.absolute( fila ) && numRegPagina > 0) {
                int f = 0;
                do {                    
                    for (int i = 1; i <= numeroColumnas; i++) {                        
                        data[f][i - 1] = rs.getString(i);
                    }                    
                    f++; cont++;
                }
                while ( rs.next() && ( cont <= numRegPagina ) );
            }                   
            
        } catch ( SQLException e ) {
            logger.error("Error: " + e.getMessage());
        }  
        
        return data;
    }

    /** * @return String[] Nombres de las columnas  */   
    public String[] ColumNames() {       
        return columnames;
    }
   
    /** * @return Numero de pagina actual de paginacion  */
    public int getNumPage() {
        return this.numPage;
    }
   
    /** *@return  Numero total de paginas  */
    public int getNumPages() {
        return this.numPages;
    }   
       
}
