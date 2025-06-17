package Itens.AtaqueChakra;

import Itens.Enum.TipoItem;
import Itens.Item;

/**
 * Representa um ataque especial que consome chakra.
 * Este tipo de item fornece força extra ao utilizador, mas requer uma quantidade específica de chakra.
 */
public class AtaqueChakra extends Item {
    private double forcaExtra; // Quantidade de ataque adicional que o ataque fornece
    private double chakraNecessario; // Quantidade de chakra exigida para realizar o ataque

    /**
     * Construtor para criar um ataque baseado em chakra.
     *
     * @param nome              Nome do ataque.
     * @param tipo              Tipo do item (deverá ser do tipo CHAKRA).
     * @param forcaExtra        Força extra fornecida no ataque.
     * @param chakraNecessario  Chakra necessário para executar o ataque.
     */
    public AtaqueChakra(String nome, TipoItem tipo, double forcaExtra, double chakraNecessario) {
        super(nome, tipo);
        this.forcaExtra = forcaExtra;
        this.chakraNecessario = chakraNecessario;
    }

    /**
     * Retorna a força extra proporcionada pelo ataque.
     *
     * @return Valor de força adicional.
     */
    public double getForcaExtra() {
        return forcaExtra;
    }

    /**
     * Retorna a quantidade de chakra necessária para usar o ataque.
     *
     * @return Chakra exigido.
     */
    public double getChakraNecessario() {
        return chakraNecessario;
    }
}
