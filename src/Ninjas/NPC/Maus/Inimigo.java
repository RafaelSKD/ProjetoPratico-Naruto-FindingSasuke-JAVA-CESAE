package Ninjas.NPC.Maus;

import Itens.AtaqueChakra.AtaqueChakra;
import Ninjas.Enum.Afinidade;
import Ninjas.Enum.Localizacao;
import Ninjas.Ninja;
import Itens.Armas.Arma;

/**
 * Representa um ninja inimigo que pode ser encontrado e enfrentado no mapa.
 * Possui uma arma, ataques especiais e uma quantidade de dinheiro que pode ser roubada.
 */
public class Inimigo extends Ninja {
    /** Localização onde o inimigo aparece no mapa. */
    private Localizacao localizacao;

    /** Arma equipada pelo inimigo (pode ser nula). */
    private Arma arma = null;

    /** Quantidade de dinheiro que o inimigo possui (pode ser roubado). */
    private double dinheiro;

    /** Primeiro ataque especial baseado em chakra. */
    private AtaqueChakra ataqueEspecial1;

    /** Segundo ataque especial baseado em chakra. */
    private AtaqueChakra ataqueEspecial2;

    /**
     * Construtor do inimigo.
     *
     * @param nome        Nome do inimigo.
     * @param afinidade   Elemento do inimigo (fogo, água, etc.).
     * @param chakra      Quantidade de chakra.
     * @param defesa      Valor de defesa.
     * @param ataque      Valor de ataque.
     * @param vida        Quantidade de vida.
     * @param dinheiro    Dinheiro que possui.
     * @param localizacao Região onde o inimigo se encontra no mapa.
     */
    public Inimigo(String nome, Afinidade afinidade, double chakra, double defesa, double ataque, double vida, double dinheiro, Localizacao localizacao) {
        super(nome, afinidade, chakra, defesa, ataque, vida);
        this.localizacao = localizacao;
        this.dinheiro = dinheiro;
    }

    /**
     * Obtém o valor de dinheiro que o inimigo possui.
     * @return Dinheiro atual do inimigo.
     */
    public double getDinheiro() {
        return dinheiro;
    }

    /**
     * Obtém a localização do inimigo no mapa.
     * @return Localização onde o inimigo está.
     */
    public Localizacao getLocalizacao() {
        return localizacao;
    }

    /**
     * Retorna a arma equipada pelo inimigo.
     * @return Arma equipada.
     */
    public Arma getArma() {
        return arma;
    }

    /**
     * Define a arma equipada pelo inimigo.
     * @param arma Arma a ser equipada.
     */
    public void setArma(Arma arma) {
        this.arma = arma;
    }

    /**
     * Retorna o primeiro ataque especial do inimigo.
     * @return Primeiro ataque de chakra.
     */
    public AtaqueChakra getAtaqueEspecial1() {
        return ataqueEspecial1;
    }

    /**
     * Define o primeiro ataque especial.
     * @param ataqueEspecial1 Ataque baseado em chakra.
     */
    public void setAtaqueEspecial1(AtaqueChakra ataqueEspecial1) {
        this.ataqueEspecial1 = ataqueEspecial1;
    }

    /**
     * Retorna o segundo ataque especial do inimigo.
     * @return Segundo ataque de chakra.
     */
    public AtaqueChakra getAtaqueEspecial2() {
        return ataqueEspecial2;
    }

    /**
     * Define o segundo ataque especial.
     * @param ataqueEspecial2 Ataque baseado em chakra.
     */
    public void setAtaqueEspecial2(AtaqueChakra ataqueEspecial2) {
        this.ataqueEspecial2 = ataqueEspecial2;
    }
}
