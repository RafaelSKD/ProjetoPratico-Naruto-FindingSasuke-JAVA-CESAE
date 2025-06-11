package Jogo.InicializarObjetos.Ninjas;

import Ninjas.Enum.Afinidade;
import Ninjas.NarutoSasuke.Sasuke;

public class InicializarSasuke {
    public static Sasuke inicializarSasuke(){
        Sasuke sasuke = new Sasuke(
                "Sasuke Uchiha",
                Afinidade.RELAMPAGO,
                950.0,  // chakra
                340.0,  // defesa
                420.0,  // ataque
                880.0  // vida
        );
        return sasuke;
    }
}
