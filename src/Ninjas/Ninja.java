package Ninjas;

import Ninjas.Enum.Afinidade;

public abstract class Ninja {  //super classe para todos os caracteres!

    private String nome;  // nome da personagem
    private Afinidade afinidade;  // afinidade de chakra para ter ou nao vantagem na luta
    private double chakra;  // quantidade de chakra que permite usar especiais em combate
    private double defesa;  // defesa retira forca ao ataque do oponente
    private double ataque;  // forca do ataque sem buffers
    private double vida;  // quantidade de vida < 0 morre

    public Ninja(String nome, Afinidade afinidade, double chakra, double defesa, double ataque, double vida) {
        this.nome = nome;
        this.afinidade = afinidade;
        this.chakra = chakra;
        this.defesa = defesa;
        this.ataque = ataque;
        this.vida = vida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Afinidade getAfinidade() {
        return afinidade;
    }

    public void setAfinidade(Afinidade afinidade) {
        this.afinidade = afinidade;
    }

    public double getChakra() {
        return chakra;
    }

    public void setChakra(double chakra) {
        this.chakra = chakra;
    }

    public double getDefesa() {
        return defesa;
    }

    public void setDefesa(double defesa) {
        this.defesa = defesa;
    }

    public double getAtaque() {
        return ataque;
    }

    public void setAtaque(double ataque) {
        this.ataque = ataque;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

}
