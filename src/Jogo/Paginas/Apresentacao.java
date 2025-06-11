package Jogo.Paginas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static Utils.Utils.*;

public class Apresentacao {  // imagem de apresentacao do jogo

    public static void inicio() throws IOException, InterruptedException {
        apresentacao();
//        iniciarNovoJogo();
        intro();
//        sasukeFugir();
//        narutoCorrer();
    }

    public static void apresentacao() throws FileNotFoundException {
        cleanConsole();
        imprimirFicheiro("src/imagens/Apresentacao.txt");
        stop("Pressionar qualquer tecla para continuar...  ");
    }

    public static void iniciarNovoJogo() throws FileNotFoundException {
        cleanConsole();
        imprimirFicheiro("src/imagens/Apresentacao.txt");
        stop("Pressionar qualquer tecla para continuar...  ");
    }

    public static void intro() throws IOException, InterruptedException {
        cleanConsole();
        imprimirFicheiroComDelay("src/imagens/Intro.txt", 20);
        stop("Pressionar qualquer tecla para continuar...  ");
    }

    public static void sasukeFugir() throws FileNotFoundException {
        cleanConsole();
        imprimirFicheiro("src/imagens/Apresentacao.txt");
        stop("Pressionar qualquer tecla para continuar...  ");
    }

    public static void narutoCorrer() throws FileNotFoundException {
        cleanConsole();
        imprimirFicheiro("src/imagens/Apresentacao.txt");
        stop("Pressionar qualquer tecla para continuar...  ");
    }
}
