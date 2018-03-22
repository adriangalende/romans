package org.mvpigs.romans;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;
import org.mvpigs.romans.Interfaz.NumerosRomanos;

public class NumeralesRomanos{
    private static List<Integer> listaNumerosDecimales;
    
    public static int obtenerDecimal(String numeroRomano) {
        NumerosRomanos numero = NumerosRomanos.valueOf(numeroRomano);
        return numero.getValorDecimal();
    }


    public static void check(String numeroRomano) {
        listaNumerosDecimales = new ArrayList();
        checkSustractivo(numeroRomano);
        checkSumatorio(numeroRomano);

    }

    public static List<Integer> getListaNumerosDecimales(){
        return listaNumerosDecimales;
    }
    

    public static void checkSumatorio(String numeroRomano) {
        Regex sumatorio = new Regex("(?<!C)M|(?<!C)D|(?<!X)C(?![MD])|(?<!X)L(?!D)|(?<!I)X(?![LC])|(?<!I)V|I(?![XV])");
        Matcher matcher = sumatorio.getMatcher(numeroRomano);

        while (matcher.find()) {
            int total = 0;
            for(int i=0;i<matcher.group().length();i++) {
                total += obtenerDecimal(matcher.group().substring(i, i+1));
            }
            listaNumerosDecimales.add(total);
        }
    }

    public static int calcularSustractivo(int numero1, int numero2){
        return numero2-numero1;
    }


    public static void checkSustractivo(String numeroRomano) {

        Regex sustractivo = new Regex("(C[DM])|(X[LC])|(I[VX])");
        Matcher matcher = sustractivo.getMatcher(numeroRomano);

        while (matcher.find()) {
            int primerNumero = obtenerDecimal(matcher.group().substring(0, 1));
            int segundoNumero = obtenerDecimal(matcher.group().substring(1, 2));
            listaNumerosDecimales.add(calcularSustractivo(primerNumero, segundoNumero));
        }
    }



}