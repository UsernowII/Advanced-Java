package org.jsantos.datetime.ejemplos;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class EjemploZoneDateTime {

    public static void main(String[] args) {

        LocalDateTime fechaLocal = LocalDateTime.parse("2022/03/23 12:45"
                , DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));

        //ZoneId virgin = ZoneId.of(	"America/Virgin");
        //ZonedDateTime zonaVirgin = ZonedDateTime.of(fechaLocal, ZoneOffset.of("-04:00"));
        ZonedDateTime zonaVirgin = fechaLocal.atZone(ZoneId.of("America/Virgin"));
        System.out.println("Horario de partida en Virginia = " + zonaVirgin);


        //ZoneId madrid = ZoneId.of("Europe/Madrid");
        //ZonedDateTime zonaMadrid = zonaVirgin.withZoneSameInstant(madrid).plusHours(8);
        ZonedDateTime zonaMadrid = zonaVirgin.withZoneSameInstant(ZoneOffset.of("+01:00")).plusHours(8);
        System.out.println("Hora de llegada en Madrid = " + zonaMadrid);


        DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm - dd MMM yyyy");
        System.out.println("Detalles del viaje a Madrid: ");
        System.out.println("Partida Virginia: " + f.format(zonaVirgin));
        System.out.println("Llegada Madrid: " + f.format(zonaMadrid));


        Set<String> zonas = ZoneId.getAvailableZoneIds();
        zonas.forEach(System.out::println);
    }
}
