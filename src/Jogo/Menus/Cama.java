package Jogo.Menus;

import Jogo.Jogo;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static Jogo.Menus.Utils.headerKonoha;
import static Jogo.Menus.Utils.headerNovoJogo;
import static Utils.Utils.cleanConsole;
import static Utils.Utils.imprimirFicheiro;
import static java.lang.Thread.sleep;

public class Cama {
    public static void cama() throws InterruptedException, FileNotFoundException {
        Scanner input = new Scanner(System.in);
        while (true){
            cleanConsole();
            imprimirFicheiro("src/imagens/Cama.txt");
            char opcao;
            System.out.println("\n\n                                                       ::::: Desejas Dormir para recuperar Chakra :::::                                                           ");
            System.out.println("                                                                         \uD83D\uDE34\uD83D\uDECC\uD83C\uDF19\uD83D\uDCA4\uD83D\uDE2A");
            System.out.println("                                                                      10H = +100 Chakra");
            System.out.println("\n\n\n");
            System.out.println("                             ✅ Sim -         PREMIR: S                                              ❌ Nao  -         PREMIR N                           ");
            System.out.print("\n\n\n\n                                                                    OPCAO: ");
            if (input.hasNextLine()) {
                opcao = input.nextLine().toUpperCase().charAt(0);
                if (opcao == 'S') {
                    System.out.println("Dormindo por 10 longas horas...");
                    sleep(10000);
                    System.out.println("Você recuperou 100 Chakra!");
                    (Jogo.getNaruto()).setChakra((Jogo.getNaruto()).getChakra() + 100);
                } else if (opcao == 'N') {
                    System.out.println("Você decidiu não dormir.");
                    sleep(1500);
                    break;
                } else {
                    System.out.println("Opção inválida. Por favor, tente novamente.");
                    sleep(1500);
                }
            }
        }
    }
}
