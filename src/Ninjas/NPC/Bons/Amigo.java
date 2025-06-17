package Ninjas.NPC.Bons;

import Ninjas.Enum.Afinidade;
import Ninjas.Enum.Localizacao;
import Ninjas.Ninja;
import Itens.Item;

/**
 * Representa um ninja aliado (amigo) que pode ser encontrado no mapa.
 * Ele oferece ajuda ao jogador, geralmente fornecendo um item.
 */
public class Amigo extends Ninja {
    /** Localização onde o amigo aparece no mapa. */
    private Localizacao localizacao;

    /** Item que o amigo oferece (geralmente um consumível ou equipamento útil). */
    private Item item;

    /**
     * Construtor da classe Amigo.
     *
     * @param nome        Nome do amigo.
     * @param afinidade   Elemento principal do ninja (fogo, água, etc.).
     * @param chakra      Quantidade de chakra.
     * @param defesa      Valor de defesa.
     * @param ataque      Valor de ataque.
     * @param vida        Quantidade de vida.
     * @param localizacao Região do mapa onde o amigo será encontrado.
     */
    public Amigo(String nome, Afinidade afinidade, double chakra, double defesa, double ataque, double vida, Localizacao localizacao) {
        super(nome, afinidade, chakra, defesa, ataque, vida);
        this.localizacao = localizacao;
    }

    /**
     * Retorna a localização da vila onde o amigo aparece.
     * @return Localizacao da vila.
     */
    public Localizacao getLocalizacao() {
        return localizacao;
    }

    /**
     * Retorna o item que o amigo possui.
     * @return Item que será oferecido ao jogador.
     */
    public Item getItem() {
        return item;
    }

    /**
     * Define o item que o amigo possui.
     * @param item Item a ser atribuído ao amigo.
     */
    public void setItem(Item item) {
        this.item = item;
    }
}
