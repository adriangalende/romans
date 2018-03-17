package org.mvpigs.romans;

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

}