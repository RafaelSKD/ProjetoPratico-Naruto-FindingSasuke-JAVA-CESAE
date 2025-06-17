package Jogo.Menus;

/**
 * Classe de utilitários gráficos para exibir headers decorativos no terminal.
 * Utilizada para embelezar e estruturar menus do jogo Naruto.
 */
public class Utils {

    /**
     * Imprime o cabeçalho ASCII para o menu de navegação do jogo.
     */
    public static void headerNavegacao() {
        // Arte ASCII decorativa para o menu de navegação
        System.out.println("( ___ )--------------------------------------------------------------------------------------------------------------------------------------------( ___ )");
        System.out.println(" |   |                             _       _               _____    _      _                                        _                               |   | ");
        System.out.println(" |   |                            | |_   _| |_ ___ _   _  |_   _|__| | ___| |_ _ __ __ _ _ __  ___ _ __   ___  _ __| |_ ___                         |   | ");
        System.out.println(" |   |                         _  | | | | | __/ __| | | |   | |/ _ \\ |/ _ \\ __| '__/ _` | '_ \\/ __| '_ \\ / _ \\| '__| __/ _ \\                        |   | ");
        System.out.println(" |   |                        | |_| | |_| | |_\\__ \\ |_| |   | |  __/ |  __/ |_| | | (_| | | | \\__ \\ |_) | (_) | |  | ||  __/                        |   | ");
        System.out.println(" |   |                         \\___/ \\__,_|\\__|___/\\__,_|   |_|\\___|_|\\___|\\__|_|  \\__,_|_| |_|___/ .__/ \\___/|_|   \\__\\___|                        |   | ");
        System.out.println(" |   |                                                                                            |_|                                               |   | ");
        System.out.println(" |___|                                                                                                                                              |___| ");
        System.out.println("(_____)--------------------------------------------------------------------------------------------------------------------------------------------(_____)");
    }

    /**
     * Imprime o cabeçalho ASCII para o menu da vila de Konoha.
     */
    public static void headerKonoha() {
        // Arte ASCII decorativa para a vila de Konoha
        System.out.println("( ___ )--------------------------------------------------------------------------------------------------------------------------------------------( ___ )");
        System.out.println(" |   |                                                       _  _____  _   _  ___  _   _    _                                                       |   | ");
        System.out.println(" |   |                                                      | |/ / _ \\| \\ | |/ _ \\| | | |  / \\                                                      |   | ");
        System.out.println(" |   |                                                      | ' / | | |  \\| | | | | |_| | / _ \\                                                     |   | ");
        System.out.println(" |   |                                                      | . \\ |_| | |\\  | |_| |  _  |/ ___ \\                                                    |   | ");
        System.out.println(" |   |                                                      |_|\\_\\___/|_| \\_|\\___/|_| |_/_/   \\_\\                                                   |   | ");
        System.out.println(" |___|                                                                                                                                              |___| ");
        System.out.println("(_____)--------------------------------------------------------------------------------------------------------------------------------------------(_____)");
    }

    /**
     * Imprime o cabeçalho ASCII para o menu de novo jogo.
     */
    public static void headerNovoJogo() {
        // Arte ASCII decorativa para iniciar um novo jogo
        System.out.println("( ___ )-------------------------------------------------------------------------------------------------------------------------------------------( ___ )");
        System.out.println(" |   |                                               _   _                       _                                                                 |   | ");
        System.out.println(" |   |                                              | \\ | | _____   _____       | | ___   __ _  ___                                                |   | ");
        System.out.println(" |   |                                              |  \\| |/ _ \\ \\ / / _ \\   _  | |/ _ \\ / _` |/ _ \\                                               |   | ");
        System.out.println(" |   |                                              | |\\  | (_) \\ V / (_) | | |_| | (_) | (_| | (_) |                                              |   | ");
        System.out.println(" |   |                                              |_| \\_|\\___/ \\_/ \\___/   \\___/ \\___/ \\__, |\\___/                                               |   | ");
        System.out.println(" |   |                                                                                   |___/                                                     |   | ");
        System.out.println(" |___|                                                                                                                                             |___| ");
        System.out.println("(_____)-------------------------------------------------------------------------------------------------------------------------------------------(_____)");
    }

    /**
     * Imprime o cabeçalho ASCII para o menu da loja da personagem TenTen.
     */
    public static void headerTenTen() {
        // Arte ASCII decorativa da loja da TenTen
        System.out.println("( ___ )--------------------------------------------------------------------------------------------------------------------------------------------( ___ )");
        System.out.println(" |   |                                        _          _             _         _____        _____                                                 |   | ");
        System.out.println(" |   |                                       | |    ___ (_) __ _    __| | __ _  |_   _|__ _ _|_   _|__ _ __                                         |   | ");
        System.out.println(" |   |                                       | |   / _ \\| |/ _` |  / _` |/ _` |   | |/ _ \\ '_ \\| |/ _ \\ '_ \\                                        |   | ");
        System.out.println(" |   |                                       | |__| (_) | | (_| | | (_| | (_| |   | |  __/ | | | |  __/ | | |                                       |   | ");
        System.out.println(" |   |                                       |_____\\___// |\\__,_|  \\__,_|\\__,_|   |_|\\___|_| |_|_|\\___|_| |_|                                       |   | ");
        System.out.println(" |   |                                                |__/                                                                                          |   | ");
        System.out.println("(_____)--------------------------------------------------------------------------------------------------------------------------------------------(_____)");
    }

    /**
     * Imprime o cabeçalho ASCII para o menu do manual do jogo.
     */
    public static void headerManual() {
        // Arte ASCII decorativa para o menu do manual
        System.out.println("( ___ )-------------------------------------------------------------------------------------------------------------------------( ___ )");
        System.out.println(" |   |                                          __  __    _    _   _ _   _   _    _                                              |   | ");
        System.out.println(" |   |                                         |  \\/  |  / \\  | \\ | | | | | / \\  | |                                             |   | ");
        System.out.println(" |   |                                         | |\\/| | / _ \\ |  \\| | | | |/ _ \\ | |                                             |   | ");
        System.out.println(" |   |                                         | |  | |/ ___ \\| |\\  | |_| / ___ \\| |___                                          |   | ");
        System.out.println(" |   |                                         |_|  |_/_/   \\_\\_| \\_|\\___/_/   \\_\\_____|                                         |   | ");
        System.out.println(" |___|                                                                                                                           |___| ");
        System.out.println("(_____)-------------------------------------------------------------------------------------------------------------------------(_____)");
    }

    /**
     * Retorna uma string de espaços para alinhar texto de forma visualmente agradável.
     * @param str A string cuja largura será usada para calcular os espaços restantes
     * @return Uma string contendo espaços suficientes para completar 35 caracteres
     */
    public static String getSpaces(String str) {
        int spaces = 35 - str.length();
        return " ".repeat(Math.max(0, spaces));
    }
}
