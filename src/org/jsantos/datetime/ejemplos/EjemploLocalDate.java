package org.jsantos.datetime.ejemplos;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class EjemploLocalDate {

    public static void main(String[] args) {


        LocalDate fechaActual = LocalDate.now();
        System.out.println("fecha Actual = " + fechaActual);
        System.out.println("Dia = " + fechaActual.getDayOfMonth());
        Month mes = fechaActual.getMonth();
        System.out.println("mes = " + mes);
        System.out.println("Número del mes = " + mes.getValue());
        System.out.println("mes Español = " + mes.getDisplayName(TextStyle.FULL, new Locale("es", "ES")));

        DayOfWeek diaSemana = fechaActual.getDayOfWeek();
        System.out.println("Numero del día = " + diaSemana.getValue());
        System.out.println("NOmbre del día= " + diaSemana.getDisplayName(TextStyle.FULL, new Locale("es", "ES")));

        System.out.println("Mes = " + fechaActual.getMonth());
        System.out.println("Año = " + fechaActual.getYear());
        System.out.println("Dia del Año = " + fechaActual.getDayOfYear());
        System.out.println("Era = " + fechaActual.getEra());

        fechaActual = LocalDate.of(2021,11,25);
        System.out.println("fechaActual = " + fechaActual);

        fechaActual = LocalDate.of(2021, Month.NOVEMBER,25);
        System.out.println("fechaActual = " + fechaActual);

        fechaActual = LocalDate.parse("2020-11-26");
        System.out.println("fechaActual = " + fechaActual);

        LocalDate diaDeMañana = LocalDate.now().plusDays(1);
        System.out.println("diaDeMañana = " + diaDeMañana);

        LocalDate mesAnteriorMismoDia = LocalDate.now().minusMonths(1);
        System.out.println("mesAnteriorMismoDia = " + mesAnteriorMismoDia);

        LocalDate mesAnteriorMismoDia2 = LocalDate.now().minus(1, ChronoUnit.MONTHS);
        System.out.println("mesAnteriorMismoDia2 = " + mesAnteriorMismoDia);

        DayOfWeek lunes = LocalDate.parse("2022-01-03").getDayOfWeek();
        System.out.println("lunes = " + lunes);

        int once = LocalDate.of(2020,11,11).getDayOfMonth();
        System.out.println("once = " + once);

        boolean esBisiesto = LocalDate.now().isLeapYear();
        System.out.println("esBisiesto = " + esBisiesto);

        boolean esAntes = LocalDate.now().isBefore(LocalDate.parse("2022-01-02"));
        System.out.println("esAntes = " + esAntes);

        boolean esDespues = LocalDate.now().isAfter(LocalDate.parse("2022-01-02"));
        System.out.println("esDespues = " + esDespues);

        esDespues = LocalDate.now().isAfter(LocalDate.now().minusDays(1));
        System.out.println("esDespues = " + esDespues);


    }
}
