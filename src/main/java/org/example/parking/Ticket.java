package org.example.parking;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

@Data
@AllArgsConstructor
public class Ticket {
    private final Cliente cliente;
    private final Vehiculo vehiculo;
    private final LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;

    public Ticket(Cliente cliente, Vehiculo vehiculo) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.horaEntrada = LocalDateTime.now();
    }

    public void marcarSalida() {
        Random random = new Random();
        this.horaSalida = LocalDateTime.now().plusMinutes(random.nextInt(200)+1);
    }

    public long calcularMinutos() {
        return Duration.between(horaEntrada, horaSalida).toMinutes();
    }

    public double calcularPrecio() {
        // TODO implementar el metodo para calcular el importe a abonar segun el tipo de vehiculo
        // AUTO -> 100, SUV -> 130, PICKUP -> 180
        // el importe es por hora redondeando el tiempo hacia arriba,
        // por ejemplo si estuvo 45 minutos se le tarifa por 60, si estuvo 80 minutos se le tarifa por 120 minutos, etc...
        // retornar el importe final

        //Definir el precio a aplicar
        double precio=0;
        if(vehiculo.getTipo().equals(Vehiculo.Tipo.AUTO)){
            precio =100;
        } else if (vehiculo.getTipo().equals(Vehiculo.Tipo.SUV)) {
            precio = 130;
        } else if (vehiculo.getTipo().equals(Vehiculo.Tipo.PICKUP)) {
            precio = 180;
        }

        //Definir tiempo
        Duration duracion = Duration.between(horaEntrada, horaSalida);
        int totalMinutos = (int)duracion.toMinutes();
        int minutosRedondeados=0;
        if(0<=totalMinutos &&totalMinutos<=60){
            minutosRedondeados=60;
        } else if (60<totalMinutos &&totalMinutos<=120) {
            minutosRedondeados =120;
        }else if (120<totalMinutos &&totalMinutos<=180){
            minutosRedondeados =180;
        }else if (180<totalMinutos &&totalMinutos<=200){
            minutosRedondeados =200;
        }

        return   precio*minutosRedondeados;
    }

}