package Itens.Especial;

import Itens.Enum.TipoItem;
import Itens.Item;

public class Especial extends Item {
    private double efeito; //quantidade
    private double spawn; // possibilidade de aparecer no mapa em %
    private double preco;
    private boolean vida;
    private boolean ataque;
    private boolean defesa;
    private boolean chakra;

    public Especial(String nome, TipoItem tipo, double efeito, double spawn, double preco, boolean vida, boolean ataque, boolean defesa, boolean chakra) {
        super(nome, tipo);
        this.efeito = efeito;
        this.spawn = spawn;
        this.preco = preco;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.chakra = chakra;
    }

    public boolean isChakra() {
        return chakra;
    }

    public void setChakra(boolean chakra) {
        this.chakra = chakra;
    }

    public boolean isVida() {
        return vida;
    }

    public void setVida(boolean vida) {
        this.vida = vida;
    }

    public boolean isAtaque() {
        return ataque;
    }

    public void setAtaque(boolean ataque) {
        this.ataque = ataque;
    }

    public boolean isDefesa() {
        return defesa;
    }

    public void setDefesa(boolean defesa) {
        this.defesa = defesa;
    }

    public double getPreco() {
        return preco;
    }

    public double getEfeito() {
        return efeito;
    }

    public double getSpawn() {
        return spawn;
    }

}
