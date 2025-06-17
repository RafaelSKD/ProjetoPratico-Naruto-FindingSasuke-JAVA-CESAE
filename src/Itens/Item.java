package Itens;

import Itens.Enum.TipoItem;

/**
 * Classe base para todos os itens do jogo.
 * Define os atributos comuns, como nome e tipo.
 * É estendida por classes como Arma, Armadura, Consumível, etc.
 */
public class Item {
    private String nome;       // Nome do item
    private TipoItem tipo;     // Tipo do item (ARMADURA, ARMA, ATAQUEESPECIAL, CONSUMIVEL, ESPECIAL)

    /**
     * Construtor base para qualquer item.
     *
     * @param nome  Nome do item.
     * @param tipo  Tipo do item, definido pela enumeração TipoItem.
     */
    public Item(String nome, TipoItem tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    /**
     * Retorna o nome do item.
     *
     * @return Nome.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define ou altera o nome do item.
     *
     * @param nome Novo nome do item.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o tipo do item.
     *
     * @return Tipo definido na enum TipoItem.
     */
    public TipoItem getTipo() {
        return tipo;
    }

    /**
     * Define ou altera o tipo do item.
     *
     * @param tipo Novo tipo do item.
     */
    public void setTipo(TipoItem tipo) {
        this.tipo = tipo;
    }
}
