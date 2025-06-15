package Jogo.InicializarObjetos.Item;

import Itens.Enum.TipoItem;
import Itens.Especial.Especial;
import Itens.Item;

import java.util.ArrayList;
import java.util.List;

public class InicializarEspeciais {

    public static List<Especial> inicializarEspeciais() {
        List<Especial> especiais = new ArrayList<>();

        // ░░░ ITENS ESPECIAIS ÚNICOS (baixa chance de drop, efeitos poderosos) ░░░
        especiais.add(new Especial("Selo Amaldiçoado de Orochimaru", TipoItem.ESPECIAL, 20.0, 5.0, 2000, false, true, false, false)); // +20% ataque
        especiais.add(new Especial("Orbe de Chakra das Bestas com Cauda", TipoItem.ESPECIAL, 10.0, 10.0, 2000, false, true, false, false)); // +10% ataque
        especiais.add(new Especial("Olho do Mangekyou Sharingan", TipoItem.ESPECIAL, 25.0, 4.0, 3000, false, true, false, false)); // + 25 ataque
        especiais.add(new Especial("Marca do Sábio", TipoItem.ESPECIAL, 30.0, 0, 0, true, true, true, true)); // aumento total de status
        especiais.add(new Especial("Coroa da Sálvia de Myōboku", TipoItem.ESPECIAL, 20.0, 6.0, 2000, false, false, false, true)); // +20% chakra
        especiais.add(new Especial("Elixir da Imortalidade de Kaguya", TipoItem.ESPECIAL, 40.0, 0.0, 0, true, false, false, false)); // +40% vida
        especiais.add(new Especial("Escama do Susanoo", TipoItem.ESPECIAL, 15, 10.0, 2500, false, false, true, false)); // +15% defesa
        especiais.add(new Especial("Cápsula de Regeneração de Tsunade", TipoItem.ESPECIAL, 25.0, 2.0, 1800, true, false, false, false)); // +25% vida
        especiais.add(new Especial("Túnica Protetora dos Seis Caminhos", TipoItem.ESPECIAL, 10.0, 8.0, 3000, true, false, true, true)); // +10% vida, defesa e chakra
        especiais.add(new Especial("Fragmento de Armadura de Hashirama", TipoItem.ESPECIAL, 20.0, 5.0, 2200, false, false, true, false)); // +20% defesa

        return especiais;
    }
}
