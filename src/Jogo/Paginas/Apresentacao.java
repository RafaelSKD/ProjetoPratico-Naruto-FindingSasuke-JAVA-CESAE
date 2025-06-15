package Jogo.Paginas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static Utils.Utils.*;
import static java.lang.Thread.sleep;

public class Apresentacao {  // imagem de apresentacao do jogo

    public static void inicio() throws IOException, InterruptedException {
//        apresentacao();
//        intro();
//        sasukeFugir();
//        narutoTriste();
    }

    public static void apresentacao() throws FileNotFoundException {
        cleanConsole();
        imprimirFicheiro("src/imagens/Apresentacao.txt");
        stop("Pressionar qualquer tecla para continuar...  ");
    }

    public static void intro() throws IOException, InterruptedException {
        cleanConsole();
        imprimirFicheiroComDelay("src/imagens/Intro.txt", 20);
        stop("Pressionar qualquer tecla para continuar...  ");
    }

    public static void creditos() throws IOException, InterruptedException {
        cleanConsole();
        imprimirFicheiroComDelay("src/imagens/creditos.txt", 20);
        stop("Pressionar qualquer tecla para continuar...  ");
        cleanConsole();
        imprimirFicheiro("src/imagens/fim.txt");
        sleep(1000);
    }

    public static void win() throws IOException, InterruptedException {
        cleanConsole();
        imprimirFicheiroComDelay("src/imagens/Win.txt", 20);
        stop("Pressionar qualquer tecla para continuar...  ");
    }

    public static void lose() throws IOException, InterruptedException {
        cleanConsole();
        imprimirFicheiroComDelay("src/imagens/Lose.txt", 20);
        stop("Pressionar qualquer tecla para continuar...  ");
    }

    public static void sasukeFugir() throws FileNotFoundException, InterruptedException {
        cleanConsole();
        imprimirFicheiro("src/imagens/SasukeRun.txt");
        sleep(1000);
    }

    public static void narutoTriste() throws FileNotFoundException, InterruptedException {
        cleanConsole();
        imprimirFicheiro("src/imagens/NarutoCry.txt");
        sleep(1000);
    }
}
