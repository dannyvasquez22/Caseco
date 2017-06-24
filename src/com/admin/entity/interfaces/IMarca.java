package com.admin.entity.interfaces;

import com.admin.entity.dto.MarcaDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IMarca {

    public MarcaDTO getById(String nombre) throws SQLException;
    public ArrayList<MarcaDTO> getAll(String nombre) throws SQLException;
    public boolean updateMarca(MarcaDTO marca, String marcaAnterior) throws SQLException;
    public boolean insertMarca(MarcaDTO marca) throws SQLException;
    public boolean deleteMarca(MarcaDTO marca) throws SQLException;
    public int getElementChild(String nombre) throws SQLException;
    
}
