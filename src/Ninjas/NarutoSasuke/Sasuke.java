package Ninjas.NarutoSasuke;

import Itens.Armaduras.Armadura;
import Itens.Armas.Arma;
import Itens.AtaqueChakra.AtaqueChakra;
import Ninjas.Enum.Afinidade;
import Ninjas.Ninja;

/**
 * Representa Sasuke, personagem controlado pelo jogo, com atributos únicos e ataques especiais.
 * Herda da classe Ninja.
 */
public class Sasuke extends Ninja {
    private Arma arma; // Arma equipada (ex: Kusanagi)
    private Armadura cima; // Parte superior da armadura (ex: Manto Uchiha Superior)
    private Armadura baixo; // Parte inferior da armadura (ex: Calças Táticas Uchiha)
    private AtaqueChakra ataqueEspecial1; // Primeiro jutsu especial (ex: Chidori)
    private AtaqueChakra ataqueEspecial2; // Segundo jutsu especial (ex: Amaterasu)

    /**
     * Construtor de Sasuke com os parâmetros principais.
     */
    public Sasuke(String nome, Afinidade afinidade, double chakra, double defesa, double ataque, double vida) {
        super(nome, afinidade, chakra, defesa, ataque, vida);
    }

    // Getters e setters dos equipamentos e ataques

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
