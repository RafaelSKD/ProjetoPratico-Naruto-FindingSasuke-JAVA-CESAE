package Ninjas.NarutoSasuke;

import Itens.Especial.Especial;
import Ninjas.Enum.Afinidade;
import Ninjas.Ninja;
import Itens.Armaduras.Armadura;
import Itens.Armas.Arma;
import Itens.AtaqueChakra.AtaqueChakra;
import Itens.Consumiveis.Consumivel;

import java.util.ArrayList;

public class Naruto extends Ninja {

    private Arma arma; // so pode ter uma arma
    private Especial especial; // pode ter um item que aumenta algo fixo
    private Armadura cima; // pode ter uma armadura vestivel
    private Armadura baixo; // pode ter uma armadura vestivel
    private ArrayList<Consumivel> bolsa; // conjunto de consumiveis
    private AtaqueChakra ataqueEspecial1;
    private AtaqueChakra ataqueEspecial2;
    private double dinheiro;  // dinheiro que tem e pode ser roubado

    public Naruto(String nome, Afinidade afinidade, double chakra, double defesa, double ataque, double vida, double dinheiro) {
        super(nome, afinidade, chakra, defesa, ataque, vida);
        this.dinheiro = dinheiro;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public Especial getEspecial() {
        return especial;
    }

    public void setEspecial(Especial especial) {
        this.especial = especial;
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

    public ArrayList<Consumivel> getBolsa() {
        return bolsa;
    }

    public void setBolsa(ArrayList<Consumivel> bolsa) {
        this.bolsa = bolsa;
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

    public double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }
}
