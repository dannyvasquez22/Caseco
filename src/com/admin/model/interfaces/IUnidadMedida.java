package com.admin.model.interfaces;

import com.admin.model.dto.UnidadMedidaDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IUnidadMedida {

    public UnidadMedidaDTO getById(String nombre) throws SQLException;
    public ArrayList<UnidadMedidaDTO> getAll(String nombre) throws SQLException;
    public ArrayList<String> getNamesByCombo() throws SQLException;
    public int getElementChild(String nombre) throws SQLException;
    public boolean updateUnidadMedida(UnidadMedidaDTO unidad, String nombreAnterior) throws SQLException;
    public boolean insertUnidadMedida(UnidadMedidaDTO unida) throws SQLException;
    public boolean deleteUnidadMedida(UnidadMedidaDTO unidad) throws SQLException;
    
}
