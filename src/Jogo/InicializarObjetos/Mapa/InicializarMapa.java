package Jogo.InicializarObjetos.Mapa;

import Mapa.Vila;
import Ninjas.Enum.Localizacao;

import java.util.ArrayList;

/**
 * Classe responsável por inicializar o mapa do jogo com todas as vilas.
 * Cada vila é associada a uma localização estratégica do mundo ninja.
 */
public class InicializarMapa {

    /**
     * Cria e retorna uma lista com todas as vilas do mundo ninja, organizadas por região.
     *
     * @return Lista de objetos do tipo Vila.
     */
    public static ArrayList<Vila> inicializarMapa() {
        // ░░░ CENTRAL ░░░
        Vila vila1 = new Vila("Konohagakure (Vila da Folha)", Localizacao.CENTRAL);

        // ░░░ SUDOESTE ░░░
        Vila vila2 = new Vila("Sunagakure (Vila da Areia)", Localizacao.SUDOESTE);
        Vila vila3 = new Vila("Otogakure (Vila do Som)", Localizacao.SUDOESTE);
        Vila vila4 = new Vila("Uzushiogakure (Vila do Redemoinho)", Localizacao.SUDOESTE);

        // ░░░ NOROESTE ░░░
        Vila vila5 = new Vila("Iwagakure (Vila da Pedra)", Localizacao.NOROESTE);
        Vila vila6 = new Vila("Shimogakure (Vila da Geada)", Localizacao.NOROESTE);
        Vila vila7 = new Vila("Kawagakure (Vila do Rio)", Localizacao.NOROESTE);

        // ░░░ NORDESTE ░░░
        Vila vila8 = new Vila("Kumogakure (Vila da Nuvem)", Localizacao.NORDESTE);
        Vila vila9 = new Vila("Hoshigakure (Vila da Estrela)", Localizacao.NORDESTE);

        // ░░░ SUDESTE ░░░
        Vila vila10 = new Vila("Kirigakure (Vila da Névoa)", Localizacao.SUDESTE);
        Vila vila11 = new Vila("Yukigakure (Vila da Neve)", Localizacao.SUDESTE);

        // ░░░ CENTRAL-ORIENTE ░░░
        Vila vila12 = new Vila("Amegakure (Vila da Chuva)", Localizacao.CENTRALORIENTE);
        Vila vila13 = new Vila("Kusagakure (Vila da Grama)", Localizacao.CENTRALORIENTE);
        Vila vila14 = new Vila("Takigakure (Vila da Cachoeira)", Localizacao.CENTRALORIENTE);

        // Lista final de vilas
        ArrayList<Vila> listaVilas = new ArrayList<>();
        listaVilas.add(vila1);
        listaVilas.add(vila2);
        listaVilas.add(vila3);
        listaVilas.add(vila4);
        listaVilas.add(vila5);
        listaVilas.add(vila6);
        listaVilas.add(vila7);
        listaVilas.add(vila8);
        listaVilas.add(vila9);
        listaVilas.add(vila10);
        listaVilas.add(vila11);
        listaVilas.add(vila12);
        listaVilas.add(vila13);
        listaVilas.add(vila14);

        return listaVilas;
    }
}
