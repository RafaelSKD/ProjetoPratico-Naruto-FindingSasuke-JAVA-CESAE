package Jogo.InicializarObjetos.Item;

import Itens.Consumiveis.Consumivel;
import Itens.Enum.TipoConsumivel;
import Itens.Enum.TipoItem;
import Itens.Item;

import java.util.ArrayList;
import java.util.List;

public class InicializarConsumiveis {

    public static List<Consumivel> inicializarConsumiveis() {
        List<Consumivel> consumiveis = new ArrayList<>();

        // ░░░ CONSUMÍVEIS DE FORÇA ░░░
        consumiveis.add(new Consumivel("Pílula do Soldado Avançada", TipoItem.CONSUMIVEL, TipoConsumivel.ATAQUE, 15.0, 150.0, 12.0));
        consumiveis.add(new Consumivel("Essência do Tigre de Ferro", TipoItem.CONSUMIVEL, TipoConsumivel.ATAQUE, 20.0, 200.0, 8.0));
        consumiveis.add(new Consumivel("Elixir da Fúria Elemental", TipoItem.CONSUMIVEL, TipoConsumivel.ATAQUE, 30.0, 300.0, 5.0));
        consumiveis.add(new Consumivel("Licor do Dragão do Norte", TipoItem.CONSUMIVEL, TipoConsumivel.ATAQUE, 10.0, 100.0, 15.0));

        // ░░░ CONSUMÍVEIS DE CHAKRA ░░░
        consumiveis.add(new Consumivel("Esfera Azul de Chakra", TipoItem.CONSUMIVEL, TipoConsumivel.CHAKRA, 20.0, 120.0, 10.0));
        consumiveis.add(new Consumivel("Ampola de Energia Espiritual", TipoItem.CONSUMIVEL, TipoConsumivel.CHAKRA, 50.0, 300.0, 4.0));
        consumiveis.add(new Consumivel("Essência de Sálvia do Monte Myōboku", TipoItem.CONSUMIVEL, TipoConsumivel.CHAKRA, 30.0, 250.0, 6.0));
        consumiveis.add(new Consumivel("Semente de Meditação Uzumaki", TipoItem.CONSUMIVEL, TipoConsumivel.CHAKRA, 10.0, 90.0, 12.0));

        // ░░░ CONSUMÍVEIS DE VIDA ░░░
        consumiveis.add(new Consumivel("Pomada Ninja", TipoItem.CONSUMIVEL, TipoConsumivel.DEFESA, 10.0, 100.0, 15.0));
        consumiveis.add(new Consumivel("Soro Regenerativo ANBU", TipoItem.CONSUMIVEL, TipoConsumivel.DEFESA, 25.0, 220.0, 8.0));
        consumiveis.add(new Consumivel("Tônico de Pele de Madeira", TipoItem.CONSUMIVEL, TipoConsumivel.DEFESA, 40.0, 350.0, 5.0));
        consumiveis.add(new Consumivel("Pílula de Sobrevivência Total", TipoItem.CONSUMIVEL, TipoConsumivel.DEFESA, 100.0, 500.0, 2.0));

        return consumiveis;
    }
}
