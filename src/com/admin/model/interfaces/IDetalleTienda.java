package com.admin.model.interfaces;

import com.admin.model.dto.DetalleTiendaDTO;
import com.admin.model.pojo.TiendaAlmacenP;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IDetalleTienda {

    public DetalleTiendaDTO getById(int id) throws SQLException;
    public DetalleTiendaDTO getByAlmacenByTienda(int almacen, int tienda) throws SQLException;
    public ArrayList<DetalleTiendaDTO> getAll() throws SQLException;
    public boolean updateDetalleTienda(DetalleTiendaDTO detalle) throws SQLException;
    public boolean insertDetalleTienda(DetalleTiendaDTO detalle) throws SQLException;
    public boolean deleteDetalleTienda(DetalleTiendaDTO detalle) throws SQLException;
    
    public ArrayList<TiendaAlmacenP> getAllDetail(int codigo) throws SQLException;
    
}
