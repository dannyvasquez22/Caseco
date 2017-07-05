package com.admin.model.dao;

import com.admin.model.dto.BoletaDTO;
import com.admin.model.dto.ClienteDTO;
import com.admin.model.dto.DetalleCargoDTO;
import com.admin.model.dto.DetalleTiendaDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class BoletaDAO {
        
    BoletaDTO getById(int id, Connection ins) throws SQLException{       
        BoletaDTO boleta = null;
//        Statement sent1 = ins.createStatement();
//        ResultSet rst1 = sent1.executeQuery("select bot_codigo, bot_serie, bot_numero, "
//                + "bot_nomClie, bot_direClie, bot_fecha, bot_hora, bot_total, "
//                + "bot_estCancelacion, bot_estEntrega, bot_estado, clie_codigo, "
//                + "detcarg_codigoVendedor, detcarg_codigoCajero, bot_fechaEntrega, "
//                + "dettien_codigo from boleta where bot_codigo = '"+id+"'");
//        while(rst1.next()){
//            ClienteDTO cliente = null; 
//            ClienteDAO clienteDAO = new ClienteDAO();
//            DetalleCargoDTO detCargoVendedor = null, detCargoCajero; 
//            DetalleCargoDAO detCargoDAO = new DetalleCargoDAO();
//            DetalleTiendaDTO detTienda; 
//            DetalleTiendaDAO detTiendaDAO = new DetalleTiendaDAO();
//            
//            if(rst1.getString("clie_codigo") != null){
//                cliente = clienteDAO.getById(rst1.getInt("clie_codigo"));
//            }
//            if(rst1.getString("detcarg_codigoVendedor") != null){
//                detCargoVendedor = detCargoDAO.getById(rst1.getInt("detcarg_codigoVendedor"));
//            }
//            detCargoCajero = detCargoDAO.getById(rst1.getInt("detcarg_codigoCajero"));
//            detTienda = detTiendaDAO.getById(rst1.getInt("dettien_codigo"));
//            
//            boleta = new BoletaDTO(rst1.getInt("bot_codigo"), rst1.getInt("bot_serie"), 
//                    rst1.getInt("bot_numero"), rst1.getString("bot_nomClie"), 
//                    rst1.getString("bot_direClie"), rst1.getDate("bot_fecha"), 
//                    rst1.getTime("bot_hora"), rst1.getDouble("bot_total"), 
//                    rst1.getInt("bot_estCancelacion"), rst1.getInt("bot_estEntrega"), 
//                    rst1.getInt("bot_estado"), rst1.getDate("bot_fechaEntrega"), 
//                    cliente, detCargoVendedor, detCargoCajero, detTienda);
//            
//            cliente = null;
//            detCargoCajero = null;
//            detCargoCajero = null;
//            detTienda = null;
//            
//        }
//        sent1.close();
//        rst1.close();          
        return boleta;
    }
    
    ArrayList<BoletaDTO> getByAll(Connection ins) throws SQLException{  
        ArrayList<BoletaDTO> boletas = new ArrayList<BoletaDTO>();
//        Statement sent1 = ins.createStatement();
//        ResultSet rst1 = sent1.executeQuery("select bot_codigo, bot_serie, bot_numero, "
//                + "bot_nomClie, bot_direClie, bot_fecha, bot_hora, bot_total, "
//                + "bot_estCancelacion, bot_estEntrega, bot_estado, clie_codigo, "
//                + "detcarg_codigoVendedor, detcarg_codigoCajero, bot_fechaEntrega, "
//                + "dettien_codigo from boleta");
//        while(rst1.next()){
//            ClienteDTO cliente = null; 
//            ClienteDAO clienteDAO = new ClienteDAO();
//            DetalleCargoDTO detCargoVendedor = null, detCargoCajero; 
//            DetalleCargoDAO detCargoDAO = new DetalleCargoDAO();
//            DetalleTiendaDTO detTienda; 
//            DetalleTiendaDAO detTiendaDAO = new DetalleTiendaDAO();
//            
//            if(rst1.getString("clie_codigo") != null){
//                cliente = clienteDAO.getById(rst1.getInt("clie_codigo"));
//            }
//            if(rst1.getString("detcarg_codigoVendedor") != null){
//                detCargoVendedor = detCargoDAO.getById(rst1.getInt("detcarg_codigoVendedor"));
//            }
//            detCargoCajero = detCargoDAO.getById(rst1.getInt("detcarg_codigoCajero"));
//            detTienda = detTiendaDAO.getById(rst1.getInt("dettien_codigo"));
//            
//            boletas.add(new BoletaDTO(rst1.getInt("bot_codigo"), rst1.getInt("bot_serie"), 
//                    rst1.getInt("bot_numero"), rst1.getString("bot_nomClie"), 
//                    rst1.getString("bot_direClie"), rst1.getDate("bot_fecha"), 
//                    rst1.getTime("bot_hora"), rst1.getDouble("bot_total"), 
//                    rst1.getInt("bot_estCancelacion"), rst1.getInt("bot_estEntrega"), 
//                    rst1.getInt("bot_estado"), rst1.getDate("bot_fechaEntrega"), 
//                    cliente, detCargoVendedor, detCargoCajero, detTienda));
//            
//            cliente = null;
//            detCargoCajero = null;
//            detCargoCajero = null;
//            detTienda = null;
//            
//        }
//        sent1.close();
//        rst1.close();       
        
        return boletas;
    }
    
    boolean updateBoleta(Connection ins){
        boolean estateOperation = true;
        
        return estateOperation;    
    }
    
    boolean insertBoleta(Connection ins){
        boolean estateOperation = true;
        
        return estateOperation;
    }    
}
