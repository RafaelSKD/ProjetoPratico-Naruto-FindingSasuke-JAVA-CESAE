import java.io.FileNotFoundException;
import java.io.IOException;

import static Jogo.Jogo.jogo;
import static Jogo.Menus.Navegacao.menuNavegacao;
import static Jogo.Menus.NovoJogo.menuNovoJogo;
import static Jogo.Paginas.Apresentacao.*;

public class IniciarJogo {
    public static void main(String[] args) throws IOException, InterruptedException {
        do {
            inicio();
            jogo();
            menuNavegacao();
        }while (menuNovoJogo() == 1);
        creditos();
    }
}
