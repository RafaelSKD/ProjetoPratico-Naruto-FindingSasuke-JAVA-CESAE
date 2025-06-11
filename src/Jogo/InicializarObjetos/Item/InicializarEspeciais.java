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
        especiais.add(new Especial("Selo Amaldiçoado de Orochimaru", TipoItem.ESPECIAL, 20.0, 5.0)); // +20% força
        especiais.add(new Especial("Orbe de Chakra das Bestas com Cauda", TipoItem.ESPECIAL, 10.0, 10.0)); // +10% força
        especiais.add(new Especial("Olho do Mangekyou Sharingan", TipoItem.ESPECIAL, 25.0, 4.0)); // aumenta ataque especial
        especiais.add(new Especial("Marca do Sábio", TipoItem.ESPECIAL, 30.0, 3.0)); // aumento total de status
        especiais.add(new Especial("Coroa da Sálvia de Myōboku", TipoItem.ESPECIAL, 20.0, 6.0)); // regenera chakra com o tempo

        return especiais;
    }
}
