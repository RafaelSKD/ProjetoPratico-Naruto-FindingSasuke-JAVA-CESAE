package Itens.Especial;

import Itens.Enum.TipoItem;
import Itens.Item;

public class Especial extends Item {
    private double percentagemEfeito; //percentagem que faz o efeito
    private double spawn; // possibilidade de aparecer no mapa em %

    public Especial(String nome, TipoItem tipo, double percentagemEfeito, double spawn) {
        super(nome, tipo);
        this.percentagemEfeito = percentagemEfeito;
        this.spawn = spawn;
    }

    public double getPercentagemEfeito() {
        return percentagemEfeito;
    }

    public void setPercentagemEfeito(double percentagemEfeito) {
        this.percentagemEfeito = percentagemEfeito;
    }

    public double getSpawn() {
        return spawn;
    }

    public void setSpawn(double spawn) {
        this.spawn = spawn;
    }
}
