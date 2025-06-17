package Jogo.Luta;

import Jogo.Jogo;
import Ninjas.Enum.Afinidade;
import Ninjas.NPC.Maus.Inimigo;

/**
 * Classe utilitária com métodos relacionados à lógica de vantagem elemental (afinidade)
 * usada durante os combates entre Naruto e seus inimigos.
 */
public class Utils {

    /**
     * Verifica se Naruto possui vantagem elemental sobre o inimigo.
     * A vantagem concede 20% a mais de dano no combate.
     *
     * Regras de vantagem:
     * - FOGO vence VENTO
     * - VENTO vence RELÂMPAGO
     * - RELÂMPAGO vence TERRA
     * - TERRA vence ÁGUA
     * - ÁGUA vence FOGO
     *
     * @param inimigo O inimigo que Naruto está enfrentando.
     * @return true se Naruto tem vantagem elemental, false caso contrário.
     */
    public static boolean influenciaNatureza(Inimigo inimigo) {
        Afinidade afinidadeNaruto = Jogo.getNaruto().getAfinidade();
        Afinidade afinidadeInimigo = inimigo.getAfinidade();

        switch (afinidadeNaruto) {
            case FOGO:
                return afinidadeInimigo == Afinidade.VENTO;
            case VENTO:
                return afinidadeInimigo == Afinidade.RELAMPAGO;
            case RELAMPAGO:
                return afinidadeInimigo == Afinidade.TERRA;
            case TERRA:
                return afinidadeInimigo == Afinidade.AGUA;
            case AGUA:
                return afinidadeInimigo == Afinidade.FOGO;
            default:
                return false; // Nenhuma vantagem se afinidade for indefinida
        }
    }

    /**
     * Verifica se o inimigo possui vantagem elemental sobre Naruto.
     * Esta informação é usada no turno do inimigo para aumentar o dano.
     *
     * A lógica é a mesma da função acima, mas invertida (ponto de vista do inimigo).
     *
     * @param inimigo O inimigo que ataca Naruto.
     * @return true se o inimigo tem vantagem elemental sobre Naruto, false caso contrário.
     */
    public static boolean influenciaNaturezaInimigo(Inimigo inimigo) {
        Afinidade afinidadeInimigo = inimigo.getAfinidade();
        Afinidade afinidadeNaruto = Jogo.getNaruto().getAfinidade();

        switch (afinidadeInimigo) {
            case FOGO:
                return afinidadeNaruto == Afinidade.VENTO;
            case VENTO:
                return afinidadeNaruto == Afinidade.RELAMPAGO;
            case RELAMPAGO:
                return afinidadeNaruto == Afinidade.TERRA;
            case TERRA:
                return afinidadeNaruto == Afinidade.AGUA;
            case AGUA:
                return afinidadeNaruto == Afinidade.FOGO;
            default:
                return false;
        }
    }
}
