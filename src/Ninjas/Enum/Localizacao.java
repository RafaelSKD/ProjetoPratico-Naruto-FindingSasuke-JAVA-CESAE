package Ninjas.Enum;

/**
 * Enumeração que representa as regiões do mapa onde as vilas podem estar localizadas.
 * A região CENTRAL está presente mas, por regra de jogo, apenas contém Konoha e nenhum inimigo.
 */
public enum Localizacao {
    /** Região central do mapa — contém apenas Konoha, sem inimigos */
    CENTRAL,

    /** Região central-oriental do mapa */
    CENTRALORIENTE,

    /** Região nordeste do mapa */
    NORDESTE,

    /** Região noroeste do mapa */
    NOROESTE,

    /** Região sudeste do mapa */
    SUDESTE,

    /** Região sudoeste do mapa */
    SUDOESTE
}
