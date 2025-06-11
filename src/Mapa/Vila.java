package Mapa;

import Ninjas.Enum.Localizacao;
import Ninjas.NPC.Bons.Amigo;
import Ninjas.Ninja;

import java.util.ArrayList;

public class Vila {
    private String nome; // nome da vila
    private Localizacao localizacao; // onde a vila esta no mapa
    private ArrayList<Ninja> listaNinjas; // lista de possiveis inimigos, amigos e se tem ou nao o sasuke

    public Vila(String nome, Localizacao localizacao) {
        this.nome = nome;
        this.localizacao = localizacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public ArrayList<Ninja> getListaNinjas() {
        return listaNinjas;
    }

    public void setListaNinjas(ArrayList<Ninja> listaNinjas) {
        this.listaNinjas = listaNinjas;
    }

    public void addSasuke(Ninja sasuke){
        this.listaNinjas.add(sasuke);
    }

    public void morto(Ninja inimigoMorto){
        this.listaNinjas.remove(inimigoMorto);
    }
}
