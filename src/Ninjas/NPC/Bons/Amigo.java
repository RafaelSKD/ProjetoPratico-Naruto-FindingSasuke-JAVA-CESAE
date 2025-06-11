package Ninjas.NPC.Bons;

import Ninjas.Enum.Afinidade;
import Ninjas.Enum.Localizacao;
import Ninjas.Ninja;
import Itens.Item;

public class Amigo extends Ninja {
    private Localizacao localizacao; // zona do mapa de spawn
    private Item item; // consumivel oferecido pelo personagem

    public Amigo(String nome, Afinidade afinidade, double chakra, double defesa, double ataque, double vida, Localizacao localizacao) {
        super(nome, afinidade, chakra, defesa, ataque, vida);
        this.localizacao = localizacao;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
