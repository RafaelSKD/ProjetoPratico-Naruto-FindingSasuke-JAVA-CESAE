package Mapa;

import Ninjas.Enum.Localizacao;
import Ninjas.NPC.Bons.Amigo;
import Ninjas.Ninja;

import java.util.ArrayList;

/**
 * Representa uma vila no mundo do jogo, contendo uma lista de ninjas (amigos, inimigos ou Sasuke)
 * e sua localização no mapa.
 */
public class Vila {
    private String nome; // Nome da vila
    private Localizacao localizacao; // Localização geográfica da vila no mapa
    private ArrayList<Ninja> listaNinjas = new ArrayList<>(); // Lista de ninjas presentes na vila

    /**
     * Construtor para criar uma vila com nome e localização especificados.
     *
     * @param nome nome da vila
     * @param localizacao localização geográfica da vila
     */
    public Vila(String nome, Localizacao localizacao) {
        this.nome = nome;
        this.localizacao = localizacao;
    }

    /**
     * Retorna o nome da vila.
     *
     * @return nome da vila
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define um novo nome para a vila.
     *
     * @param nome novo nome da vila
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna a localização da vila.
     *
     * @return localização da vila
     */
    public Localizacao getLocalizacao() {
        return localizacao;
    }

    /**
     * Retorna a lista de ninjas presentes na vila.
     *
     * @return lista de ninjas
     */
    public ArrayList<Ninja> getListaNinjas() {
        return listaNinjas;
    }

    /**
     * Adiciona Sasuke (ou outro ninja) à vila.
     *
     * @param sasuke o ninja a ser adicionado (espera-se que seja Sasuke, mas permite qualquer ninja)
     */
    public void addSasuke(Ninja sasuke){
        this.listaNinjas.add(sasuke);
    }

    /**
     * Remove um ninja da vila, representando sua morte ou saída.
     *
     * @param morto ninja a ser removido da lista
     */
    public void morto(Ninja morto){
        this.listaNinjas.remove(morto);
    }
}
