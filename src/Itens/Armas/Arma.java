package Itens.Armas;

import Itens.Enum.HabilidadeArma;
import Itens.Enum.TipoItem;
import Itens.Item;

public class Arma extends Item {
    private HabilidadeArma habilidade; // tipo de arma, se enfraquece defesa, se enfraquece ataque, ou especial
    private double forcaDoEfeito;
    private double ataqueArma; // quanto ataque adicional vai trazer ao utilizador
    private int spawn; // possibilidade de aparecer
    private double preco; // preco no mercado

    public Arma(String nome, TipoItem tipo, HabilidadeArma habilidade, double forcaDoEfeito, double ataqueArma, int spawn, double preco) {
        super(nome, tipo);
        this.habilidade = habilidade;
        this.forcaDoEfeito = forcaDoEfeito;
        this.ataqueArma = ataqueArma;
        this.spawn = spawn;
        this.preco = preco;
    }

    public int getSpawn() {
        return spawn;
    }

    public void setSpawn(int spawn) {
        this.spawn = spawn;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getAtaqueArma() {
        return ataqueArma;
    }

    public void setAtaqueArma(double ataqueArma) {
        this.ataqueArma = ataqueArma;
    }

    public HabilidadeArma getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(HabilidadeArma habilidade) {
        this.habilidade = habilidade;
    }

    public double getForcaDoEfeito() {
        return forcaDoEfeito;
    }

    public void setForcaDoEfeito(double forcaDoEfeito) {
        this.forcaDoEfeito = forcaDoEfeito;
    }
}
