package Jogo.InicializarObjetos.Ninjas;

import Ninjas.Enum.Afinidade;
import Ninjas.NarutoSasuke.Sasuke;

public class InicializarSasuke {
    public static Sasuke inicializarSasuke(){
        Sasuke sasuke = new Sasuke(
                "Sasuke Uchiha",
                Afinidade.RELAMPAGO,
                1000.0,  // chakra
                500.0,  // defesa
                500.0,  // ataque
                1500.0  // vida
        );
        return sasuke;
    }
}
