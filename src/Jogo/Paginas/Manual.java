package Jogo.Paginas;

import java.io.FileNotFoundException;

import static Utils.Utils.*;

public class Manual {
    public static void manual() throws FileNotFoundException {
        cleanConsole();
        imprimirFicheiro("src/imagens/Manual.txt");
        stop("Pressionar qualquer tecla para continuar...  ");
    }
}
