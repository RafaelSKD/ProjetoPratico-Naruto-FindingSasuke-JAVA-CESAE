package Jogo.InicializarObjetos.Ninjas;

import Ninjas.Enum.Afinidade;
import Ninjas.NarutoSasuke.Naruto;

/**
 * Classe responsável por criar e inicializar a instância do personagem jogável Naruto.
 * Define os atributos iniciais do personagem, incluindo vida, chakra, ataque, defesa e dinheiro.
 */
public class InicializarNaruto {

    /**
     * Inicializa o objeto Naruto com valores base do jogo.
     *
     * @return Instância de Naruto com atributos pré-definidos.
     */
    public static Naruto inicializarNaruto() {
        Naruto naruto = new Naruto(
                "Naruto Uzumaki",
                Afinidade.VENTO,  // Afinidade elemental principal de Naruto
                600.0,            // Chakra inicial
                180.0,            // Defesa inicial
                400.0,            // Ataque inicial
                1000.0,           // Vida inicial
                2000              // Dinheiro inicial
        );

        return naruto;
    }
}
