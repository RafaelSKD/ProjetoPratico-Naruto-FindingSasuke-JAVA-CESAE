package Ninjas;

import Ninjas.Enum.Afinidade;

/**
 * Classe abstrata que representa um ninja no universo do jogo.
 * Serve como superclasse para Naruto, Sasuke, Amigos e Inimigos.
 */
public abstract class Ninja {

    /** Nome do ninja. */
    private String nome;

    /** Afinidade elemental do ninja (Fogo, Água, etc.). */
    private Afinidade afinidade;

    /** Quantidade de chakra disponível para usar ataques especiais. */
    private double chakra;

    /** Valor de defesa que reduz o dano recebido. */
    private double defesa;

    /** Valor de ataque base do ninja. */
    private double ataque;

    /** Vida atual do ninja. Se for menor que 0, o ninja morre. */
    private double vida;

    /**
     * Construtor da classe Ninja.
     *
     * @param nome      Nome do ninja.
     * @param afinidade Afinidade elemental.
     * @param chakra    Quantidade de chakra.
     * @param defesa    Valor de defesa.
     * @param ataque    Valor de ataque.
     * @param vida      Quantidade de vida.
     */
    public Ninja(String nome, Afinidade afinidade, double chakra, double defesa, double ataque, double vida) {
        this.nome = nome;
        this.afinidade = afinidade;
        this.chakra = chakra;
        this.defesa = defesa;
        this.ataque = ataque;
        this.vida = vida;
    }

    /** @return o nome do ninja */
    public String getNome() {
        return nome;
    }

    /** @param nome define o nome do ninja */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /** @return a afinidade do ninja */
    public Afinidade getAfinidade() {
        return afinidade;
    }

    /** @param afinidade define a afinidade do ninja */
    public void setAfinidade(Afinidade afinidade) {
        this.afinidade = afinidade;
    }

    /** @return quantidade atual de chakra */
    public double getChakra() {
        return chakra;
    }

    /**
     * Define a quantidade de chakra.
     * Máximo permitido: 1000.
     * @param chakra nova quantidade de chakra
     */
    public void setChakra(double chakra) {
        if (chakra > 1000)
            chakra = 1000;
        this.chakra = chakra;
    }

    /** @return valor de defesa atual */
    public double getDefesa() {
        return defesa;
    }

    /** @param defesa define o valor de defesa */
    public void setDefesa(double defesa) {
        this.defesa = defesa;
    }

    /** @return valor de ataque atual */
    public double getAtaque() {
        return ataque;
    }

    /**
     * Define o valor de ataque.
     * Máximo permitido: 1000.
     * @param ataque novo valor de ataque
     */
    public void setAtaque(double ataque) {
        if (ataque > 1000)
            ataque = 1000;
        this.ataque = ataque;
    }

    /** @return vida atual do ninja */
    public double getVida() {
        return vida;
    }

    /**
     * Define a vida do ninja.
     * Máximo permitido: 2000.
     * @param vida nova quantidade de vida
     */
    public void setVida(double vida) {
        if (vida > 2000)
            vida = 2000;
        this.vida = vida;
    }
}
