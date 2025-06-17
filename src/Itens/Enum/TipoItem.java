package Itens.Enum;

/**
 * Enumeração que define os tipos principais de itens disponíveis no sistema.
 * Cada tipo possui comportamentos e efeitos distintos no jogo.
 */
public enum TipoItem {
    ARMADURA,        // Itens defensivos que aumentam a resistência do utilizador
    ARMA,            // Itens ofensivos que aumentam o ataque e podem ter efeitos especiais
    ATAQUEESPECIAL,  // Ataques que consomem chakra e causam grande dano
    CONSUMIVEL,      // Itens de uso único que restauram ou aumentam atributos temporariamente
    ESPECIAL         // Itens de efeito contínuo (buff fixo) enquanto equipados; podem ultrapassar os limites máximos de ataque, vida ou chakra
}
