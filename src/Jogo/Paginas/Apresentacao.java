package Jogo.Paginas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static Utils.Som.*;
import static Utils.Som.stopWin;
import static Utils.Utils.*;
import static java.lang.Thread.sleep;

/**
 * Classe responsável por apresentar cenas e imagens principais
 * do início, créditos e estados finais do jogo.
 */
public class Apresentacao {  // imagem de apresentacao do jogo

    /**
     * Início do jogo: executa a introdução com som e imagens.
     */
    public static void inicio() throws IOException, InterruptedException {
        playIntro();
        apresentacao();
        intro();
        sasukeFugir();
        narutoTriste();
        stopIntro();
    }

    /**
     * Mostra a imagem inicial da apresentação.
     */
    public static void apresentacao() throws FileNotFoundException {
        cleanConsole();
        imprimirFicheiro("src/imagens/Apresentacao.txt");
        stop();
    }

    /**
     * Mostra a introdução da história com efeito de digitação.
     */
    public static void intro() throws IOException, InterruptedException {
        cleanConsole();
        imprimirFicheiroComDelay("src/imagens/Intro.txt", 20);
        stop();
    }

    /**
     * Mostra os créditos finais com som e imagem final.
     */
    public static void creditos() throws IOException, InterruptedException {
        stopAll();
        playCredits();
        cleanConsole();
        imprimirFicheiroComDelay("src/imagens/creditos.txt", 20);
        stop();
        cleanConsole();
        imprimirFicheiro("src/imagens/fim.txt");
        sleep(3000);
        stopCredits();
    }

    /**
     * Tela de vitória.
     */
    public static void win() throws IOException, InterruptedException {
        cleanConsole();
        imprimirFicheiroComDelay("src/imagens/Win.txt", 20);
        stop();
    }

    /**
     * Tela de derrota.
     */
    public static void lose() throws IOException, InterruptedException {
        cleanConsole();
        imprimirFicheiroComDelay("src/imagens/Lose.txt", 20);
        stop();
    }

    /**
     * Mostra Sasuke a fugir.
     */
    public static void sasukeFugir() throws FileNotFoundException, InterruptedException {
        cleanConsole();
        imprimirFicheiro("src/imagens/SasukeRun.txt");
        sleep(1000);
    }

    /**
     * Mostra Naruto triste após Sasuke fugir.
     */
    public static void narutoTriste() throws FileNotFoundException, InterruptedException {
        cleanConsole();
        imprimirFicheiro("src/imagens/NarutoCry.txt");
        sleep(1000);
    }
}
