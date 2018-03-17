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

    

    public static void checkSumatorio(String numeroRomano) {
        String sumatorio = "[MXCI]{1,3}";
        Pattern pattern = Pattern.compile(sumatorio);
        Matcher matcher = pattern.matcher(numeroRomano);
        while (matcher.find()) {
            int total = 0;
            for(int i=0;i<matcher.group().length();i++) {
                total += obtenerDecimal(matcher.group().substring(i, i+1));
            }
            listaNumerosDecimales.add(total);
        }
    }


    public static void check(String numeroRomano) {
        listaNumerosDecimales = new ArrayList();
        checkSumatorio(numeroRomano);
    }

    public static List<Integer> getListaNumerosDecimales(){
        return listaNumerosDecimales;
    }


}