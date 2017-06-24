/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOEntity;

import com.admin.entity.dto.VehiculoDTO;
import com.admin.entity.dto.FacturaDTO;
import com.admin.entity.dto.GuiaRemisionDTO;
import com.admin.entity.dto.DetalleTiendaDTO;
import com.admin.entity.dto.BoletaDTO;
import com.admin.entity.dto.DetalleCargoDTO;
import java.sql.Date;
import java.sql.Time;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DANNY VASQUEZ RAFAEL
 */
public class GuiaRemisionDTOIT {
    
    public GuiaRemisionDTOIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCodigo method, of class GuiaRemisionDTO.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        GuiaRemisionDTO instance = null;
        int expResult = 0;
        int result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class GuiaRemisionDTO.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 0;
        GuiaRemisionDTO instance = null;
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSerie method, of class GuiaRemisionDTO.
     */
    @Test
    public void testGetSerie() {
        System.out.println("getSerie");
        GuiaRemisionDTO instance = null;
        int expResult = 0;
        int result = instance.getSerie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSerie method, of class GuiaRemisionDTO.
     */
    @Test
    public void testSetSerie() {
        System.out.println("setSerie");
        int serie = 0;
        GuiaRemisionDTO instance = null;
        instance.setSerie(serie);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumero method, of class GuiaRemisionDTO.
     */
    @Test
    public void testGetNumero() {
        System.out.println("getNumero");
        GuiaRemisionDTO instance = null;
        int expResult = 0;
        int result = instance.getNumero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumero method, of class GuiaRemisionDTO.
     */
    @Test
    public void testSetNumero() {
        System.out.println("setNumero");
        int numero = 0;
        GuiaRemisionDTO instance = null;
        instance.setNumero(numero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumeroFin method, of class GuiaRemisionDTO.
     */
    @Test
    public void testGetNumeroFin() {
        System.out.println("getNumeroFin");
        GuiaRemisionDTO instance = null;
        int expResult = 0;
        int result = instance.getNumeroFin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumeroFin method, of class GuiaRemisionDTO.
     */
    @Test
    public void testSetNumeroFin() {
        System.out.println("setNumeroFin");
        int numeroFin = 0;
        GuiaRemisionDTO instance = null;
        instance.setNumeroFin(numeroFin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPartida method, of class GuiaRemisionDTO.
     */
    @Test
    public void testGetPartida() {
        System.out.println("getPartida");
        GuiaRemisionDTO instance = null;
        String expResult = "";
        String result = instance.getPartida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPartida method, of class GuiaRemisionDTO.
     */
    @Test
    public void testSetPartida() {
        System.out.println("setPartida");
        String partida = "";
        GuiaRemisionDTO instance = null;
        instance.setPartida(partida);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLlegada method, of class GuiaRemisionDTO.
     */
    @Test
    public void testGetLlegada() {
        System.out.println("getLlegada");
        GuiaRemisionDTO instance = null;
        String expResult = "";
        String result = instance.getLlegada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLlegada method, of class GuiaRemisionDTO.
     */
    @Test
    public void testSetLlegada() {
        System.out.println("setLlegada");
        String llegada = "";
        GuiaRemisionDTO instance = null;
        instance.setLlegada(llegada);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMotivoTrans method, of class GuiaRemisionDTO.
     */
    @Test
    public void testGetMotivoTrans() {
        System.out.println("getMotivoTrans");
        GuiaRemisionDTO instance = null;
        String expResult = "";
        String result = instance.getMotivoTrans();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMotivoTrans method, of class GuiaRemisionDTO.
     */
    @Test
    public void testSetMotivoTrans() {
        System.out.println("setMotivoTrans");
        String motivoTrans = "";
        GuiaRemisionDTO instance = null;
        instance.setMotivoTrans(motivoTrans);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipoDocIden method, of class GuiaRemisionDTO.
     */
    @Test
    public void testGetTipoDocIden() {
        System.out.println("getTipoDocIden");
        GuiaRemisionDTO instance = null;
        String expResult = "";
        String result = instance.getTipoDocIden();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTipoDocIden method, of class GuiaRemisionDTO.
     */
    @Test
    public void testSetTipoDocIden() {
        System.out.println("setTipoDocIden");
        String tipoDocIden = "";
        GuiaRemisionDTO instance = null;
        instance.setTipoDocIden(tipoDocIden);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdeClienteDes method, of class GuiaRemisionDTO.
     */
    @Test
    public void testGetIdeClienteDes() {
        System.out.println("getIdeClienteDes");
        GuiaRemisionDTO instance = null;
        String expResult = "";
        String result = instance.getIdeClienteDes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdeClienteDes method, of class GuiaRemisionDTO.
     */
    @Test
    public void testSetIdeClienteDes() {
        System.out.println("setIdeClienteDes");
        String ideClienteDes = "";
        GuiaRemisionDTO instance = null;
        instance.setIdeClienteDes(ideClienteDes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClienteDes method, of class GuiaRemisionDTO.
     */
    @Test
    public void testGetClienteDes() {
        System.out.println("getClienteDes");
        GuiaRemisionDTO instance = null;
        String expResult = "";
        String result = instance.getClienteDes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setClienteDes method, of class GuiaRemisionDTO.
     */
    @Test
    public void testSetClienteDes() {
        System.out.println("setClienteDes");
        String clienteDes = "";
        GuiaRemisionDTO instance = null;
        instance.setClienteDes(clienteDes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOtrosComp method, of class GuiaRemisionDTO.
     */
    @Test
    public void testGetOtrosComp() {
        System.out.println("getOtrosComp");
        GuiaRemisionDTO instance = null;
        String expResult = "";
        String result = instance.getOtrosComp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOtrosComp method, of class GuiaRemisionDTO.
     */
    @Test
    public void testSetOtrosComp() {
        System.out.println("setOtrosComp");
        String otrosComp = "";
        GuiaRemisionDTO instance = null;
        instance.setOtrosComp(otrosComp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumComp method, of class GuiaRemisionDTO.
     */
    @Test
    public void testGetNumComp() {
        System.out.println("getNumComp");
        GuiaRemisionDTO instance = null;
        String expResult = "";
        String result = instance.getNumComp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumComp method, of class GuiaRemisionDTO.
     */
    @Test
    public void testSetNumComp() {
        System.out.println("setNumComp");
        String numComp = "";
        GuiaRemisionDTO instance = null;
        instance.setNumComp(numComp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaInicio method, of class GuiaRemisionDTO.
     */
    @Test
    public void testGetFechaInicio() {
        System.out.println("getFechaInicio");
        GuiaRemisionDTO instance = null;
        Date expResult = null;
        Date result = instance.getFechaInicio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaInicio method, of class GuiaRemisionDTO.
     */
    @Test
    public void testSetFechaInicio() {
        System.out.println("setFechaInicio");
        Date fechaInicio = null;
        GuiaRemisionDTO instance = null;
        instance.setFechaInicio(fechaInicio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHoraEmision method, of class GuiaRemisionDTO.
     */
    @Test
    public void testGetHoraEmision() {
        System.out.println("getHoraEmision");
        GuiaRemisionDTO instance = null;
        Time expResult = null;
        Time result = instance.getHoraEmision();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHoraEmision method, of class GuiaRemisionDTO.
     */
    @Test
    public void testSetHoraEmision() {
        System.out.println("setHoraEmision");
        Time horaEmision = null;
        GuiaRemisionDTO instance = null;
        instance.setHoraEmision(horaEmision);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaEmision method, of class GuiaRemisionDTO.
     */
    @Test
    public void testGetFechaEmision() {
        System.out.println("getFechaEmision");
        GuiaRemisionDTO instance = null;
        Date expResult = null;
        Date result = instance.getFechaEmision();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaEmision method, of class GuiaRemisionDTO.
     */
    @Test
    public void testSetFechaEmision() {
        System.out.println("setFechaEmision");
        Date fechaEmision = null;
        GuiaRemisionDTO instance = null;
        instance.setFechaEmision(fechaEmision);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstado method, of class GuiaRemisionDTO.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        GuiaRemisionDTO instance = null;
        int expResult = 0;
        int result = instance.getEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class GuiaRemisionDTO.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        int estado = 0;
        GuiaRemisionDTO instance = null;
        instance.setEstado(estado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRucTransportista method, of class GuiaRemisionDTO.
     */
    @Test
    public void testGetRucTransportista() {
        System.out.println("getRucTransportista");
        GuiaRemisionDTO instance = null;
        String expResult = "";
        String result = instance.getRucTransportista();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRucTransportista method, of class GuiaRemisionDTO.
     */
    @Test
    public void testSetRucTransportista() {
        System.out.println("setRucTransportista");
        String rucTransportista = "";
        GuiaRemisionDTO instance = null;
        instance.setRucTransportista(rucTransportista);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRazonTransportista method, of class GuiaRemisionDTO.
     */
    @Test
    public void testGetRazonTransportista() {
        System.out.println("getRazonTransportista");
        GuiaRemisionDTO instance = null;
        String expResult = "";
        String result = instance.getRazonTransportista();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRazonTransportista method, of class GuiaRemisionDTO.
     */
    @Test
    public void testSetRazonTransportista() {
        System.out.println("setRazonTransportista");
        String razonTransportista = "";
        GuiaRemisionDTO instance = null;
        instance.setRazonTransportista(razonTransportista);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMarcaVehi method, of class GuiaRemisionDTO.
     */
    @Test
    public void testGetMarcaVehi() {
        System.out.println("getMarcaVehi");
        GuiaRemisionDTO instance = null;
        String expResult = "";
        String result = instance.getMarcaVehi();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMarcaVehi method, of class GuiaRemisionDTO.
     */
    @Test
    public void testSetMarcaVehi() {
        System.out.println("setMarcaVehi");
        String marcaVehi = "";
        GuiaRemisionDTO instance = null;
        instance.setMarcaVehi(marcaVehi);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBumCertificado method, of class GuiaRemisionDTO.
     */
    @Test
    public void testGetBumCertificado() {
        System.out.println("getBumCertificado");
        GuiaRemisionDTO instance = null;
        String expResult = "";
        String result = instance.getBumCertificado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBumCertificado method, of class GuiaRemisionDTO.
     */
    @Test
    public void testSetBumCertificado() {
        System.out.println("setBumCertificado");
        String bumCertificado = "";
        GuiaRemisionDTO instance = null;
        instance.setBumCertificado(bumCertificado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumPlacaVehi method, of class GuiaRemisionDTO.
     */
    @Test
    public void testGetNumPlacaVehi() {
        System.out.println("getNumPlacaVehi");
        GuiaRemisionDTO instance = null;
        String expResult = "";
        String result = instance.getNumPlacaVehi();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumPlacaVehi method, of class GuiaRemisionDTO.
     */
    @Test
    public void testSetNumPlacaVehi() {
        System.out.println("setNumPlacaVehi");
        String numPlacaVehi = "";
        GuiaRemisionDTO instance = null;
        instance.setNumPlacaVehi(numPlacaVehi);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLicencia method, of class GuiaRemisionDTO.
     */
    @Test
    public void testGetLicencia() {
        System.out.println("getLicencia");
        GuiaRemisionDTO instance = null;
        String expResult = "";
        String result = instance.getLicencia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLicencia method, of class GuiaRemisionDTO.
     */
    @Test
    public void testSetLicencia() {
        System.out.println("setLicencia");
        String licencia = "";
        GuiaRemisionDTO instance = null;
        instance.setLicencia(licencia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFactura method, of class GuiaRemisionDTO.
     */
    @Test
    public void testGetFactura() {
        System.out.println("getFactura");
        GuiaRemisionDTO instance = null;
        FacturaDTO expResult = null;
        FacturaDTO result = instance.getFactura();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFactura method, of class GuiaRemisionDTO.
     */
    @Test
    public void testSetFactura() {
        System.out.println("setFactura");
        FacturaDTO factura = null;
        GuiaRemisionDTO instance = null;
        instance.setFactura(factura);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBoleta method, of class GuiaRemisionDTO.
     */
    @Test
    public void testGetBoleta() {
        System.out.println("getBoleta");
        GuiaRemisionDTO instance = null;
        BoletaDTO expResult = null;
        BoletaDTO result = instance.getBoleta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBoleta method, of class GuiaRemisionDTO.
     */
    @Test
    public void testSetBoleta() {
        System.out.println("setBoleta");
        BoletaDTO boleta = null;
        GuiaRemisionDTO instance = null;
        instance.setBoleta(boleta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetalleCargoTrans method, of class GuiaRemisionDTO.
     */
    @Test
    public void testGetDetalleCargoTrans() {
        System.out.println("getDetalleCargoTrans");
        GuiaRemisionDTO instance = null;
        DetalleCargoDTO expResult = null;
        DetalleCargoDTO result = instance.getDetalleCargoTrans();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDetalleCargoTrans method, of class GuiaRemisionDTO.
     */
    @Test
    public void testSetDetalleCargoTrans() {
        System.out.println("setDetalleCargoTrans");
        DetalleCargoDTO detalleCargoTrans = null;
        GuiaRemisionDTO instance = null;
        instance.setDetalleCargoTrans(detalleCargoTrans);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetalleCargoEmple method, of class GuiaRemisionDTO.
     */
    @Test
    public void testGetDetalleCargoEmple() {
        System.out.println("getDetalleCargoEmple");
        GuiaRemisionDTO instance = null;
        DetalleCargoDTO expResult = null;
        DetalleCargoDTO result = instance.getDetalleCargoEmple();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDetalleCargoEmple method, of class GuiaRemisionDTO.
     */
    @Test
    public void testSetDetalleCargoEmple() {
        System.out.println("setDetalleCargoEmple");
        DetalleCargoDTO detalleCargoEmple = null;
        GuiaRemisionDTO instance = null;
        instance.setDetalleCargoEmple(detalleCargoEmple);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetalleTiendaEnvia method, of class GuiaRemisionDTO.
     */
    @Test
    public void testGetDetalleTiendaEnvia() {
        System.out.println("getDetalleTiendaEnvia");
        GuiaRemisionDTO instance = null;
        DetalleTiendaDTO expResult = null;
        DetalleTiendaDTO result = instance.getDetalleTiendaEnvia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDetalleTiendaEnvia method, of class GuiaRemisionDTO.
     */
    @Test
    public void testSetDetalleTiendaEnvia() {
        System.out.println("setDetalleTiendaEnvia");
        DetalleTiendaDTO detalleTiendaEnvia = null;
        GuiaRemisionDTO instance = null;
        instance.setDetalleTiendaEnvia(detalleTiendaEnvia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetalleTiendaDestinatario method, of class GuiaRemisionDTO.
     */
    @Test
    public void testGetDetalleTiendaDestinatario() {
        System.out.println("getDetalleTiendaDestinatario");
        GuiaRemisionDTO instance = null;
        DetalleTiendaDTO expResult = null;
        DetalleTiendaDTO result = instance.getDetalleTiendaDestinatario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDetalleTiendaDestinatario method, of class GuiaRemisionDTO.
     */
    @Test
    public void testSetDetalleTiendaDestinatario() {
        System.out.println("setDetalleTiendaDestinatario");
        DetalleTiendaDTO detalleTiendaDestinatario = null;
        GuiaRemisionDTO instance = null;
        instance.setDetalleTiendaDestinatario(detalleTiendaDestinatario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetalleTienda method, of class GuiaRemisionDTO.
     */
    @Test
    public void testGetDetalleTienda() {
        System.out.println("getDetalleTienda");
        GuiaRemisionDTO instance = null;
        DetalleTiendaDTO expResult = null;
        DetalleTiendaDTO result = instance.getDetalleTienda();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDetalleTienda method, of class GuiaRemisionDTO.
     */
    @Test
    public void testSetDetalleTienda() {
        System.out.println("setDetalleTienda");
        DetalleTiendaDTO detalleTienda = null;
        GuiaRemisionDTO instance = null;
        instance.setDetalleTienda(detalleTienda);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVehiculo method, of class GuiaRemisionDTO.
     */
    @Test
    public void testGetVehiculo() {
        System.out.println("getVehiculo");
        GuiaRemisionDTO instance = null;
        VehiculoDTO expResult = null;
        VehiculoDTO result = instance.getVehiculo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVehiculo method, of class GuiaRemisionDTO.
     */
    @Test
    public void testSetVehiculo() {
        System.out.println("setVehiculo");
        VehiculoDTO vehiculo = null;
        GuiaRemisionDTO instance = null;
        instance.setVehiculo(vehiculo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
