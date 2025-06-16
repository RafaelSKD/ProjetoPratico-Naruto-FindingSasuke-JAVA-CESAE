package Jogo.InicializarObjetos.Ninjas;

import Ninjas.Enum.Afinidade;
import Ninjas.NarutoSasuke.Naruto;

public class InicializarNaruto {
    public static Naruto inicializarNaruto(){
        Naruto naruto = new Naruto(
                "Naruto Uzumaki",
                Afinidade.VENTO,
                600.0, // chakra
                200.0,  // defesa
                4300.0,  // ataque
                1000.0,  // vida
                2500 // dinheiro
        );

        return naruto;
    }
}
