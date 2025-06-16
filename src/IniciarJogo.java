import Utils.Som;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static Jogo.Jogo.jogo;
import static Jogo.Menus.Navegacao.menuNavegacao;
import static Jogo.Menus.NovoJogo.menuNovoJogo;
import static Jogo.Paginas.Apresentacao.*;
import static Utils.Som.*;

public class IniciarJogo {
    public static void main(String[] args) throws IOException, InterruptedException {
        do {
//            playIntro();
//            inicio();
//            stopIntro();
            jogo();
            menuNavegacao();
            stopLose();
            stopWin();
        } while (menuNovoJogo() == 1);
        playCredits();
        creditos();
        stopCredits();
    }
}

