package org.mvpigs.romans;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

import org.junit.Test;
import org.mvpigs.romans.Interfaz.NumerosRomanos;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class NumeralesRomanosTest {
     @Test
    public void testNumeroRomanoSimple() {
        List<NumerosRomanos> listaNumerosRomanos = Arrays.stream(NumerosRomanos.values())
                .collect(Collectors.toCollection(ArrayList<NumerosRomanos>::new));
        String numeroRomano = "IVXLCDM";

        int indice = 0;
        for (NumerosRomanos caracterRomano:listaNumerosRomanos){
            assertThat(numeroRomano.substring(indice,indice+1)).isIn(caracterRomano.name());
            assertThat(NumeralesRomanos.obtenerDecimal(numeroRomano.substring(indice, indice + 1)))
                    .isEqualTo(listaNumerosRomanos.get(indice).getValorDecimal());
            indice++;
        }
    
    }

    @Test  
    public void testSumatorioSimple() {
        //suma simple
        String numeroRomano = "II";
        NumeralesRomanos.check(numeroRomano);
        List<Integer> numeros = NumeralesRomanos.getListaNumerosDecimales();
        int total=0;
        for (Integer numero:numeros) {
            total+=numero;
        }
        assertThat(total).isEqualTo(2);
        //suma simple triple
        numeroRomano = "III";
        NumeralesRomanos.check(numeroRomano);
        numeros = NumeralesRomanos.getListaNumerosDecimales();
        total=0;
        for (Integer numero:numeros) {
            total+=numero;
        }
        assertThat(total).isEqualTo(3);
    }

    
    @Test
    public void testCombinaciones() {
        //Combinaciones sacadas de wikipedia
        List<String> combinaciones = new ArrayList();
        List<Integer> numeros;
        combinaciones.add("IV");
        combinaciones.add("VI");
        combinaciones.add("VII");
        combinaciones.add("VIII");
        combinaciones.add("IX");
        combinaciones.add("XXXII");
        combinaciones.add("XLIX");
        combinaciones.add("XLV");
        // Añado más número para probar
        combinaciones.add("XXXIII");
        combinaciones.add("CXLVII");
        combinaciones.add("CCCLXV");
        combinaciones.add("XCIV");
        combinaciones.add("CCLXXXIX");
        combinaciones.add("LXXVIII");
        combinaciones.add("CCLVI");
        combinaciones.add("CCCXCV");
        combinaciones.add("CCXXVIII");
        combinaciones.add("MCMXCVII");
        combinaciones.add("CDLXXII");
        combinaciones.add("MMX");
        combinaciones.add("DCCCXCVIII");
        combinaciones.add("MMMDXLVIII");
        combinaciones.add("MMCMLXXI");
        
        int[] resultadoCombinaciones = { 4, 6, 7, 8, 9, 32, 49, 45, 33, 147, 365, 94, 289, 78, 256, 395, 228, 1997, 472,
                2010, 898, 3548, 2971 };

        int total;
        int indice=0;

        for (String testRomano:combinaciones){
            total=0;
            NumeralesRomanos.check(testRomano);
            numeros = NumeralesRomanos.getListaNumerosDecimales();
            total = numeros.stream().reduce(0, Integer::sum);
            assertThat(total).isEqualTo(resultadoCombinaciones[indice]);
            indice++;
        }


    }


}