package com.admin.entity.interfaces;

import com.admin.entity.dto.TicketDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface ITicket {

    TicketDTO getById(int id);
    ArrayList<TicketDTO> getByAll();
    boolean updateTicket();
    boolean insertTicket();
    
}
