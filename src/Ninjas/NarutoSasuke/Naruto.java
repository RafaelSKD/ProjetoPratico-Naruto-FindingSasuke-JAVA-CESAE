package Ninjas.NarutoSasuke;

import Itens.Especial.Especial;
import Ninjas.Enum.Afinidade;
import Ninjas.Ninja;
import Itens.Armaduras.Armadura;
import Itens.Armas.Arma;
import Itens.AtaqueChakra.AtaqueChakra;
import Itens.Consumiveis.Consumivel;

import java.util.ArrayList;

/**
 * Representa o personagem principal Naruto, com equipamento, ataques e inventário próprios.
 * Herda da classe Ninja.
 */
public class Naruto extends Ninja {

    private Arma arma; // Arma equipada (ex: kunai, bastão, etc.)
    private Especial especial; // Item especial que aplica boost fixo (ex: +5 ataque)
    private Armadura cima; // Parte superior da armadura equipada
    private Armadura baixo; // Parte inferior da armadura equipada
    private ArrayList<Consumivel> bolsa = new ArrayList<>(); // Itens consumíveis (ex: poções de vida)
    private AtaqueChakra ataqueEspecial1; // Primeiro jutsu de ataque (ex: Rasengan)
    private AtaqueChakra ataqueEspecial2; // Segundo jutsu de ataque (ex: Rasen-Shuriken)
    private double dinheiro;  // Dinheiro atual do jogador (pode ser gasto ou roubado)

    /**
     * Construtor principal de Naruto.
     */
    public Naruto(String nome, Afinidade afinidade, double chakra, double defesa, double ataque, double vida, double dinheiro) {
        super(nome, afinidade, chakra, defesa, ataque, vida);
        this.dinheiro = dinheiro;
    }

    // Getters e setters para todos os atributos

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

    /**
     * Adiciona um item consumível à bolsa de Naruto.
     * @param consumivel o item a ser adicionado.
     */
    public void addConsumivel(Consumivel consumivel) {
        if (bolsa == null) {
            bolsa = new ArrayList<>();
        }
        bolsa.add(consumivel);
    }
}
