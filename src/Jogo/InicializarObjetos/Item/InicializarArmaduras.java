package Jogo.InicializarObjetos.Item;

import Itens.Armaduras.Armadura;
import Itens.Enum.TipoItem;
import Itens.Enum.TipoArmadura;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por criar e retornar a lista de armaduras disponíveis no jogo.
 * Inclui armaduras exclusivas (ex: do Sasuke, com spawn 0) e armaduras que o jogador pode encontrar.
 */
public class InicializarArmaduras {

    /**
     * Inicializa e retorna todas as armaduras que existem no jogo.
     *
     * @return Lista de armaduras.
     */
    public static List<Armadura> inicializarArmaduras() {
        List<Armadura> armaduras = new ArrayList<>();

        // Armaduras exclusivas do Sasuke – não devem ser encontradas no jogo
        Armadura armaduraSasukeCima = new Armadura("Manto Uchiha Superior", TipoItem.ARMADURA, TipoArmadura.CIMA, 40.0, 0);
        Armadura armaduraSasukeBaixo = new Armadura("Calças Táticas Uchiha", TipoItem.ARMADURA, TipoArmadura.BAIXO, 30.0, 0);

        // Armaduras disponíveis para o jogador (Naruto)

        // ░░░ ARMADURAS DE CIMA ░░░
        Armadura cima1 = new Armadura("Casaco do Sábio", TipoItem.ARMADURA, TipoArmadura.CIMA, 60.0, 0);
        Armadura cima2 = new Armadura("Manto Reforçado de Konoha", TipoItem.ARMADURA, TipoArmadura.CIMA, 45.0, 0);
        Armadura cima3 = new Armadura("Jaqueta de Treinamento Chunin", TipoItem.ARMADURA, TipoArmadura.CIMA, 30.0, 0);

        // ░░░ ARMADURAS DE BAIXO ░░░
        Armadura baixo1 = new Armadura("Calças do Sábio dos Seis Caminhos", TipoItem.ARMADURA, TipoArmadura.BAIXO, 60.0, 0);
        Armadura baixo2 = new Armadura("Calças da Anbu", TipoItem.ARMADURA, TipoArmadura.BAIXO, 45.0, 0);
        Armadura baixo3 = new Armadura("Calças de Campo Ninja", TipoItem.ARMADURA, TipoArmadura.BAIXO, 30.0, 0);

        // Adicionar todas as armaduras à lista
        armaduras.add(armaduraSasukeCima);
        armaduras.add(armaduraSasukeBaixo);
        armaduras.add(cima1);
        armaduras.add(cima2);
        armaduras.add(cima3);
        armaduras.add(baixo1);
        armaduras.add(baixo2);
        armaduras.add(baixo3);

        return armaduras;
    }
}
