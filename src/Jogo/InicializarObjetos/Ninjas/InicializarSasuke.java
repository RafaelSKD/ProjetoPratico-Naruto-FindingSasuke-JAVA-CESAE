package Jogo.InicializarObjetos.Ninjas;

import Ninjas.Enum.Afinidade;
import Ninjas.NarutoSasuke.Sasuke;

/**
 * Classe responsável por criar e inicializar a instância do personagem Sasuke.
 * Define os atributos base do Sasuke no jogo, que é o principal antagonista do Naruto neste contexto.
 */
public class InicializarSasuke {

    /**
     * Inicializa o objeto Sasuke com seus valores base.
     *
     * @return Instância de Sasuke com atributos pré-definidos.
     */
    public static Sasuke inicializarSasuke() {
        Sasuke sasuke = new Sasuke(
                "Sasuke Uchiha",
                Afinidade.RELAMPAGO, // Afinidade elemental principal
                1000.0,              // Chakra inicial elevado
                500.0,               // Defesa elevada
                1000.0,              // Ataque extremamente alto
                2000.0               // Vida máxima
        );

        return sasuke;
    }
}
