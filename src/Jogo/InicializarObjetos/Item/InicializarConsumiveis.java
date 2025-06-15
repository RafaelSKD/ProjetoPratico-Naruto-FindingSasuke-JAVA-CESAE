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
        consumiveis.add(new Consumivel("Pílula do Soldado Avançada", TipoItem.CONSUMIVEL, TipoConsumivel.ATAQUE, 15.0, 200.0, 70.0));
        consumiveis.add(new Consumivel("Essência do Tigre de Ferro", TipoItem.CONSUMIVEL, TipoConsumivel.ATAQUE, 20.0, 300.0, 75.0));
        consumiveis.add(new Consumivel("Elixir da Fúria Elemental", TipoItem.CONSUMIVEL, TipoConsumivel.ATAQUE, 30.0, 400.0, 90.0));
        consumiveis.add(new Consumivel("Licor do Dragão do Norte", TipoItem.CONSUMIVEL, TipoConsumivel.ATAQUE, 10.0, 150.0, 65.0));


// ░░░ CONSUMÍVEIS DE CHAKRA ░░░
        consumiveis.add(new Consumivel("Esfera Azul de Chakra", TipoItem.CONSUMIVEL, TipoConsumivel.CHAKRA, 20.0, 200.0, 75.0));
        consumiveis.add(new Consumivel("Ampola de Energia Espiritual", TipoItem.CONSUMIVEL, TipoConsumivel.CHAKRA, 50.0, 400.0, 95.0));
        consumiveis.add(new Consumivel("Essência de Sálvia do Monte Myōboku", TipoItem.CONSUMIVEL, TipoConsumivel.CHAKRA, 30.0, 300.0, 85.0));
        consumiveis.add(new Consumivel("Semente de Meditação Uzumaki", TipoItem.CONSUMIVEL, TipoConsumivel.CHAKRA, 10.0, 150.0, 65.0));


// ░░░ CONSUMÍVEIS DE VIDA ░░░
        consumiveis.add(new Consumivel("Pomada Ninja", TipoItem.CONSUMIVEL, TipoConsumivel.VIDA, 10.0, 150.0, 65.0));
        consumiveis.add(new Consumivel("Soro Regenerativo ANBU", TipoItem.CONSUMIVEL, TipoConsumivel.VIDA, 25.0, 300.0, 80.0));
        consumiveis.add(new Consumivel("Tônico de Pele de Madeira", TipoItem.CONSUMIVEL, TipoConsumivel.VIDA, 40.0, 450.0, 90.0));
        consumiveis.add(new Consumivel("Pílula de Sobrevivência Total", TipoItem.CONSUMIVEL, TipoConsumivel.VIDA, 100.0, 700.0, 100.0));



        return consumiveis;

    }
}
