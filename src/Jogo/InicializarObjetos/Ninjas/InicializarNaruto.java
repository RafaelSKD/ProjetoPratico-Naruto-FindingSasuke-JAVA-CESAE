package Jogo.InicializarObjetos.Ninjas;

import Ninjas.Enum.Afinidade;
import Ninjas.NarutoSasuke.Naruto;

public class InicializarNaruto {
    public static Naruto inicializarNaruto(){
        Naruto naruto = new Naruto(
                "Naruto Uzumaki",
                Afinidade.VENTO,
                1000.0, // chakra
                350.0,  // defesa
                400.0,  // ataque
                900.0,  // vida
                500 // dinheiro
        );

        return naruto;
    }
}
