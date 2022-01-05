package org.jsantos.datetime.ejemplos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class EjemploLocalDateTime {

    public static void main(String[] args) {

        //fecha actual con hora
        LocalDateTime fechaTiempo = LocalDateTime.now();
        System.out.println("fechaTiempo = " + fechaTiempo);

        fechaTiempo = LocalDateTime.of(2020, Month.DECEMBER,24,20,46,55);
        System.out.println("fechaTiempo = " + fechaTiempo);

        fechaTiempo = LocalDateTime.parse("2022-01-05T14:00:54.5662622");
        System.out.println("fechaTiempo = " + fechaTiempo);

        fechaTiempo = fechaTiempo.plusDays(1).plusHours(2);
        System.out.println("fechaTiempo = " + fechaTiempo);
        System.out.println("fechaTiempo2 = " + fechaTiempo.minusHours(10));

        Month mes = fechaTiempo.getMonth();
        System.out.println("mes = " + mes);

        int dia = fechaTiempo.getDayOfMonth();
        System.out.println("dia = " + dia);

        int anio = fechaTiempo.getYear();
        System.out.println("anio = " + anio);

        String formato1 = fechaTiempo.format(DateTimeFormatter.ISO_DATE);
        System.out.println("formato1 = " + formato1);

        formato1 = fechaTiempo.format(DateTimeFormatter.ISO_WEEK_DATE);
        System.out.println("formato1 = " + formato1);

        String formato2 = fechaTiempo.format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss a"));
        System.out.println("formato2 = " + formato2);

        DateTimeFormatter df =  DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss a");

        String formato3 = df.format(fechaTiempo);
        System.out.println("formato3 = " + formato3);

        formato3 = fechaTiempo.format(df);
        System.out.println("formato3 = " + formato3);


    }
}
