package com.admin.model.interfaces;

import com.admin.model.dto.TicketDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface ITicket {

    TicketDTO getById(int id);
    ArrayList<TicketDTO> getByAll();
    boolean updateTicket();
    boolean insertTicket();
    
}
