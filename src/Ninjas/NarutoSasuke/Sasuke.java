package Ninjas.NarutoSasuke;

import Itens.Armaduras.Armadura;
import Itens.Armas.Arma;
import Itens.AtaqueChakra.AtaqueChakra;
import Itens.Consumiveis.Consumivel;
import Itens.Especial.Especial;
import Ninjas.Enum.Afinidade;
import Ninjas.Ninja;

import java.util.ArrayList;

public class Sasuke extends Ninja {
    private Arma arma; // so pode ter uma arma
    private Armadura cima; // pode ter uma armadura vestivel
    private Armadura baixo; // pode ter uma armadura vestivel
    private AtaqueChakra ataqueEspecial1;
    private AtaqueChakra ataqueEspecial2;

    public Sasuke(String nome, Afinidade afinidade, double chakra, double defesa, double ataque, double vida) {
        super(nome, afinidade, chakra, defesa, ataque, vida);
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public Armadura getCima() {
        return cima;
    }

    public void setCima(Armadura cima) {
        this.cima = cima;
    }

    public Armadura getBaixo() {
        return baixo;
    }

    public void setBaixo(Armadura baixo) {
        this.baixo = baixo;
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
