package Jogo.Menus;

import Jogo.Jogo;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static Jogo.Menus.Utils.headerKonoha;
import static Jogo.Menus.Utils.headerNovoJogo;
import static Utils.Utils.cleanConsole;
import static Utils.Utils.imprimirFicheiro;
import static java.lang.Thread.sleep;

/**
 * Menu interativo onde o jogador pode optar por descansar
 * para recuperar 100 pontos de chakra.
 */
public class Cama {

    /**
     * Exibe o menu da cama, permitindo ao jogador dormir e recuperar chakra.
     * Dormir restaura +100 pontos de chakra e leva 10 segundos (simulação com sleep).
     *
     * O jogador pode pressionar:
     * - 'S' para dormir
     * - 'N' para sair do menu
     */
    public static void cama() throws InterruptedException, FileNotFoundException {
        Scanner input = new Scanner(System.in);
        while (true) {
            cleanConsole(); // Limpa o terminal
            imprimirFicheiro("src/imagens/Cama.txt"); // Mostra arte ASCII da cama

            // Exibe as instruções e o chakra atual de Naruto
            System.out.println("\n\n                                                       ::::: Desejas Dormir para recuperar Chakra :::::                                                           ");
            System.out.println("                                                                         \uD83D\uDE34\uD83D\uDECC\uD83C\uDF19\uD83D\uDCA4\uD83D\uDE2A");
            System.out.println("                                                                      10H = +100 Chakra");
            System.out.println("                                                                        Chakra: " + Jogo.getNaruto().getChakra());
            System.out.println("\n\n\n");
            System.out.println("                             ✅ Sim -         PREMIR: S                                              ❌ Nao  -         PREMIR N                           ");
            System.out.print("\n\n\n\n                                                                    OPCAO: ");

            // Lê a opção do jogador
            if (input.hasNextLine()) {
                char opcao = input.nextLine().toUpperCase().charAt(0);

                if (opcao == 'S') {
                    // Jogador escolhe dormir
                    System.out.println("Dormindo por 10 longas horas...");
                    sleep(10000); // Simula o tempo de descanso
                    System.out.println("Você recuperou 100 Chakra!");
                    // Atualiza o chakra do Naruto
                    Jogo.getNaruto().setChakra(Jogo.getNaruto().getChakra() + 100);
                } else if (opcao == 'N') {
                    // Sai do menu
                    sleep(1000);
                    break;
                } else {
                    // Tratamento de erro de entrada inválida
                    System.out.println("Opção inválida. Por favor, tente novamente.");
                    sleep(1500);
                }
            }
        }
    }
}
