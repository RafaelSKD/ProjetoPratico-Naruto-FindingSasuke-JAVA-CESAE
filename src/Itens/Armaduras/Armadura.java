package Itens.Armaduras;

import Itens.Enum.TipoArmadura;
import Itens.Enum.TipoItem;
import Itens.Item;

/**
 * Representa uma armadura no sistema de itens.
 * As armaduras podem ser de tipo CIMA ou BAIXO e fornecem defesa adicional ao utilizador.
 */
public class Armadura extends Item {
    private TipoArmadura tipoArmadura; // CIMA ou BAIXO: indica onde a armadura é equipada
    private double defesaArmadura; // Valor de defesa que esta armadura adiciona ao utilizador
    private int spawn; // Probabilidade (ou prioridade) de a armadura aparecer no jogo

    /**
     * Construtor para criar uma nova instância de Armadura.
     *
     * @param nome           Nome da armadura.
     * @param tipo           Tipo de item (espera-se que seja do tipo ARMADURA).
     * @param tipoArmadura   Tipo da armadura (CIMA ou BAIXO).
     * @param defesa         Valor da defesa fornecida pela armadura.
     * @param spawn          Possibilidade de aparecer na loja (valor usado no spawn).
     */
    public Armadura(String nome, TipoItem tipo, TipoArmadura tipoArmadura, double defesa, int spawn) {
        super(nome, tipo);
        this.tipoArmadura = tipoArmadura;
        this.defesaArmadura = defesa;
        this.spawn = spawn;
    }

    /**
     * Retorna o tipo da armadura (CIMA ou BAIXO).
     *
     * @return Tipo da armadura.
     */
    public TipoArmadura getTipoArmadura() {
        return tipoArmadura;
    }

    /**
     * Retorna o valor de defesa que esta armadura oferece.
     *
     * @return Valor de defesa.
     */
    public double getDefesaArmadura() {
        return defesaArmadura;
    }
}
