package Jogo.InicializarObjetos.Mapa;

import Mapa.Vila;
import Ninjas.Enum.Localizacao;

import java.util.ArrayList;

public class InicializarMapa {
    public static ArrayList<Vila> inicializarMapa(){
        Vila vila1  = new Vila("Konohagakure (Vila da Folha)", Localizacao.CENTRAL);

        Vila vila2  = new Vila("Sunagakure (Vila da Areia)", Localizacao.SUDOESTE);
        Vila vila3  = new Vila("Otogakure (Vila do Som)", Localizacao.SUDOESTE);
        Vila vila4  = new Vila("Uzushiogakure (Vila do Redemoinho)", Localizacao.SUDOESTE);

        Vila vila5  = new Vila("Iwagakure (Vila da Pedra)", Localizacao.NOROESTE);
        Vila vila6  = new Vila("Shimogakure (Vila da Geada)", Localizacao.NOROESTE);
        Vila vila7  = new Vila("Kawagakure (Vila do Rio)", Localizacao.NOROESTE);

        Vila vila8  = new Vila("Kumogakure (Vila da Nuvem)", Localizacao.NORDESTE);
        Vila vila9  = new Vila("Hoshigakure (Vila da Estrela)", Localizacao.NORDESTE);

        Vila vila10 = new Vila("Kirigakure (Vila da Névoa)", Localizacao.SUDESTE);
        Vila vila11 = new Vila("Yukigakure (Vila da Neve)", Localizacao.SUDESTE);

        Vila vila12 = new Vila("Amegakure (Vila da Chuva)", Localizacao.CENTRALORIENTE);
        Vila vila13 = new Vila("Kusagakure (Vila da Grama)", Localizacao.CENTRALORIENTE);
        Vila vila14 = new Vila("Takigakure (Vila da Cachoeira)", Localizacao.CENTRALORIENTE);

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
