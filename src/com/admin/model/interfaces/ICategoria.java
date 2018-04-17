package com.admin.model.interfaces;

import com.admin.model.dto.CategoriaDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface ICategoria {

    // Se considera INT el estado, debido a que podran ser 3 valores, 0 inactivos, 1 activos y 2 todos
    // Si no es necesario, se validara en la implementacion y sobrescritura del metodo.
    public int getElementChild(String nombre, int modeStatus) throws SQLException;
    public ArrayList<String> getNamesByCombo(int modeStatus) throws SQLException;
    
    // Se considero al inicio del modelo de datos, PK string y esta es modificable con frecuencia en el tiempo.
    // Se puede optimizar haciendo una PK int que no dependa de ningun cambio del cliente.
    public boolean updateExceptional(CategoriaDTO categoria, String nombreAnterior) throws SQLException;
    
}
