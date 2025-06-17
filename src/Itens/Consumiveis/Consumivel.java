package Itens.Consumiveis;

import Itens.Enum.TipoConsumivel;
import Itens.Enum.TipoItem;
import Itens.Item;

/**
 * Representa um item consumível que pode ser utilizado para obter efeitos imediatos.
 * Pode afetar o ataque, defesa, chakra ou ter um efeito especial, conforme o seu tipo.
 */
public class Consumivel extends Item {
    private TipoConsumivel tipoConsumivel; // Define o tipo de efeito: ATAQUE, DEFESA, CHAKRA ou ESPECIAL
    private double efeito; // Quantidade do efeito aplicado (ex: +50 de chakra)
    private double preco; // Preço de compra do item no mercado
    private double spawn; // Probabilidade de aparecer na loja

    /**
     * Construtor para criar um novo consumível.
     *
     * @param nome            Nome do item.
     * @param tipo            Tipo do item (CONSUMIVEL).
     * @param tipoConsumivel  Tipo de efeito do consumível.
     * @param efeito          Quantidade do efeito gerado ao consumir.
     * @param preco           Preço de compra no mercado.
     * @param spawn           Probabilidade de aparecer disponível na loja.
     */
    public Consumivel(String nome, TipoItem tipo, TipoConsumivel tipoConsumivel, double efeito, double preco, double spawn) {
        super(nome, tipo);
        this.tipoConsumivel = tipoConsumivel;
        this.efeito = efeito;
        this.preco = preco;
        this.spawn = spawn;
    }

    /**
     * Retorna o tipo de efeito do consumível.
     *
     * @return Tipo do consumível (ATAQUE, DEFESA, etc.).
     */
    public TipoConsumivel getTipoConsumivel() {
        return tipoConsumivel;
    }

    /**
     * Retorna o valor do efeito causado pelo item.
     *
     * @return Quantidade do efeito.
     */
    public double getEfeito() {
        return efeito;
    }

    /**
     * Retorna o preço do item no mercado.
     *
     * @return Preço do item.
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Retorna a probabilidade do item aparecer na loja.
     *
     * @return Probabilidade de spawn.
     */
    public double getSpawn() {
        return spawn;
    }
}
