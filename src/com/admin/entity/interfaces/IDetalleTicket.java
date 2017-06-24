package com.admin.entity.interfaces;

import com.admin.entity.dto.DetalleTicketDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IDetalleTicket {

    DetalleTicketDTO getById(int id);
    ArrayList<DetalleTicketDTO> getByAll();
    boolean updateDetalleTicket();
    boolean insertDetalleTicket();
    
}
