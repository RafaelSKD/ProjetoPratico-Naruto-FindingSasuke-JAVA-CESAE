package Jogo.InicializarObjetos.Item;

import Itens.Consumiveis.Consumivel;
import Itens.Enum.TipoConsumivel;
import Itens.Enum.TipoItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por inicializar todos os itens consumíveis disponíveis no jogo.
 * Os consumíveis podem afetar o ataque, chakra ou vida do personagem.
 */
public class InicializarConsumiveis {

    /**
     * Cria e retorna uma lista de consumíveis, organizados por tipo de efeito.
     *
     * @return Lista de itens do tipo Consumível.
     */
    public static List<Consumivel> inicializarConsumiveis() {
        List<Consumivel> consumiveis = new ArrayList<>();

        // ░░░ CONSUMÍVEIS DE FORÇA (ATAQUE) ░░░
        consumiveis.add(new Consumivel("Pílula do Soldado Avançada", TipoItem.CONSUMIVEL, TipoConsumivel.ATAQUE, 15.0, 200.0, 70.0));
        consumiveis.add(new Consumivel("Essência do Tigre de Ferro", TipoItem.CONSUMIVEL, TipoConsumivel.ATAQUE, 20.0, 300.0, 45.0));
        consumiveis.add(new Consumivel("Elixir da Fúria Elemental", TipoItem.CONSUMIVEL, TipoConsumivel.ATAQUE, 30.0, 400.0, 90.0));
        consumiveis.add(new Consumivel("Licor do Dragão do Norte", TipoItem.CONSUMIVEL, TipoConsumivel.ATAQUE, 10.0, 150.0, 65.0));

        // ░░░ CONSUMÍVEIS DE CHAKRA ░░░
        consumiveis.add(new Consumivel("Esfera Azul de Chakra", TipoItem.CONSUMIVEL, TipoConsumivel.CHAKRA, 50.0, 200.0, 75.0));
        consumiveis.add(new Consumivel("Ampola de Energia Espiritual", TipoItem.CONSUMIVEL, TipoConsumivel.CHAKRA, 100.0, 350.0, 50.0));
        consumiveis.add(new Consumivel("Essência de Sálvia do Monte Myōboku", TipoItem.CONSUMIVEL, TipoConsumivel.CHAKRA, 300.0, 900.0, 25.0));
        consumiveis.add(new Consumivel("Semente de Meditação Uzumaki", TipoItem.CONSUMIVEL, TipoConsumivel.CHAKRA, 20.0, 100.0, 65.0));

        // ░░░ CONSUMÍVEIS DE VIDA ░░░
        consumiveis.add(new Consumivel("Pomada Ninja", TipoItem.CONSUMIVEL, TipoConsumivel.VIDA, 100.0, 100.0, 65.0));
        consumiveis.add(new Consumivel("Soro Regenerativo ANBU", TipoItem.CONSUMIVEL, TipoConsumivel.VIDA, 25.0, 25.0, 80.0));
        consumiveis.add(new Consumivel("Tônico de Pele de Madeira", TipoItem.CONSUMIVEL, TipoConsumivel.VIDA, 400.0, 450.0, 30.0));
        consumiveis.add(new Consumivel("Pílula de Sobrevivência Total", TipoItem.CONSUMIVEL, TipoConsumivel.VIDA, 1000.0, 700.0, 15.0));

        return consumiveis;
    }
}
