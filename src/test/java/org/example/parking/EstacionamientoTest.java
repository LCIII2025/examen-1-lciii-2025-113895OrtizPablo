package org.example.parking;

import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class EstacionamientoTest {

    @Test
    public void testRetirarVehiculo() throws Exception {
        //TODO test
        Vehiculo vehiculo = new Vehiculo("AB660AB","Fiesta",Vehiculo.Tipo.AUTO );
        Vehiculo vehiculo1= new Vehiculo("DGI3309","Fiesta",Vehiculo.Tipo.SUV );
        Estacionamiento estacionamiento = new Estacionamiento();
        estacionamiento.ingresarVehiculo( "39498554","Pablo",vehiculo);
        estacionamiento.ingresarVehiculo( "16552880","Delcy",vehiculo1);
        List vehiculosEstacionados = estacionamiento.listarVehiculosEstacionados();
        System.out.println("Cantidad de vehiculos inicial: "+vehiculosEstacionados.size());
        estacionamiento.retirarVehiculo("DGI3309");
        List vehiculosEstacionadosDos = estacionamiento.listarVehiculosEstacionados();
        System.out.println("Cantidad de vehiculos final: "+vehiculosEstacionadosDos.size());
        assertEquals(1,vehiculosEstacionadosDos.size());
    }

    @Test
    public void testCalcularPrecio() throws Exception {
        // TODO test
        Vehiculo vehiculo = new Vehiculo("AB660AB","Fiesta",Vehiculo.Tipo.AUTO );
        Vehiculo vehiculo1= new Vehiculo("DGI3309","Fiesta",Vehiculo.Tipo.SUV );
        Estacionamiento estacionamiento = new Estacionamiento();
        estacionamiento.ingresarVehiculo( "39498554","Pablo",vehiculo);
        estacionamiento.ingresarVehiculo( "16552880","Delcy",vehiculo1);

        Ticket ticket = estacionamiento.retirarVehiculo("DGI3309");

       double precio =  ticket.calcularPrecio();

        System.out.println("Precio a pagar: "+precio+"$");
        assertTrue(precio>=0);
        assertEquals(100.0,precio,36000.00);

    }

}