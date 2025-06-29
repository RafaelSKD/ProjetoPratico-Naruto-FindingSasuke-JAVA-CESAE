package Jogo.InicializarObjetos.Item;

import Itens.Armas.Arma;
import Itens.Enum.HabilidadeArma;
import Itens.Enum.TipoItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por inicializar todas as armas disponíveis no jogo.
 * Divide armas entre aquelas que o jogador (Naruto) pode obter e armas de NPCs.
 */
public class InicializarArmas {

    /**
     * Cria e retorna uma lista com todas as armas que existem no jogo.
     *
     * @return Lista de armas inicializadas.
     */
    public static List<Arma> inicializarArmas() {
        List<Arma> armas = new ArrayList<>();

        // ░░░ ARMAS DO NARUTO (POSSUÍVEIS DE ADQUIRIR) ░░░
        armas.add(new Arma("Kusarigama de Chakra", TipoItem.ARMA, HabilidadeArma.ATAQUE, 0, 50, 10, 1000));
        armas.add(new Arma("Bastão do Sábio dos Seis Caminhos", TipoItem.ARMA, HabilidadeArma.DEFESA, 0, 100, 10, 2000));
        armas.add(new Arma("Shuriken Elementais Gigantes", TipoItem.ARMA, HabilidadeArma.ATAQUE, 0, 80, 60, 600));
        armas.add(new Arma("Cajado Tessen", TipoItem.ARMA, HabilidadeArma.ATAQUE, 0, 80, 10, 500));
        armas.add(new Arma("Flechas de Chakra", TipoItem.ARMA, HabilidadeArma.ESPECIAL, 0, 10, 20, 650));
        armas.add(new Arma("Samehada", TipoItem.ARMA, HabilidadeArma.ESPECIAL, 0, 120, 0, 1650));
        armas.add(new Arma("Kunai Especial do Minato", TipoItem.ARMA, HabilidadeArma.ESPECIAL, 0, 75, 50, 700));
        armas.add(new Arma("Shuriken", TipoItem.ARMA, HabilidadeArma.ATAQUE, 0, 50, 45, 300));

        // ░░░ ARMAS DOS NPCs (NÃO ADQUIRÍVEIS, USA-SE EM OPONENTES) ░░░
        armas.add(new Arma("Cabaça de Areia", TipoItem.ARMA, HabilidadeArma.DEFESA, 40, 80, 0, 1000));
        armas.add(new Arma("Marionete Karasu", TipoItem.ARMA, HabilidadeArma.ESPECIAL, 15, 90, 0, 1000));
        armas.add(new Arma("Marionetes Humanas", TipoItem.ARMA, HabilidadeArma.ESPECIAL, 25, 70, 0, 1000));
        armas.add(new Arma("Lâminas Médicas", TipoItem.ARMA, HabilidadeArma.ATAQUE, 10, 40, 0, 1000));
        armas.add(new Arma("Kusanagi", TipoItem.ARMA, HabilidadeArma.ATAQUE, 35, 50, 0, 1000));
        armas.add(new Arma("Sensor Ninja", TipoItem.ARMA, HabilidadeArma.ESPECIAL, 5, 100, 0, 1000));
        armas.add(new Arma("Estilo de Poeira", TipoItem.ARMA, HabilidadeArma.ESPECIAL, 60, 0, 0, 1000));
        armas.add(new Arma("Liberação de Lava", TipoItem.ARMA, HabilidadeArma.ESPECIAL, 45, 0, 0, 1000));
        armas.add(new Arma("Argila Explosiva", TipoItem.ARMA, HabilidadeArma.ESPECIAL, 55, 10, 0, 1000));
        armas.add(new Arma("Estilo Vapor", TipoItem.ARMA, HabilidadeArma.ESPECIAL, 40, 20, 0, 1000));
        armas.add(new Arma("Estilo de Terra", TipoItem.ARMA, HabilidadeArma.DEFESA, 20, 70, 0, 1000));
        armas.add(new Arma("Punhos Elétricos", TipoItem.ARMA, HabilidadeArma.ATAQUE, 45, 20, 0, 1000));
        armas.add(new Arma("Espada com Liberação de Relâmpago", TipoItem.ARMA, HabilidadeArma.ATAQUE, 50, 10, 0, 1000));
        armas.add(new Arma("Espadas Acrobáticas", TipoItem.ARMA, HabilidadeArma.ATAQUE, 55, 0, 0, 1000));
        armas.add(new Arma("Estilo Gato Demoníaco", TipoItem.ARMA, HabilidadeArma.ESPECIAL, 30, 40, 0, 1000));
        armas.add(new Arma("Liberação de Estrela", TipoItem.ARMA, HabilidadeArma.ESPECIAL, 25, 60, 0, 1000));
        armas.add(new Arma("Kubikiribōchō", TipoItem.ARMA, HabilidadeArma.ATAQUE, 60, 20, 0, 1000));
        armas.add(new Arma("Senbons", TipoItem.ARMA, HabilidadeArma.ATAQUE, 10, 10, 0, 1000));
        armas.add(new Arma("Hiramekarei", TipoItem.ARMA, HabilidadeArma.ESPECIAL, 45, 50, 0, 1000));
        armas.add(new Arma("Espada Explosiva", TipoItem.ARMA, HabilidadeArma.ATAQUE, 50, 20, 0, 1000));
        armas.add(new Arma("Espadas Trovão", TipoItem.ARMA, HabilidadeArma.ATAQUE, 40, 30, 0, 1000));
        armas.add(new Arma("Estilo Neve", TipoItem.ARMA, HabilidadeArma.ESPECIAL, 20, 60, 0, 1000));
        armas.add(new Arma("Seis Caminhos de Pain", TipoItem.ARMA, HabilidadeArma.ESPECIAL, 60, 60, 0, 1000));
        armas.add(new Arma("Jutsus de Papel", TipoItem.ARMA, HabilidadeArma.ESPECIAL, 35, 45, 0, 1000));
        armas.add(new Arma("Kusarigama", TipoItem.ARMA, HabilidadeArma.ATAQUE, 25, 25, 0, 1000));
        armas.add(new Arma("Armadilhas", TipoItem.ARMA, HabilidadeArma.ESPECIAL, 15, 60, 0, 1000));

        return armas;
    }
}
