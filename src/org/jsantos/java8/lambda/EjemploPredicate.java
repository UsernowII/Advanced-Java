package org.jsantos.java8.lambda;

import org.jsantos.java8.lambda.models.Usuario;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class EjemploPredicate {

    public static void main(String[] args) {


        Predicate <Integer> test = num -> num > 10;
        boolean r = test.test(11);
        System.out.println("r = " + r);

        Predicate <String> test2 = role -> role.equals("ROLE_ADMIN");
        System.out.println("test2.test(\"ROLE_ADMIN\") = " + test2.test("ROLE_ADMIN"));

        BiPredicate <String, String> test3 = String::equals;
        System.out.println("test3 = " + test3.test("juan", "Juan"));

        BiPredicate <Integer, Integer> test4 = (i,j) -> j > 1;
        boolean r2 = test4.test(50,25);
        System.out.println("r2 = " + r2);

        Usuario a = new Usuario();
        Usuario b = new Usuario();

        a.setNombre("maria");
        b.setNombre("maria");

        BiPredicate <Usuario, Usuario> test5 = (ua, ub) -> ua.getNombre().equals(ub.getNombre());
        System.out.println("test5 = " + test5.test(a,b));


    }

}

