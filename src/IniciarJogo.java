import java.io.IOException;

import static Jogo.Jogo.jogo;
import static Jogo.Menus.Navegacao.menuNavegacao;
import static Jogo.Menus.NovoJogo.menuNovoJogo;
import static Jogo.Paginas.Apresentacao.*;

/**
 * Classe principal que inicia o jogo "Naruto - Finding Sasuke".
 */
public class IniciarJogo {

    public static void main(String[] args) throws IOException, InterruptedException {
        do {
            inicio();           // Mostra a introdução do jogo (visual e sonora)
            jogo();             // Inicializa todos os dados (Naruto, Sasuke, vilas, inimigos, amigos, loja, etc.)
            menuNavegacao();    // Entra no menu de navegação e interação
        } while (menuNovoJogo() == 1); // Permite recomeçar o jogo se o jogador quiser
        creditos();            // Mostra os créditos finais
    }
}
