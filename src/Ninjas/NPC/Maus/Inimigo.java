package Ninjas.NPC.Maus;

import Itens.AtaqueChakra.AtaqueChakra;
import Ninjas.Enum.Afinidade;
import Ninjas.Enum.Localizacao;
import Ninjas.Ninja;
import Itens.Armas.Arma;

public class Inimigo extends Ninja {
    private Localizacao localizacao;// zona do mapa de spawn
    private Arma arma = null; // so pode ter uma arma
    private double dinheiro;  // dinheiro que tem e pode ser roubado
    private AtaqueChakra ataqueEspecial1;
    private AtaqueChakra ataqueEspecial2;

    public Inimigo(String nome, Afinidade afinidade, double chakra, double defesa, double ataque, double vida, double dinheiro, Localizacao localizacao) {
        super(nome, afinidade, chakra, defesa, ataque, vida);
        this.localizacao = localizacao;
        this.dinheiro = dinheiro;
    }

    public double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public AtaqueChakra getAtaqueEspecial1() {
        return ataqueEspecial1;
    }

    public void setAtaqueEspecial1(AtaqueChakra ataqueEspecial1) {
        this.ataqueEspecial1 = ataqueEspecial1;
    }

    public AtaqueChakra getAtaqueEspecial2() {
        return ataqueEspecial2;
    }

    public void setAtaqueEspecial2(AtaqueChakra ataqueEspecial2) {
        this.ataqueEspecial2 = ataqueEspecial2;
    }
}
