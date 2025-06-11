package Itens.Consumiveis;

import Itens.Enum.TipoConsumivel;
import Itens.Enum.TipoItem;
import Itens.Item;

public class Consumivel extends Item {
    private TipoConsumivel tipoConsumivel; // ATAQUE,DEFESA,CHAKRA,ESPECIAL
    private double percentagemEfeito; //percentagem que faz o efeito
    private double preco; // preco no mercado
    private double spawn; // possibilidade de aparecer no mapa em %

    public Consumivel(String nome, TipoItem tipo, TipoConsumivel tipoConsumivel, double percentagemEfeito, double preco, double spawn) {
        super(nome, tipo);
        this.tipoConsumivel = tipoConsumivel;
        this.percentagemEfeito = percentagemEfeito;
        this.preco = preco;
        this.spawn = spawn;
    }

    public TipoConsumivel getTipoConsumivel() {
        return tipoConsumivel;
    }

    public void setTipoConsumivel(TipoConsumivel tipoConsumivel) {
        this.tipoConsumivel = tipoConsumivel;
    }

    public double getPercentagemEfeito() {
        return percentagemEfeito;
    }

    public void setPercentagemEfeito(double percentagemEfeito) {
        this.percentagemEfeito = percentagemEfeito;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getSpawn() {
        return spawn;
    }

    public void setSpawn(double spawn) {
        this.spawn = spawn;
    }
}
